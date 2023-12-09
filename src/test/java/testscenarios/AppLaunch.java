package testscenarios;

import application.components.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AppLaunch extends BaseTest {
    String baseURL = "https://www.saucedemo.com/v1/";
@Test
    public void landingPage() throws IOException {

        driver = initializeDriver();

        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.quit();


    }
    @Test
    public void LoginValidation() throws IOException {
        driver = initializeDriver();
        driver.get(baseURL);
        String actualMessage = "Epic sadface: Usename is required";
        driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]")).click();
        String errorMessage =driver.findElement(By.xpath("//h3")).getText();
        System.out.println(errorMessage);
        //Assert.assertEquals(actualMessage,errorMessage);
        if(actualMessage.equalsIgnoreCase(errorMessage)){
            System.out.println("The error is proper");
        }
        else{
            System.out.println("The error is not proper");
        }
        driver.quit();
    }

    @Test
    public void productValidation() throws IOException{
        driver = initializeDriver();
        System.out.println("Browser name is :"+browserName);
        driver.get(baseURL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");//for username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");//for password
        driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]")).click();//for loginbutton
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));//find product title after login
        String productText=driver.findElement(By.className("product_label")).getText();
        System.out.print(productText);
        driver.quit();

    }



}
