package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_06_WebBrowser_Commands_02 {
    //Các câu lệnh để thao tác với driver
    //driver.
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Page_URL() {
        // 1. Set trực tiếp - Mở ra một page URL bất kỳ
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click(); //dùng cho xpath
        //  driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click(); //dùng cho CSS
        /* Cách tạo sleep cứng
        try {

            Thread.sleep(1000); //1000ms = 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */

        // trong 1 class có thể từ hàm này call 1 hàm khác
        SleepInSecond(3);

        // kiểm tra
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        // kiểm tra sai
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/loginpt/");

        driver.findElement()
    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSecond(3);

        driver.findElement() SleepInSecond(3);
    }

    @Test
    public void TC_03_Page_Navigation() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSecond(3);
    }


    @Test
    public void TC_04_Page_Source() {

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
