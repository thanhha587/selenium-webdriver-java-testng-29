package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Topic_21_Uploadfile {
    WebDriver driver;
   // hcmFilePath = ;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.cssSelector("input[name='files[]']");

//        driver.findElement(uploadBy).sendKeys(hcmFilePath);
//        SleepInSecond(2);
//        driver.findElement(uploadBy).sendKeys(hnFilePath);
//        SleepInSecond(2);
//        driver.findElement(uploadBy).sendKeys(dnFilePath);
        SleepInSecond(2);

        List<WebElement> startButton = driver.findElements(By.cssSelector("td>button.start"));
        //Dùng for này khi có thêm điều kiện if lồng vào sẽ tiện hơn
        for (int i = 0; i <startButton.size(); i++) {
            if (startButton.get(i).isDisplayed()){
            startButton.get(i).click();
            SleepInSecond(2);
            }
        }

        //for each
        for (WebElement button:startButton){
            button.click();
            SleepInSecond(2);
        }


    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void SleepInSecond(long timeinSecond) {
        try {
            Thread.sleep(1000 * timeinSecond); //1000ms = 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

