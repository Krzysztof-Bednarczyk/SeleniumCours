package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignIn {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new FirefoxDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki

        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // Zad 3
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click(); // kilkamy w przycisk i przechodzimy na kolejną stronę

        WebElement emailInput = driver.findElement(By.className("account_input")); // nie jest to najlepsza opcja w tym wypadku - lepiej użyć id
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        emailInput.clear();
        emailInput.sendKeys("test1965598@test.com");
        createAccountButton.submit(); // zatwierdzenie formularza i przejście do następnej strony


        // Zad 4
        Thread.sleep(2000); // trzeba poczekać chwilkę aż strona się doładuje

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"customer_lastname\"]"));
        WebElement emailFieldInput = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name=\"passwd\"]"));
        WebElement registerButton = driver.findElement(By.xpath("//button[@name=\"submitAccount\"]"));

        if (firstNameInput.isDisplayed()){ // sprawdzam czy element jest wudoczny
            firstNameInput.clear();
            firstNameInput.sendKeys("Marian");
        }
        if (lastNameInput.isDisplayed()){  // sprawdzam czy element jest wudoczny
            lastNameInput.clear();
            lastNameInput.sendKeys("Jaremski");
        }
        if(emailFieldInput.isDisplayed()){ // sprawdzam czy element jest wudoczny
            System.out.println("Email already provided");
        }
        if (passwordInput.isDisplayed()){ // sprawdzam czy element jest wudoczny
            passwordInput.clear();
            passwordInput.sendKeys("mySecretPassword1");
        }
        if (registerButton.isDisplayed()){ // sprawdzam czy element jest wudoczny
            registerButton.click(); // rejestrujemy użytkownika i przechodzimy do następnej strony
        }

        // Zad 5
        WebElement myPersonalInformationField = driver.findElement(By.cssSelector("a[title='Information'] span")); // znajdujemy pole po css selectorze
        WebElement myAdressesField = driver.findElement(By.cssSelector("a[title='Addresses'] span")); // znajdujemy pole po css selectorze

        WebElement userInfo = driver.findElement(By.id("user_info_acc"));

        System.out.println(userInfo.getText()); // wybieranie textu z elementu
        System.out.println(userInfo.getTagName()); // wybieranie nazwy elementu
        System.out.println(userInfo.getAttribute("data-toggle")); // wybieranie wartości danego atrybutu elementu

        driver.quit();

    }
}
