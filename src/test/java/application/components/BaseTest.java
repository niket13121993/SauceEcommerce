package application.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public String browserName;
    // creating a webdriver method for initializing it
    public WebDriver initializeDriver() throws IOException {
         browserName= "chrome";
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        return driver;
        // we will return the driver with the value
     }

//     @BeforeMethod(description = "Start of Application")
//    public LandingPage launchApplication() throws IOException {
//
//         driver = initializeDriver();
//         //landingPage = new LandingPage(driver);
//         //landingPage.goTo();
//         return LandingPage;
//     }
     }



