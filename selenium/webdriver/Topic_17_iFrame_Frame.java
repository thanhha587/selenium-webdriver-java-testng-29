package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Topic_17_iFrame_Frame {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_00_SWITCH() {
        // Trang A - domain: formsite.com
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        //Chứa iFrame trang B
        // Từ A vào B
        driver.switchTo().frame("frame-one85593366");

        //Từ B vào C
        driver.switchTo().frame("frame-5533");

        //Từ C về lại B
        driver.switchTo().parentFrame();

        //Từ B quay lại A
        driver.switchTo().defaultContent();

    }

    @Test
    public void TC_01_Form_Site() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        SleepInSecond(5);

        WebElement formiFrame = driver.findElement(By.cssSelector("div.details__form-template iframe"));
        Assert.assertTrue(formiFrame.isDisplayed());

        //Các cách Switch
//        driver.switchTo().frame("frame-one85593366");//ID này cũng có thể thay đổi
//
//        driver.switchTo().frame(0); // có thể thay đổi

        driver.switchTo().frame(formiFrame); //nên dùng cái này vì tạo biến tìm một lần





        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");

    }

    @Test
    public void TC_02_Kyna() {
        driver.get("https://skills.kynaenglish.vn/");
        //Kiểm tra iFrame có
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class= 'face-content']/iframe")).isDisplayed());

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

