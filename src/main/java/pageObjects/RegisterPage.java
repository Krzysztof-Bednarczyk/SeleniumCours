package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAccount(String email){
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement registerButton = driver.findElement(By.id("SubmitCreate"));
        registerButton.click();
    }
}
