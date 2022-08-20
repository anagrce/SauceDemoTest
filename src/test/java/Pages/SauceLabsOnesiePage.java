package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLabsOnesiePage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement addToCartButton;
    WebElement shoppingCartContainer;

    public SauceLabsOnesiePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    }

    public WebElement getShoppingCartContainer() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
    //---------------------------------------------------------------

    public void clickOnAddToCartButton(){
        this.getAddToCartButton().click();
    }
    public void clickOnShoppingCart(){
        this.getShoppingCartContainer().click();
    }
}
