package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Displayed() {
    System.out.println("TC_01_Displayed");
    driver.get("https://automationfc.github.io/basic-form/index.html");

    //Nếu như mong đợi 1 element hiển thị thì verifyTrue
    //Nếu như mong đợi 1 element hiển thị thì verifyFalse
        if (driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Thanh Ha test");
            System.out.println("Email textbox is Displayed");
        }else {
            System.out.println("Email textbox is not Displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Under 18 Ratio is Displayed");
        }else {
            System.out.println("Under 18 Ratio is not Displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("University");
            System.out.println("Education textarea is Displayed");
        }else {
            System.out.println("Education textarea is not Displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("User 5 is Displayed");
        }else {
            System.out.println("User 5 is not Displayed");
        }
/*
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='mail']"));
        driver.findElement(By.cssSelector("input#under_18"));
        driver.findElement(By.cssSelector("textarea#edu"));
*/

    }

    @Test
    public void TC_02_Enabled() {
        System.out.println("TC_02_Enabled");
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.xpath("//input[@id='mail']")).isEnabled()) {
            System.out.println("Email textbox is Enabled");
        }else {
            System.out.println("Email textbox is not Enabled");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("Under 18 Ratio is Enabled");
        }else {
            System.out.println("Under 18 Ratio is not Enabled");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("Education textarea is Enabled");
        }else {
            System.out.println("Education textarea is not Enabled");
        }

        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            System.out.println("Job role 1 is Enabled");
        }else {
            System.out.println("Job role 1 is not Enabled");
        }

        if (driver.findElement(By.cssSelector("select#job2")).isEnabled()) {
            System.out.println("Job role 2 is Enabled");
        }else {
            System.out.println("Job role 2 is not Enabled");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Interest Development checkbox is Enabled");
        }else {
            System.out.println("Interest Development checkbox is not Enabled");
        }

        if (driver.findElement(By.cssSelector("input#design")).isEnabled()) {
            System.out.println("Interest Design checkbox is Enabled");
        }else {
            System.out.println("Interest Design checkbox is not Enabled");
        }


        if (driver.findElement(By.cssSelector("input#slider-1")).isEnabled()) {
            System.out.println("Slider 1 is Enabled");
        }else {
            System.out.println("Slider 1 is not Enabled");
        }

        //Check not Enabled
        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password is Enabled");
        }else {
            System.out.println("Password is Disabled");
        }

        if (driver.findElement(By.cssSelector("input#radio-disabled")).isEnabled()) {
            System.out.println("Disabled Ratio is Enabled");
        }else {
            System.out.println("Disabled Ratio is Disabled");
        }

        if (driver.findElement(By.cssSelector("textarea#bio")).isEnabled()) {
            System.out.println("Bio textarea is Enabled");
        }else {
            System.out.println("Bio textarea is Disabled");
        }

        if (driver.findElement(By.cssSelector("select#job3")).isEnabled()) {
            System.out.println("Job role 3 is Enabled");
        }else {
            System.out.println("Job role 3 is Disabled");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Interest disabled checkbox is Enabled");
        }else {
            System.out.println("Interest disabled checkbox is Disabled");
        }

        if (driver.findElement(By.cssSelector("input#slider-2")).isEnabled()) {
            System.out.println("Slider 2 is Enabled");
        }else {
            System.out.println("Slider 2 is Disabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        System.out.println("TC_03_Selected");
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Ratio Under 18 is Selected");
        }else {
            System.out.println("Ratio Under 18 is not Selected");
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("java.lang is Selected");
        }else {
            System.out.println("java.lang is not Selected");
        }
        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());
        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("java.lang is Selected");
        }else {
            System.out.println("java.lang is not Selected");
        }
        //
    }

    @Test
    public void TC_04_MixCase() {
        System.out.println("TC_04_MixCase");
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();


        //Case 0 : Blank
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("div#onetrust-close-btn-container")).click();
        SleepInSecond(1);
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case0: All are blank");

        //Case 1 : PW only number
        driver.findElement(By.cssSelector("input#email")).sendKeys("thanhha587@gmail.com");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("1234");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case1: Passwword only number");

        //Case 2 : PW only lower character
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abcd");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case2: Passwword only lower char");

        //Case 3 : PW only upper character
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABCD");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case3: Passwword only upper char");

        //Case 4 : PW special character
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$@$");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case4: Passwword special char");

        //Case 6 : PW is 8 char
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abcd1234");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case6: Passwword 8 char");

        //Case 7 : PW valid
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("aB@d12345");
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        System.out.println("TC_04_MixCase_Case7: Passwword is valid");


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

