package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement finishButton;

    public OverviewPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }
    //-------------------------------------------

    public void clickOnFinishButton(){
        this.getFinishButton().click();
    }
}
