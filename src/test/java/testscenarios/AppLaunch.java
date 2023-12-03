package testscenarios;

import application.components.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AppLaunch extends BaseTest {

@Test
    public void landingPage() throws IOException {

        driver = initializeDriver();
        String baseURL = "https://www.saucedemo.com/v1/";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.quit();

    }

}
