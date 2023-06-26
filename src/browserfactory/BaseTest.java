package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest
{
    public String baseUrl="https://www.saucedemo.com/";
    public WebDriver driver;
    public String browser="Chrome";

    public void setUpBrowser()
    {
        //launch the browser
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
            driver=new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Enter only Chrome, Edge or Firefox browser for texting");
        }

        // OpenUrl
        driver.get(baseUrl);

        //Maximize the browser screen
        driver.manage().window().maximize();

        //Implicit wait Time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //Close browser
    public void quitBrowser()
    {
        driver.quit();
    }
}
