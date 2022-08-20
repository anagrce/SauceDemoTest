package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement addBackpackToChart;
    WebElement addBoltTShirt;
    WebElement shoppingChartBadge;
    WebElement shoppingClassContainer;
    WebElement addToCartSauceLabsOnesie;
    WebElement pageProducts;
    WebElement manuButton;
    WebElement logoutButton;

    public ProductsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddBackpackToChart() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getAddBoltTShirt() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    }

    public String getShoppingChartBadge() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }

    public WebElement getShoppingClassContainer() {
        return driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
    }

    public WebElement getAddToCartSauceLabsOnesie() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    }

    public List<WebElement> getPageProducts() {
        return driver.findElements(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
    }

    public WebElement getManuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
    }
    //-----------------------------------------------------------------

    public void clickOnAddBackpack() {
        this.getAddBackpackToChart().click();
    }

    public void clickOnAddBoltTShirt() {
        this.getAddBoltTShirt().click();
    }

    public void clickOnShoppingClassContainer() {
        this.getShoppingClassContainer().click();
    }

   public void clickOnSauceLabsOnies() {
       for (int i = 0; i < getPageProducts().size(); i++) {

           if (getPageProducts().get(i).getText().equals("Sauce Labs Onesie")) {
               getPageProducts().get(i).click();
               break;
           }
       }
   }
   public void clickOnManuButton(){
        this.getManuButton().click();
   }
}
