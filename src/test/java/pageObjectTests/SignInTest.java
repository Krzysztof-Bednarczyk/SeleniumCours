package pageObjectTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AccountDetailsPage;
import pageObjects.HomePage;
import pageObjects.NewAccountPage;
import pageObjects.RegisterPage;
import pageObjects.SearchResultsPage;


import java.util.List;
import java.util.Random;

public class SignInTest {

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
    void clickSignIn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        RegisterPage registerPage = new RegisterPage(driver);
        String randomEmail = createRandomEmail();
        registerPage.registerAccount(randomEmail);
    }

    @Test
    void subscribeToNewsletter() {
        HomePage homePage = new HomePage(driver);
        String randomEmail = createRandomEmail();
        homePage.subscribeToNewsLetter(randomEmail);
        boolean isAlertDisplayed = homePage.isAlertDisplayed();
        Assertions.assertTrue(isAlertDisplayed); // sprawdzamy czy pojawi się odpowiedni alert
    }

    @Test
    void searchForHotels() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForHotel();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> resultHeadings = searchResultsPage.getResultHeadings();
        org.assertj.core.api.Assertions.assertThat(resultHeadings).contains("Delux Rooms"); // asercja z biblioteki AssertJ
    }

    @Test
    void registerUser() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        RegisterPage registerPage = new RegisterPage(driver);
        String randomEmail = createRandomEmail();
        registerPage.registerAccount(randomEmail);
        Thread.sleep(2000);
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.createNewAccount("Grzegorz", "Tomasik", "randomPassowrd125");
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        boolean isSuccessAlertDisplayed = accountDetailsPage.isSuccessAlertDisplayed();
        Assertions.assertTrue(isSuccessAlertDisplayed); // sprawdzamy czy zielony alert się pojawił na stronie
        String actualUserName = accountDetailsPage.getUserName();
        Assertions.assertEquals("Grzegorz", actualUserName); // werufikujemy imię użytkownika
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    private static String createRandomEmail() {
        Random random = new Random();
        int randomNumber = random.nextInt(10001);
        return String.format("test%s@test.com", randomNumber);
    }
}
