package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAccountPage {

    private WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAccount(String firstName, String lastName, String password){
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
    }
}
