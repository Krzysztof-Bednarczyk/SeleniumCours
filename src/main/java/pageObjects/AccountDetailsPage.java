package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDetailsPage {

    private WebDriver driver;

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessAlertDisplayed(){
        WebElement successAlert = driver.findElement(By.className("alert-success"));
        return successAlert.isDisplayed();
    }

    public String getUserName(){
        WebElement userInfoButton = driver.findElement(By.id("user_info_acc"));
        return  userInfoButton.getText();
    }
}
