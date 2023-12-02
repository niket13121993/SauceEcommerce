import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Testsauce {

    WebDriver driver = new ChromeDriver();
    @Test
    public void start(){
    driver.get("https://www.saucedemo.com/v1/");
    driver.quit();
    }
}
