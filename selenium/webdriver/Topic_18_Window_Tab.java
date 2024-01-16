package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Topic_18_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Basic_Form() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        String basicFormID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()= 'GOOGLE']")).click();
        SleepInSecond(2);

        //Switch để qua trang Google
        switchToWindowByID(basicFormID);

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium");
        SleepInSecond(2);

        String googleTabID = driver.getWindowHandle();

        //Switch để quay lại trong Basic Form
        switchToWindowByID(googleTabID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        SleepInSecond(3);

        switchToWindowByTitles("Facebook - Login ");

    }

    @Test
    public void TC_02_KynaEnglish() {
        driver.get("");

        driver.findElement(By.cssSelector("")).click();
        SleepInSecond(3);

        driver.findElement(By.cssSelector("")).sendKeys("");
        SleepInSecond(2);

        switchToWindowByTitles("");

        driver.findElement(By.cssSelector("")).click();
        SleepInSecond(2);

        switchToWindowByTitles("Kyna.vn");
        SleepInSecond(2);

        Assert.assertEquals(driver.getTitle(),"");


    }

    @Test
    public void TC_03_() {

    }

    @Test
    public void TC_04_Seleniumv4() {
        driver.get("https://skills.kynaenglish.vn/");
        System.out.println("Title Kyna : " + driver.getTitle());
        System.out.println("driver Kyna  : " + driver.toString());
        System.out.println("Window Kyna  : " + driver.getWindowHandle());
        String a = driver.getTitle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/kyna.vn/?ref=embed_page");
        System.out.println("driver facebook: " + driver.toString());
        System.out.println("URL của driver: " + driver.getCurrentUrl());
        System.out.println("Window FAcebook  : " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.facebook.com/kyna.vn/?ref=embed_page");
        System.out.println("driver facebook: " + driver.toString());
        System.out.println("title của driver: " + driver.getTitle());
        System.out.println("Window Face  : " + driver.getWindowHandle());

        switchToWindowByTitles(a);
        SleepInSecond(3);
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Bí quyết");
        Assert.assertEquals(driver.getTitle(),a);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //Chỉ dùng đc khi có 2 tab mở
    public void switchToWindowByID(String expectedID) {
        //Lấy hết các ID của các window/tab
        Set<String> allIDs =  driver.getWindowHandles();

        //Dùng vòng lặp duyệt qua các Set ID ở trên
        for (String id:allIDs ) {
            driver.switchTo().frame(id);
        }
    }

    public void switchToWindowByTitles(String expectedTitle) {
       //Lấy hết các ID của các window/tab
        Set<String> allIDs = driver.getWindowHandles();

        //Dùng vòng lặp duyệt qua các Set ID ở trên
        for (String id:allIDs) {
            //Cho switch vào từng ID trước
            driver.switchTo().window(id);

            String actualTitle =driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }

    }
    public void SleepInSecond(long timeinSecond) {
        try {
            Thread.sleep(1000 * timeinSecond); //1000ms = 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

