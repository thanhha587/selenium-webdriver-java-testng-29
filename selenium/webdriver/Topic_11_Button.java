package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_11_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.xpath("//a[text()='Đăng nhập']/parent::li")).click();
        SleepInSecond(1);

        Assert.assertFalse(driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).isEnabled());
        //636363

        WebElement print = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));

        System.out.println("Mã RGB color là: "+ print.getCssValue("background-color"));
        //Convert từ rgb qua hexa
        Color color = Color.fromString(print.getCssValue("background-color"));
        System.out.println("Mã Hexa color là:"+ color.asHex());
       //#636363;
        Assert.assertEquals(color.asHex(),"#000000");
        Assert.assertEquals(color.asRgba(),"rgba(0, 0, 0, 0)");

        //Input data
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0987354678");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("0987354678abc@#");
        SleepInSecond(1);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).isEnabled());
        color = Color.fromString(print.getCssValue("background"));
        System.out.println("Màu thay đổi mã Hex là:"+color.asHex());
        System.out.println("Màu thay đổi mã Rgba là:"+color.asRgb());
        Assert.assertEquals(color.asHex().toUpperCase(),"#C92127");
        Assert.assertEquals(color.asRgb(),"rgb(201, 33, 39)");
    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {driver.quit();
    }

    public void SleepInSecond(long timeinSecond) {
        try {
            Thread.sleep(1000 * timeinSecond); //1000ms = 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

