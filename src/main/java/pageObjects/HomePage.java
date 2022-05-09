package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton(){
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click();
    }

    public void subscribeToNewsLetter(String email){
        WebElement emailInput = driver.findElement(By.id("newsletter-input"));
        emailInput.sendKeys(email);
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
        subscribeButton.click();
    }

    public boolean isAlertDisplayed(){
        WebElement successAlert = driver.findElement(By.className("alert-success"));
        return successAlert.isDisplayed();
    }

    public void searchForHotel(){
        WebElement hotelDropdown = driver.findElement(By.cssSelector("button[data-toggle=\"dropdown\"]"));
        hotelDropdown.click();
        WebElement hotelPrime = driver.findElement(By.className("hotel_name"));
        hotelPrime.click();
        WebElement checkInTime = driver.findElement(By.id("check_in_time"));
        checkInTime.clear();
        checkInTime.sendKeys("11-05-2022");
        WebElement checkOutTime = driver.findElement(By.id("check_out_time"));
        checkOutTime.clear();
        checkOutTime.sendKeys("18-05-2022");
        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
        searchNowButton.click();
    }
}
