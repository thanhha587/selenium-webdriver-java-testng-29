package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_22_WebDriver_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;
    By reconfirmEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");

    }

    @Test
    public void TC_01_Visible() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        SleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("automation@gmail.com");
        SleepInSecond(2);

        //Tại đúng thời điểm này / step này thì Confirm Email đang visible/displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));
        //Kiểm tra 1 element có hiển thị hay không
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_in_DOM() {
        //Đk thứ 2 - Elemnet k xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        SleepInSecond(3);

         //tại đúng thời điểm này/Step này thì Confirm Email text box đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        //Kiểm tra 1 element k hiển thị
        //Chạy nhanh -> kết qủa step này Pass
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }
    @Test
    public void TC_02_Invisible_NOT_in_DOM() {
        //Click vào icon Close để đóng popup lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        SleepInSecond(3);

        //Đk thứ 3 - Elemnet k xuất hiện trên UI và cũng Không có trong cây HTML
        //tại đúng thời điểm này/Step này thì Confirm Email text box đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        //Kiểm tra 1 element k hiển thị
        //Chạy lên -> kết qủa step này Fail do k còn element này trên HTML/DOM nữa > dùng cái impliciwait 30s để tìm element k ra và báo lỗi
        //Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }
    @Test
    public void TC_03_Presence() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        SleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("automation@gmail.com");
        SleepInSecond(2);

        //Điều kiện 1 - Element có xuất hiện ở trên UI và có trong cây HTML ( DOM)
        //Tại đúng thời điểm này / step này thì Confirm Email đang visible/displayed
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

        //
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        SleepInSecond(2);
        //Điều kiện 3 - Presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

    }

    @Test
    public void TC_04_Staleness() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        SleepInSecond(2);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("automation@gmail.com");
        SleepInSecond(2);

        //Tại thời điểm này element có xuất hiện và findElement
        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);

        //Click vào icon Close để đóng popup lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        SleepInSecond(3);

        //Lúc này dùng Wait đợi element mất đi tức là tắt popup xong
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));

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

