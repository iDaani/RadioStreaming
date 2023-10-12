import okhttp3.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://stackoverflow.com/questions/4351582/record-streaming-audio-in-java
 *
 * https://forum.freecodecamp.org/t/how-do-you-find-out-the-bitrate-of-an-audio-stream/467558/2
 */
public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    static File musicFile;

    public static void main(String[] args) {
        logger.setLevel(Level.WARNING);

        try{
            logger.addHandler(new FileHandler("./logs/logs.log"));

            // Getting the connection to stream

            URLConnection conn = new URL("https://stream.zeno.fm/bg2umhl91ewvv").openConnection();
            InputStream is = conn.getInputStream();
            logger.info("Connection to stream made");

            // Creating the music file
            musicFile = new File("./songs/output.mp3");
            OutputStream outstream = new FileOutputStream(musicFile);

            // Setting the time limit
            byte[] buffer = new byte[4096];

            // Saving the music file
            int len;
            long t = System.currentTimeMillis();
            while ((len = is.read(buffer)) > 0 && System.currentTimeMillis() - t <= 5000) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
            is.close();
            logger.info("File downloaded");

            // Getting all the song details in an XML format
            File songDetails = interactWithApi();

            // If no song details found
            if (songDetails.length() == 0) {
                logger.warning("Song cannot be found in record");
            } else {

            }


        }
        catch(Exception e){
            logger.log(Level.SEVERE, "Error found", e);
            System.out.print(e);
        }
    }

    private static File interactWithApi() {

        try {
            MediaType MEDIA_TYPE_MP3 = MediaType.get("audio/mpeg; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody data = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("api_token", "f1e7515045eae8aea47ee8aaa949382c")
                    .addFormDataPart("file", musicFile.getName(), RequestBody.Companion.create(musicFile, MEDIA_TYPE_MP3))
                    .addFormDataPart("return", "spotify").build();

            Request request = new Request.Builder().url("https://api.audd.io/").post(data).build();
            Response response = null;
            response = client.newCall(request).execute();
            String result = null;
            result = response.body().string();
            System.out.println(result);

            FileWriter fileWriter = new FileWriter("./output.json");
            fileWriter.write(result);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Cannot interact with API", e);
        }

        return new File("./output.json");
    }
}