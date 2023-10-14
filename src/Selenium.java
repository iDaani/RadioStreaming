import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Selenium {

    static Logger logger = Logger.getLogger(Selenium.class.getName());

    static MySQLDao dao;
    static String songURL;
    static String songId;
    static String songTitle;

    public static void main(String[] args) throws RuntimeException {
        long start = System.currentTimeMillis();
        logger.setLevel(Level.WARNING);

        try {
            logger.addHandler(new FileHandler("./logs/logs.log"));



            // Start connection with MySQL Database using DAO
            // If the connection can't be made, throw an exception
            if (startConnection(StoreSongsFromStream.USERNAME, StoreSongsFromStream.PASSWORD, StoreSongsFromStream.TABLE_NAME)) {
                throw new SQLException("Unable to connect to the database!");
            }

            do {
                // If this is second or third loop, wait for a minute before resuming the program. This is to
                // give time for the song to possibly change
                if (!StoreSongsFromStream.isProgramRunningForFirstTime) {
                    Thread.sleep(StoreSongsFromStream.ONE_MINUTE);
                }

                HashMap<String, String> song = dao.getNotDownloadedSongs();

                if (song.isEmpty()) {
                    break;
                }

                getSongDetails(song);









            } while ((System.currentTimeMillis() - start) <= StoreSongsFromStream.THREE_HOURS);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error found", e);
            throw new RuntimeException(e);
        }

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
     * Get all the song details from song.
     */
    private static void getSongDetails(HashMap<String, String> song) {
        songId = song.get("Song ID");
        songTitle = song.get("Song Title");
        songURL = song.get("Song URL");
    }

    private static void doSeleniumThings() {

        System.setProperty("webdriver.gecko.driver", "C:\\ProgramData\\geckodriver./geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://spotifydown.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.cssSelector(".searchInput"));
        textBox.sendKeys("https://spotifydown.com/");
    }


}
