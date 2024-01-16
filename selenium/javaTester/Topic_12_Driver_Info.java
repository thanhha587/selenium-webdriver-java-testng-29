package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_12_Driver_Info {
    WebDriver driver;

    @Test
    public void testDriverInformation() {
        driver = new FirefoxDriver();
        // Ở trên OS nào
        // Browser nào
        // Browser class
        // ID của driver là gì
        // FirefoxDriver: firefox on mac (b4e17265-b1b6-43db-a1a3-a9ed11cf897c)

        System.out.println(driver.toString());

        if (driver.toString().contains("firefox")) {
            //Scroll
        }
        driver.quit();
    }

}
