package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Topic_12_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Default_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By dualZoneCheckbox= By.xpath("//label[text()=\"Dual-zone air conditioning\"]/preceding-sibling::input");
        By rearZoneCheckbox= By.xpath("//label[text()=\"Rear side airbags\"]/preceding-sibling::input");

        //click vào Check box
        //Case 1: App mở ra mà checkbox đã được chọn
        //Case 2: App mở ra mà checkbox chưa đc chọn
        driver.findElement(dualZoneCheckbox).click();
        SleepInSecond(1);

        //Nếu chưa được chọn thì sẽ click đúng cho cả case đã click hoặc chưa click thì sẽ click
        if(!driver.findElement(rearZoneCheckbox).isSelected()){
            driver.findElement(rearZoneCheckbox).click();
            SleepInSecond(1);
        }

        //Kiểm tra đã chọn chưa
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(rearZoneCheckbox).isSelected());

        //Bỏ chọn 2 checkbox
        if(driver.findElement(rearZoneCheckbox).isSelected()){
            driver.findElement(rearZoneCheckbox).click();
            SleepInSecond(1);
        }

        //Nếu dùng nhiều lần thì tạo hàm
        uncheckToElement(dualZoneCheckbox);
        uncheckToElement(rearZoneCheckbox);
    }

    @Test
    public void TC_02_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By Twopetrolradio = By.xpath("//label[text()=\"2.0 Petrol, 147kW\"]/preceding-sibling::input");
        By Twodieselradio = By.xpath("//label[text()=\"2.0 Diesel, 103kW\"]/preceding-sibling::input");

        checkToElement(Twopetrolradio);

        Assert.assertTrue(driver.findElement(Twopetrolradio).isSelected());
        Assert.assertFalse(driver.findElement(Twodieselradio).isSelected());

        checkToElement(Twodieselradio);

        Assert.assertFalse(driver.findElement(Twopetrolradio).isSelected());
        Assert.assertTrue(driver.findElement(Twodieselradio).isSelected());
        //2.0 Diesel, 103kW

    }
    @Test
    public void TC_03_Default_Checkbox_Radio() {
        driver.get("https://material.angular.io/components/radio/examples");
        By autumnradio = By.xpath("//label[text()=' Autumn ']/preceding-sibling::div");

        if(!driver.findElement(autumnradio).isSelected()) {
        driver.findElement(autumnradio).click();
        SleepInSecond(1);
        }

        driver.get("https://material.angular.io/components/checkbox/examples");
        By check = By.xpath("//label[text()=\"Checked\"]/preceding-sibling::div/input");
        By indeter = By.xpath("//label[text()=\"Indeterminate\"]/preceding-sibling::div/input");

        checkToElement(check);
        checkToElement(indeter);

        Assert.assertTrue(driver.findElement(check).isSelected());
        Assert.assertTrue(driver.findElement(indeter).isSelected());

        uncheckToElement(check);
        uncheckToElement(indeter);

        Assert.assertFalse(driver.findElement(check).isSelected());
        Assert.assertFalse(driver.findElement(indeter).isSelected());

        }

    @Test
    public void TC_04_Check_All_box() {
        driver.get("https://automationfc.github.io/multiple-fields/");
      //  By autumnradio = By.xpath("//label[text()=' Autumn ']/preceding-sibling::div");

        List<WebElement> allCheckboxItem = driver.findElements(By.xpath("//div[@data-component='checkbox']//input"));
        //Chọn hết
        for (WebElement checkbox: allCheckboxItem) {
            if(!checkbox.isSelected()){
                checkbox.click();
                //SleepInSecond(1);
            }
        }
        //Verify đã tick hết các check box
        for (WebElement checkbox: allCheckboxItem) {
            Assert.assertTrue(checkbox.isSelected());
        }

        //Cần clear cache
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        //Sau khi refresh thì k còn thông tin của element nữa
        allCheckboxItem = driver.findElements(By.xpath("//div[@data-component='checkbox']//input"));

        //Chọn 1 radio/checkbox nào đó trong tất cả các checkbox
        for (WebElement checkbox: allCheckboxItem) {
            if(checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
                SleepInSecond(1);
            }
        }

        //Verify chỉ có 1 checkbox được chọn
        for (WebElement checkbox: allCheckboxItem) {
            if (checkbox.getAttribute("value").equals("Heart Attack")) {
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }

    @Test
    public void TC_05_Custom_Checkbox() {
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
        By radio = By.xpath("//div[text()=\"Đăng ký cho người thân\"]/preceding-sibling::div/input");
        By outradio = By.xpath("//div[text()=\"Đăng ký cho người thân\"]/preceding-sibling::div/div[@class= 'mat-radio-outer-circle']");

        //Case 1: Dùng thẻ input để click => lỗi do bị che bởi thẻ khác
        //checkToElement(radio);
        //Assert.assertTrue(driver.findElement(radio).isSelected());

        //Case 2: Dùng thẻ div bên ngoài để click và verify
        // isSelected chỉ dùng cho input thôi k dùng cho thẻ div
        //checkToElement(outradio);
        //Assert.assertTrue(driver.findElement(outradio).isSelected());//lỗi do thẻ div k có isSelected

        //case 3: Dùng thẻ div để click và dùng thẻ input để verify => Pass
        //checkToElement(outradio);
        //Assert.assertTrue(driver.findElement(radio).isSelected());
        //1 element mà cần define tới 2 locator thì sau này => Maintain mất nhiều thời gian

        //Case 4:Dùng input để click và verify JavascriptExcutor ( JS)
        //Vì input bị che rồi nên hàm click ( selenium) k dùng đc ( do chỉ dùng cho element visible)
        //cách 1: ép thẳng luôn
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(radio));
        Assert.assertTrue(driver.findElement(radio).isSelected());
        //Cách 2: ép kiểu dữ liệu tường minh
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Interface Webdriver
        //Interface JavascriptExecutor
        //Ép kiểu dữ liệu từ interface này qua Interface khác
    }

    @Test
    public void TC_06_Custom_Google_Doc() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By DanangRadio = By.xpath("//div[@data-value= 'Đà Nẵng']");
        String a = driver.findElement(DanangRadio).getAttribute("aria-checked");
        System.out.println(a);
        Assert.assertEquals(driver.findElement(DanangRadio).getAttribute("aria-checked"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value= 'Đà Nẵng'and @aria-checked = 'false']")).isDisplayed());
        driver.findElement(By.xpath("//div[@data-value= 'Đà Nẵng']/parent::div")).click();
        SleepInSecond(3);
        //Verify
        Assert.assertEquals(driver.findElement(DanangRadio).getAttribute("aria-checked"),"true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value= 'Đà Nẵng'and @aria-checked = 'true']")).isDisplayed());
    }

    @Test
    public void TC_07_Custom_Google_Doc() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By CanthoRadio = By.xpath("//div[@data-value= 'Cần Thơ']");
        String a = driver.findElement(CanthoRadio).getAttribute("aria-checked");
        System.out.println(a);
        Assert.assertEquals(driver.findElement(CanthoRadio).getAttribute("aria-checked"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value= 'Cần Thơ'and @aria-checked = 'false']")).isDisplayed());
        SleepInSecond(3);
        driver.findElement(CanthoRadio).click();

        //Verify
        Assert.assertEquals(driver.findElement(CanthoRadio).getAttribute("aria-checked"),"true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value= 'Cần Thơ'and @aria-checked = 'true']")).isDisplayed());
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

    public void uncheckToElement(By byXpath) {
        //Nếu element được chọn thì mới click lần nữa để bỏ chọn
        if (driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            SleepInSecond(1);
        }
    }
    public void checkToElement(By byXpath) {
        //Nếu element chưa chọn thì mới click để chọn
        if (!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            SleepInSecond(1);
        }
    }

}

