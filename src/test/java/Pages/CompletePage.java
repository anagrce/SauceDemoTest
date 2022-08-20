package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletePage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement thankYouForOrderMessage;

    public CompletePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getThankYouForOrderMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
}
