package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Topic_08_Textbox_textarea {
    WebDriver driver;
    String text;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Empty_Email_And_PassWord() {
        System.out.println("TC_01_Empty_Email_And_PassWord");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("button#send2")).click();
        //driver.findElement(By.xpath("//div[@class='buttons-set']/button[@type='submit']")).click();
        text = driver.findElement(By.cssSelector("div.input-box div.validation-advice")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.input-box div.validation-advice")).getText(),"This is a required field.");
        System.out.println(text);
////input[@id= 'email']//following-sibling::div[@class='validation-advice']
        text = driver.findElement(By.xpath("//input[@id= 'pass']//following-sibling::div[@class='validation-advice']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id= 'pass']//following-sibling::div[@class='validation-advice']")).getText(),"This is a required field.");
        System.out.println(text);

        //Làm ngắn gọn hơn
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
    }

    @Test
    public void TC_02_Invalid_Email() {
        System.out.println("TC_02_Invalid_Email");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        //Invalid Email
        driver.findElement(By.cssSelector("input#email")).sendKeys("123@1234");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234567");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
        text = driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText();
        System.out.println(text);

    }

    @Test
    public void TC_03_Invalid_Password() {
        System.out.println("TC_03_Invalid_Password");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();


        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
        text = driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText();
        System.out.println(text);
    }

    @Test
    public void TC_04_Incorrect_or_PW() {
        System.out.println("TC_04_Incorrect_or_PW");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123423423");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li span")).getText(),"Invalid login or password.");
        text = driver.findElement(By.cssSelector("li span")).getText();
        System.out.println(text);
        //li span
    }

    @Test
    public void TC_05_Success() {
        System.out.println("TC_05_Success");
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title ='Create an Account']")).click();

        //Khai báo biến để điền
        String firstname = "Thanh", lastname = "Hà Nguyễn", emailAddress = getEmailAddress(), password = "123456789";
        String fullname = firstname + " "+ lastname;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title= 'Register']")).click();
        SleepInSecond(2);
        System.out.println("Login successfully");

        //Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        System.out.println(driver.findElement(By.cssSelector("li.success-msg span")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullname +"!");
        System.out.println(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText());

        String ContactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(ContactInfo.contains(fullname));
        Assert.assertTrue(ContactInfo.contains(emailAddress));
        System.out.println(ContactInfo);

        //Log out

        driver.findElement(By.cssSelector("a.skip-account")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        System.out.println("Logout system");
        SleepInSecond(1);
       // Assert.assertEquals(driver.getTitle(),"Home page");
        System.out.println("Current Page is " + driver.getCurrentUrl());
        System.out.println("Current Page is " + driver.getTitle());

        //Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);
        driver.findElement(By.cssSelector("button#send2")).click();

        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"),lastname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"),emailAddress);

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
    public String getEmailAddress() {
        Random rand = new Random();
        return "thanhha" + rand.nextInt(99999) + "@gmail.net";
    }
}

