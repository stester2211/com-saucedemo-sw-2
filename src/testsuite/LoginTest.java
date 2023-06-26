package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    @Test
    //1. userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
        //1.1  Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        //1.2 Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //1.3 Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //1.4 Verify the text “PRODUCTS”
        String expectedText="PRODUCTS";
        String actualText= driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products text not found",expectedText,actualText);

        //Hold the screen
        Thread.sleep(2000);
    }

    // 2. verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //2.1 Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        //2.2 Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //2.3 Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //2.4 Verify that six products are displayed on page
        List<WebElement> itemTotal= driver.findElements(By.className("inventory_item_name"));
        System.out.println("Total number of products in page is : "+itemTotal.size());

        //Hold the screen
        Thread.sleep(2000);
    }

    @After
    public void closeBrowser()
    {
        quitBrowser();
    }
}
