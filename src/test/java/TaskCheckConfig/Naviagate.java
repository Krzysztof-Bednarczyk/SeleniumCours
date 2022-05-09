package TaskCheckConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naviagate {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki

        driver.get("https://coderslab.pl/pl"); // przechodzę na stronę coders lab
        driver.get("https://mystore-testlab.coderslab.pl/index.php"); // przechodzę na stronę myStore
        driver.get("https://hotel-testlab.coderslab.pl/en/"); // przechodzę na stronę hotel-lab
        driver.quit();
    }
}
