package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {

  //here I have used credentials that were given on the website
    //usually, I use data driven test where all the data needed for testing is in the excel tabel
    //for this we need to add ExcelReader class in Base package and to add Maven dependency in pom.xml file
    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Ime";
    String lastName = "Prezime";
    String zipCode = "+381";


    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test(priority = 10)

    public void loginTest(){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.clickOnManuButton();
        visibilityWait(productsPage.getLogoutButton());
        Assert.assertTrue(productsPage.getLogoutButton().isDisplayed());

    }
    @Test (priority = 20)
    public void addOneProductToCart(){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        clickabilityWait(productsPage.getAddBackpackToChart());
        productsPage.clickOnAddBackpack();
        Assert.assertEquals(productsPage.getShoppingChartBadge(),"1");

    }
    @Test (priority = 30)
    public void addTwoDiferentProductToCart(){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        clickabilityWait(productsPage.getAddBackpackToChart());
        productsPage.clickOnAddBackpack();
        Assert.assertEquals(productsPage.getShoppingChartBadge(),"1");
        scrollIntoView(productsPage.getAddToCartSauceLabsOnesie());
        productsPage.clickOnSauceLabsOnies();
        sauceLabsOnesiePage.clickOnAddToCartButton();
        sauceLabsOnesiePage.clickOnShoppingCart();
        Assert.assertEquals(yourCartPage.getShoppingCartCount(), "2");
        Assert.assertEquals(yourCartPage.getInventoryItem(), "Sauce Labs Backpack");
    }
    @Test (priority = 40)

    public void addTwoProductAndDeleteOneFromTheCart(){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        clickabilityWait(productsPage.getAddBackpackToChart());
        productsPage.clickOnAddBackpack();
        Assert.assertEquals(productsPage.getShoppingChartBadge(),"1");
        scrollIntoView(productsPage.getAddToCartSauceLabsOnesie());
        productsPage.clickOnSauceLabsOnies();
        sauceLabsOnesiePage.clickOnAddToCartButton();
        sauceLabsOnesiePage.clickOnShoppingCart();
        Assert.assertEquals(yourCartPage.getShoppingCartCount(), "2");
        Assert.assertEquals(yourCartPage.getInventoryItem(), "Sauce Labs Backpack");
        yourCartPage.clickOnSauceLabsBackpackRemoveButton();
        Assert.assertEquals(yourCartPage.getShoppingCartCount(), "1");
        Assert.assertEquals(yourCartPage.getInventoryItem(), "Sauce Labs Onesie");
    }

    //Test can be run one by one or we can run one EndToEnd test with all the requirements from the task
    //priority means witch test will be run first

    @Test (priority = 50)
    public void testEndToEnd(){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        clickabilityWait(productsPage.getAddBackpackToChart());
        productsPage.clickOnAddBackpack();
        Assert.assertEquals(productsPage.getShoppingChartBadge(),"1");
        scrollIntoView(productsPage.getAddToCartSauceLabsOnesie());
        productsPage.clickOnSauceLabsOnies();
        sauceLabsOnesiePage.clickOnAddToCartButton();
        sauceLabsOnesiePage.clickOnShoppingCart();
        Assert.assertEquals(yourCartPage.getShoppingCartCount(), "2");
        Assert.assertEquals(yourCartPage.getInventoryItem(), "Sauce Labs Backpack");
        yourCartPage.clickOnSauceLabsBackpackRemoveButton();
        Assert.assertEquals(yourCartPage.getShoppingCartCount(), "1");
        Assert.assertEquals(yourCartPage.getInventoryItem(), "Sauce Labs Onesie");
        yourCartPage.clickOnCheckoutButton();
        checkoutPage.insertFirstName(firstName);
        checkoutPage.insertLastName(lastName);
        checkoutPage.insertZipCode(zipCode);
        checkoutPage.clickOnContinueButton();
        overviewPage.clickOnFinishButton();
        Assert.assertEquals(completePage.getThankYouForOrderMessage(), "THANK YOU FOR YOUR ORDER");

    }
}
