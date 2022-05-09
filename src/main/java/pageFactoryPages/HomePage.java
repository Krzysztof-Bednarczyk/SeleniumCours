package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // inicjalizacja PageFactory
    }

    @FindBy(className = "user_login")
    WebElement signInButton;

    @FindBy(id = "newsletter-input")
    WebElement emailInput;

    @FindBy(name = "submitNewsletter")
    WebElement subscribeButton;

    @FindBy(className = "alert-success")
    WebElement successAlert;

    @FindBy(css = "button[data-toggle=\"dropdown\"]")
    WebElement hotelDropdown;

    @FindBy(className = "hotel_name")
    WebElement hotelPrime;

    @FindBy(id = "check_in_time")
    WebElement checkInTime;

    @FindBy(id = "check_out_time")
    WebElement checkOutTime;

    @FindBy(id = "search_room_submit")
    WebElement searchNowButton;


    public void clickSignInButton(){
        signInButton.click();
    }

    public void subscribeToNewsLetter(String email){
        emailInput.sendKeys(email);
        subscribeButton.click();
    }

    public boolean isAlertDisplayed(){
        return successAlert.isDisplayed();
    }

    public void searchForHotel(){
        hotelDropdown.click();
        hotelPrime.click();
        checkInTime.clear();
        checkInTime.sendKeys("11-05-2022");
        checkOutTime.clear();
        checkOutTime.sendKeys("18-05-2022");
        searchNowButton.click();
    }


}
