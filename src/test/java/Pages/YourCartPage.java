package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YourCartPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement sauceLabsBackpackRemoveButton;
    WebElement shoppingCartCount;
    WebElement inventoryItem;
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSauceLabsBackpackRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public String getShoppingCartCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }

    public List<WebElement> getInventoryItemName() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public String getInventoryItem() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }
    //------------------------------------------------------

    public void clickOnSauceLabsBackpackRemoveButton(){
        this.getSauceLabsBackpackRemoveButton().click();
    }

    public void clickOnCheckoutButton(){
        this.getCheckoutButton().click();
    }
}
