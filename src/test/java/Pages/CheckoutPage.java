package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement firstName;
    WebElement lastName;
    WebElement zipCode;
    WebElement continueButton;


    public CheckoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("first-name"));

    }

    public WebElement getLastName() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }
    //-------------------------------------------------------------

    public void insertFirstName(String firstName){
        this.getFirstName().clear();
        this.getFirstName().sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        this.getLastName().clear();
        this.getLastName().sendKeys(lastName);
    }

    public void insertZipCode(String zipCode){
        this.getZipCode().clear();
        this.getZipCode().sendKeys(zipCode);
    }

    public void clickOnContinueButton(){
        this.getContinueButton().click();
    }

}
