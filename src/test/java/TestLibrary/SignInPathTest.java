package TestLibrary;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class SignInPathTest {

    WebDriver driver;


    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    void hotelLocatorsByIdTest(){
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchRoomButton = driver.findElement(By.id("search_room_submit"));
        WebElement newsletterInput = driver.findElement(By.id("newsletter-input"));

        hotelLocationInput.clear();
        hotelLocationInput.sendKeys("Warsaw");
        newsletterInput.clear();
        newsletterInput.sendKeys("test@test.com");
    }

    @Test
    void hotelLocatorsByNameTest(){
        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));

        hotelLocationInput.clear();
        hotelLocationInput.sendKeys("Warsaw");
        emailInput.clear();
        emailInput.sendKeys("test@test.com");

        searchNowButton.submit();
    }

    @Test
    void signInTest() throws InterruptedException {
        // Zad 3
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click(); // kilkamy w przycisk i przechodzimy na kolejną stronę

        WebElement emailInput = driver.findElement(By.className("account_input")); // nie jest to najlepsza opcja w tym wypadku - lepiej użyć id
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        emailInput.clear();
        String randomEmailInput = createRandomEmail();
        emailInput.sendKeys(randomEmailInput);
        createAccountButton.submit(); // zatwierdzenie formularza i przejście do następnej strony


        // Zad 4
        Thread.sleep(2000); // trzeba poczekać chwilkę aż strona się doładuje

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"customer_lastname\"]"));
        WebElement emailFieldInput = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name=\"passwd\"]"));
        WebElement registerButton = driver.findElement(By.xpath("//button[@name=\"submitAccount\"]"));

        String firstName = null;
        if (firstNameInput.isDisplayed()) { // sprawdzam czy element jest wudoczny
            firstNameInput.clear();
            firstName = "Marian";
            firstNameInput.sendKeys(firstName);
        }
        if (lastNameInput.isDisplayed()) {  // sprawdzam czy element jest wudoczny
            lastNameInput.clear();
            lastNameInput.sendKeys("Jaremski");
        }
        if (emailFieldInput.isDisplayed()) { // sprawdzam czy element jest wudoczny
            System.out.println("Email already provided");
        }
        if (passwordInput.isDisplayed()) { // sprawdzam czy element jest wudoczny
            passwordInput.clear();
            passwordInput.sendKeys("mySecretPassword1");
        }
        if (registerButton.isDisplayed()) { // sprawdzam czy element jest wudoczny
            registerButton.click(); // rejestrujemy użytkownika i przechodzimy do następnej strony
        }

        // Zad 5
        WebElement myPersonalInformationField = driver.findElement(By.cssSelector("a[title='Information'] span")); // znajdujemy pole po css selectorze
        WebElement myAdressesField = driver.findElement(By.cssSelector("a[title='Addresses'] span")); // znajdujemy pole po css selectorze

        WebElement userInfo = driver.findElement(By.id("user_info_acc"));
        String actualUserName = userInfo.getText();

        Assertions.assertEquals(firstName, actualUserName);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    private static String createRandomEmail(){
        Random random = new Random();
        int randomNumber = random.nextInt(10001);
        return  String.format("test%s@test.com", randomNumber);
    }
}
