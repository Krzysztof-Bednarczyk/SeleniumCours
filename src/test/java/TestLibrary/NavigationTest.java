package TestLibrary;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {
    WebDriver driver;

    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
    }

    @Test
    void testChangingWebsites(){
        driver.get("https://coderslab.pl/pl"); // przechodzę na stronę coders lab
        driver.get("https://mystore-testlab.coderslab.pl/index.php"); // przechodzę na stronę myStore
        driver.get("https://hotel-testlab.coderslab.pl/en/"); // przechodzę na stronę hotel-lab
    }

    @Test
    void testNavigationBackAndForward(){
        final String CODERS_LAB_URL = "https://coderslab.pl/pl"; // zapisuję adres strony do stałej - do stałej ponieważ on się nie zmienia
        final String GOOGLE_URL = "https://www.google.com";
        final String MY_STORE_URL = "https://mystore-testlab.coderslab.pl/index.php";

        driver.get(GOOGLE_URL);
        driver.get(CODERS_LAB_URL);
        driver.navigate().back(); // nawigujemy do poprzedniej strony -> google
        driver.get(MY_STORE_URL);
        driver.navigate().back(); // nawigujemy do poprzedniej strony -> google
        driver.navigate().forward(); // nawigujemy do przodu -> myStore
        driver.navigate().refresh(); // odświeżamy stronę myStore
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
