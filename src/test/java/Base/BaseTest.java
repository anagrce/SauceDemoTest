package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

//Programming Language: Java
//Web Automation Tool: Selenium WebDriver(latest version)
//WebDriverManager is used for managing the drivers.
//Test Runner: TestNG
//Build Tool: Maven

//all page classes will extend the BaseTest and inherit all base methods
//BaseTest class holds the methods to initialize and terminate the WebDriver object
// the TestClass will simply get the WebDriver object by calling the getDriver() method


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public SauceLabsOnesiePage sauceLabsOnesiePage;
    public YourCartPage yourCartPage;
    public CheckoutPage checkoutPage;
    public OverviewPage overviewPage;
    public CompletePage completePage;



    //setupTests() method does all the instantiation for all the respective pages class,
    // assigns value to the variables using java faker utility and also does navigate to the website

    @BeforeClass
    public void setUp() {
        //we are using Chrome browser because Chrome is the most used browser on desktop 67% worldwide
       // source: https://gs.statcounter.com/browser-market-share/desktop/worldwide
        //if there is a need to run the test on other browsers, we need just to change driver and put it in directory
        // for example gecko driver for Firefox

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,wdwait);
        productsPage = new ProductsPage(driver,wdwait);
        sauceLabsOnesiePage = new SauceLabsOnesiePage(driver,wdwait);
        yourCartPage = new YourCartPage(driver, wdwait);
        checkoutPage = new CheckoutPage(driver, wdwait);
        overviewPage = new OverviewPage(driver, wdwait);
        completePage = new CompletePage(driver, wdwait);



    }
    public void visibilityWait(WebElement element){

        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickabilityWait(WebElement element){

        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown(){
       // driver.close();
      //  driver.quit();
    }
    //I commented this because I don't want for the window to close right after the test,
    // I want to see what the test results are, what was going on during the test process



}
