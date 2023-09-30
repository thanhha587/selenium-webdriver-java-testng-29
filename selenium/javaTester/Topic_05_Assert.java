package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Topic_05_Assert {

    WebDriver driver;

    @Test
    public void VerifyTestNG() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        //Trong Java có nhiều thư viện để verify dữ liệu
        // Testing Framework (Unit/ Integration/ UI Automatation Test)
        // JUnit 4/ TestNG/ JUnit 5/ AssertJ/...

        // Kiểu dữ liệu nhận vào là boolean ( true/false)
        // Khi mong muốn điều kiện trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your lìfe."));

        // Mong muốn điều kiện trả về là sai thì dùng assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        // Các hàm trả về kiểu dữ liệu là boolean
        // Quy tắc: bắt đầu vs tiền tố là isXXX
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        //Mong đợi 1 đièu kiện nó giống như thực tế
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

    }


}
