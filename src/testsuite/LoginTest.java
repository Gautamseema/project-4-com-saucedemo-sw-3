package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
      // Enter userName on userName field

        sendTextElement(By.id("user-name"),"standard_user" );
        //  Enter password on password field

        sendTextElement(By.id("password"),"secret_sauce");
        //  click on loginButton

        clickOnElement(By.id("login-button"));

        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[@class='title']")) ;
        // Verifying actual and expected text
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter userName on userName field
        sendTextElement(By.id("user-name"),"standard_user" );

        //  Enter password on password field
        sendTextElement(By.id("password"),"secret_sauce");

        //  click on loginButton
        clickOnElement(By.id("login-button"));

        //find the web elements list
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are: " + products.size());
        Assert.assertEquals("",6, products.size());

    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
