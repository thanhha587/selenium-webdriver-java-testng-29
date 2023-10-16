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
        System.out.println("TC_01_Page_URL");
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
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

        //kiểm tra sai
        Assert.assertNotEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/loginiu/");

    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/");
        System.out.println("TC_02_Page_Title");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSecond(3);
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        SleepInSecond(3);
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());
    }

    @Test
    public void TC_03_Page_Navigation() {
        System.out.println("TC_03_Page_Navigation");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

        driver.navigate().back();
        //SleepInSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

        driver.navigate().forward();
        //SleepInSecond(3);
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());


    }


    @Test
    public void TC_04_Page_Source() {
        System.out.println("TC_04_Page_Source");
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
        System.out.println("Title trang hiện tại là: " + driver.getTitle());
        System.out.println("URL trang hiện tại là: " + driver.getCurrentUrl());

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
