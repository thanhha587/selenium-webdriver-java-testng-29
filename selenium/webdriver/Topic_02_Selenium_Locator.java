package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Sean");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }
    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_Linktext() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Form() {
        driver.findElement(By.partialLinkText("vendor account"));
        driver.findElement(By.partialLinkText("Apply for vendor"));
    }

    @Test
    public void TC_07_Css() {
        //Css vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css vs Class
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css vs tagname
        driver.findElement(By.cssSelector("input"));

        //Css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        //Css vs partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
        //driver.findElement(By.cssSelector("a[href$='addresses']"));
    }

    @Test
    public void TC_08_XPath() {
        //XPath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        //k viết gọn đc

        //XPath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        // k rút gọn đc

        //XPath vs Class
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //XPath vs tagname
        driver.findElement(By.xpath("//input"));

        //XPath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        //XPath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'/addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
