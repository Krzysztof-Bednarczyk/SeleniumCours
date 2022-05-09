package cucumberTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearch {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get("http://www.google.com"); // wpisujemy adres strony i przechodzimy na tę stronę
        WebElement confirmButton = driver.findElement(By.id("L2AGLb")); // znajdujemy element guzika "Zgadzam się"
        confirmButton.click(); // klikamy w guzik "Zgadzam się"
    }

    @When("^a keyword (.*) is entered in input field")
    public void addKeyword(String keyword){ // przekazanie parametru z pliku google-text-search.feature
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys(keyword); // wywołanie parametru
        searchBar.submit();
    }

    @Then("^the first one should contain (.*)")
    public void theFirstOneShouldContainKeyword(String expectedText){ // przekazanie parametru z pliku google-text-search.feature
        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3.LC20lb"));
        String actualText = searchResults.get(0).getText();
        Assertions.assertThat(actualText).isEqualTo(expectedText); // wywołanie parametru
    }

    @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }
}
