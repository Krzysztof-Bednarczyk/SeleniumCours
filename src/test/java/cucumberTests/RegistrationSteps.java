package cucumberTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AccountDetailsPage;
import pageObjects.HomePage;
import pageObjects.NewAccountPage;
import pageObjects.RegisterPage;

import java.util.Random;

public class RegistrationSteps {

    private WebDriver driver;

    @Given("user is on home page")
    public void openHomePage(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @And("user clicks signIn button")
    public void clickSignInButton(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
    }

    @And("user provides email")
    public void provideEmail() throws InterruptedException {
        String randomEmail = createRandomEmail();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccount(randomEmail);
        Thread.sleep(2000);
    }

    @When("^user fills out form: (.*) (.*) (.*)")
    public void fillForm(String firstName, String lastName, String password){
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.createNewAccount(firstName, lastName, password);
    }

    @Then("^user is successfully registered as (.*)")
    public void verifyRegistartion(String expectedName){
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        boolean isAlertDisplayed = accountDetailsPage.isSuccessAlertDisplayed();
        Assertions.assertThat(isAlertDisplayed).isTrue();
        String actualName = accountDetailsPage.getUserName();
        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @And("browser is closed")
    public void closeBrowser(){
        driver.quit();
    }

    private static String createRandomEmail() {
        Random random = new Random();
        int randomNumber = random.nextInt(10001);
        return String.format("test%s@test.com", randomNumber);
    }
}
