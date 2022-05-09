package TaskCheckConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForward {



    public static void main(String[] args) {
        final String CODERS_LAB_URL = "https://coderslab.pl/pl"; // zapisuję adres strony do stałej - do stałej ponieważ on się nie zmienia
        final String GOOGLE_URL = "https://www.google.com";
        final String MY_STORE_URL = "https://mystore-testlab.coderslab.pl/index.php";


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get(GOOGLE_URL);
        driver.get(CODERS_LAB_URL);
        driver.navigate().back(); // nawigujemy do poprzedniej strony -> google
        driver.get(MY_STORE_URL);
        driver.navigate().back(); // nawigujemy do poprzedniej strony -> google
        driver.navigate().forward(); // nawigujemy do przodu -> myStore
        driver.navigate().refresh(); // odświeżamy stronę myStore
        driver.quit();
    }
}
