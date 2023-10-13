import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.codemodel.JCodeModel;
import jsonFiles.ApiResult;
import jsonFiles.Result;
import okhttp3.*;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://stackoverflow.com/questions/4351582/record-streaming-audio-in-java
 * <p>
 * https://forum.freecodecamp.org/t/how-do-you-find-out-the-bitrate-of-an-audio-stream/467558/2
 */
public class StoreSongsFromStream {

    static final String STREAM_LINK = "https://stream.zeno.fm/bg2umhl91ewvv";
    static final long ONE_MINUTE = 60000;
    static final long THREE_HOURS = 10800000;
    static final String USERNAME = "";
    static final String PASSWORD = "";
    static final String TABLE_NAME = "";
    static final String API_TOKEN = "f1e7515045eae8aea47ee8aaa949382c";
    static final String MP3_FILE_LOCATION = "./songs/output.mp3";
    static final String JSON_FILE_LOCATION = "./src/jsonFiles/output.json";
    static Logger logger = Logger.getLogger(StoreSongsFromStream.class.getName());
    static File musicFile;
    static MySQLDao dao;
    static ObjectMapper mapper = new ObjectMapper();
    static String songTitle;
    static String artistName;
    static String spotifyTrackUrl;
    static File songDetails;
    static boolean isProgramRunningForFirstTime = true;

    public static void main(String[] args) throws SQLException {
        long start = System.currentTimeMillis();
        logger.setLevel(Level.WARNING);
        int counter = 0;

        // Run the loop till three hours have passed
        do {
            try {
                logger.addHandler(new FileHandler("./logs/logs.log"));

                // If this is second or third loop, wait for a minute before resuming the program. This is to
                // give time for the song to possibly change
                if (!isProgramRunningForFirstTime) {
                    Thread.sleep(ONE_MINUTE);
                }

                // Getting input stream and converting it to the file
                getInputStreamAndConvertToFile();

                // Getting all the song details in an XML format
                songDetails = interactWithApi();

                // Converting to Java Class
                convertJsonToJavaClass(songDetails.toURI().toURL(), new File("./src/"),
                        "jsonFiles", "apiResult");


                // Converting the JSON file to a Java readable Class
                ApiResult result = mapper.readValue(songDetails, ApiResult.class);

                // If the API cannot match song to any other song, skip to next
                if (result.getResult().toString().equals("null")) {
                    postLoopExecutionCommands();
                    continue;
                }

                // Following code executes when there is a match for the song

                // Getting the 'result' Data from JSON
                Result songSearchResult = result.getResult();

                // Getting all the important song details we need
                getSongDetails(songSearchResult);

                // Start connection with MySQL Database using DAO
                // If the connection can't be made, throw an exception
                if (!startConnection(USERNAME, PASSWORD, TABLE_NAME)) {
                    throw new SQLException("Unable to connect to the database!");
                }

                // Following code executes after successful connection to the MySQL database

                // Check if the song details we have already exists in the database. If yes, skip to next loop
                if (doesSongAlreadyExist(songTitle, artistName)) {
                    postLoopExecutionCommands();
                    continue;
                }

                counter++;


                // Add song to database and check if SQL Database reflects the same
                // If not, add a warning to logs and skip to next song in hopes it gets fixed
                if (!addSongAndCheckIfAdded(counter, songTitle, artistName, spotifyTrackUrl)) {
                    logger.warning(String.format("Following song has not been added - Song Title: %s, Artist Name: %s, Spotify URL: %s",
                            songTitle, artistName, spotifyTrackUrl));
                    postLoopExecutionCommands();
                    continue;
                }

                // post execution of everything
                postLoopExecutionCommands();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error found", e);
                System.out.print(e);
            }
        } while ((System.currentTimeMillis() - start) <= THREE_HOURS);

        dao.closeConnection();
        System.exit(0);
    }

    /**
     * Deleting the file and making sure to notify the loop is not first.
     */
    private static void postLoopExecutionCommands() {
        songDetails.delete();
        isProgramRunningForFirstTime = false;
    }

    /**
     * Connecting to Input Stream and recording some time of it, before saving it as a MP3.
     *
     * @throws IOException
     */
    private static void getInputStreamAndConvertToFile() throws IOException {

        try {

            // Getting the connection to stream
            URLConnection conn = new URL(STREAM_LINK).openConnection();
            InputStream is = conn.getInputStream();
            logger.info("Connection to stream made");

            // Creating the music file
            musicFile = new File(MP3_FILE_LOCATION);
            OutputStream outstream = new FileOutputStream(musicFile);

            // Setting the time limit
            byte[] buffer = new byte[4096];

            // Saving the music file
            int len;
            long t = System.currentTimeMillis();
            while ((len = is.read(buffer)) > 0 && System.currentTimeMillis() - t <= 5000) {
                outstream.write(buffer, 0, len);
            }

            // Deleting the input stream
            outstream.close();
            logger.info("File downloaded");
        } catch (IOException e) {
            logger.severe("Issue with stream! - " + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Interacting with AudD API to get song details from MP3 file and save it as a JSON file.
     *
     * @return
     */
    private static File interactWithApi() {

        try {
            MediaType MEDIA_TYPE_MP3 = MediaType.get("audio/mpeg; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody data = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("api_token", API_TOKEN)
                    .addFormDataPart("file", musicFile.getName(), RequestBody.Companion.create(musicFile, MEDIA_TYPE_MP3))
                    .addFormDataPart("return", "spotify").build();

            Request request = new Request.Builder().url("https://api.audd.io/").post(data).build();
            Response response = null;
            response = client.newCall(request).execute();
            String result = null;
            result = response.body().string();
            System.out.println(result);

            FileWriter fileWriter = new FileWriter(JSON_FILE_LOCATION);
            fileWriter.write(result);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Cannot interact with API", e);
        }

        return new File(JSON_FILE_LOCATION);
    }

    /**
     * Converting Json file to Java Class.
     */
    private static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName)
            throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

        jcodeModel.build(outputJavaClassDirectory);
    }

    /**
     * Getting song details and setting the parameters of title, artist name and Spotify track URL.
     */
    private static void getSongDetails(Result songDetails) {
        songTitle = songDetails.getTitle();
        artistName = songDetails.getArtist();
        spotifyTrackUrl = songDetails.getSpotify().getExternalUrls().getSpotify();
    }

    /**
     * Using DAO to connect to MySQL Database.
     */
    private static boolean startConnection(String username, String pwd, String tableName) throws SQLException {
        dao = new MySQLDao(username, pwd, tableName);
        dao.start(username, pwd, tableName);
        return dao.connect();
    }

    /**
     * Get song if it exists from the MySQL Database using DAO.
     */
    private static HashMap<String, String> getSong(String songTitle, String artistName) throws SQLException {
        HashMap<String, String> resultQuery = dao.getQuery(songTitle, artistName);
        return resultQuery;
    }

    /**
     * Check if the song already exists in teh database.
     */

    private static boolean doesSongAlreadyExist(String songTitle, String artistName) throws SQLException {

        HashMap<String, String> existingSongsList = getSong(songTitle, artistName);

        if (existingSongsList.isEmpty()) {
            return false;
        } else {
            logger.info(String.format("Song already exists with - song title: %s, artist name: %s, spotifyURL: %s",
                    existingSongsList.get("Artist Name"), existingSongsList.get("Song Title"),
                    existingSongsList.get("Song URL")));
            return true;
        }
    }

    /**
     * Add song to MySQL Database and return true if added, else false.
     */
    private static boolean addSongAndCheckIfAdded(int counter, String songTitle, String artistName, String spotifyTrackUrl) throws SQLException {

        return dao.updateQuery(counter, songTitle, artistName, spotifyTrackUrl) == 1;

    }

}