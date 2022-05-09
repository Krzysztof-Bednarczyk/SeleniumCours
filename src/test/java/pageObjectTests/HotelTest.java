package pageObjectTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactoryPages.HomePage;

public class HotelTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    void hotelSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.searchForHotel();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
