package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getResultHeadings(){
        List<WebElement> headingsList = driver.findElements(By.className("rm_heading"));
        return headingsList.stream().map(webElement -> webElement.getText()).collect(Collectors.toList()); // wyciągamy napisy z listy nagłówków i zapisujemy je do nowej listy
    }
}
