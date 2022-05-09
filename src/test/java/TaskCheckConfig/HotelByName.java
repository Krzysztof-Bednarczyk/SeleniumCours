package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelByName {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki

        driver.get("https://hotel-testlab.coderslab.pl/en/");

        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));

        hotelLocationInput.clear();
        hotelLocationInput.sendKeys("Warsaw");
        emailInput.clear();
        emailInput.sendKeys("test@test.com");

        searchNowButton.submit();
        driver.quit();


    }
}
