package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Topic_09_Default_Dropdown {
    WebDriver driver;
    String firstName = "Hally", lastName = "Naughty", emailAddress = getEmailAddress();
    String companyName = "Cypress", password = "2234567";
    String date = "20", month = "May", year = "1987";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void TC_01_Register() {
        System.out.println("TC_01_Register");

        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-female")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);

        Select date = new Select(driver.findElement(By.name("DateOfBirthDay")));
        date.selectByVisibleText(this.date);

        //rút gọn nếu k dùng lại k cần khai báo biến
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("May");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1987");

        //verify chọn có đúng k
        Assert.assertEquals(date.getFirstSelectedOption().getText(),"20");
        System.out.println("Day is selected is: " + date.getFirstSelectedOption().getText());
       // Assert.assertEquals(month.getFirstSelectedOption().getText(),"May");
       // Assert.assertEquals(year.getFirstSelectedOption().getText(),"1987");

        //Verify dropdown này là Single ( k phải Multiple)
        Assert.assertFalse(date.isMultiple());
        System.out.println("Không phải Multiple Dropdown");

        //Verify số lượng item có trong Dropdown
        Assert.assertEquals(date.getOptions().size(),32);
        System.out.println("Number items in Day Dropdown is: "+ date.getOptions().size());

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        SleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        System.out.println("TC_02_Login");
        driver.get("https://demo.nopcommerce.com");
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input.email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input.password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.button-1.login-button")).click();
        driver.findElement(By.cssSelector("a.ico-account")).click();
System.out.println(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"));
        //Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),companyName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),this.date);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),"May");
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),"1987");
        System.out.println("Verify correct account");
    }
    
    @AfterClass
    public void afterClass() {
       // driver.quit();
    }

    public void SleepInSecond(long timeinSecond) {
        try {
            Thread.sleep(1000 * timeinSecond); //1000ms = 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress() {
        Random rand = new Random();
        return "Hally" + rand.nextInt(99999) + "@gmail.net";
    }
}

