package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // I have used Page Object Model for writing the tests,
    // as it helps organizing the tests, maintenance and easy readability and reuse

    //a class is created for every webpage where all the related elements
    // of the respective page is stored and also the relevant action methods are created inside that class

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement loginButton;

    //this is a constructor which takes WebDriver and WebDriverWait
    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    // first task is to find the locators on the login page
    // getters for our WebElement
    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    //-------------------------------------------------------------------------------------

    //methods for WebElements. These are actions on WebElements

    public void insertUsername(String username){
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }
    public void insertPassword(String password){
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }
    public void clickOnLoginButton(){
        this.getLoginButton().click();
    }

}
