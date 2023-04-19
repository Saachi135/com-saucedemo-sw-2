package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //  Verify the text “PRODUCTS”
        String expectedText = "Products";
        WebElement actualTextOnWebPage = driver.findElement(By.className("title"));
        String actualText = actualTextOnWebPage.getText();
        Assert.assertEquals("PRODUCT text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page
        int expectedNumberOfProducts = 6;
        List<WebElement> productList = driver.findElements(By.xpath("//img[starts-with(@class,'inventory_item_img')]"));
        int actualNumberOfProducts = productList.size();
        Assert.assertEquals("Number of Products are not same", expectedNumberOfProducts, actualNumberOfProducts);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}