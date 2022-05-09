package TestLibrary;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyFirstJUnitTest {

    @Test
    @Order(1)
    void myFirstTest(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get("http://www.google.com"); // wpisujemy adres strony i przechodzimy na tę stronę
        WebElement confirmButton = driver.findElement(By.id("L2AGLb")); // znajdujemy element guzika "Zgadzam się"
        confirmButton.click(); // klikamy w guzik "Zgadzam się"
        WebElement element = driver.findElement(By.name("q")); // znajdujemy elemenst search input(okno szukania)
        element.clear(); // czyścimy input
        element.sendKeys("Skoki narciarskie"); // wpisujemy w okno szukania słowo CodersLab
        element.submit(); // zatwierdzamy nasz wybór
        driver.quit(); // driver kończy pracę, okno przeglądarki się zamyka

    }

    @Test
    @Order(2)
    void mySecondTest(){
        System.out.println("It works!");
    }
}
