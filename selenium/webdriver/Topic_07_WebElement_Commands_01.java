package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Topic_07_WebElement_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Element() {
        //HTML Element: Textbox/ Text Area/ Dropdown/ Link
        //Tìm chưa tương tác lên
        driver.findElement(By.id(""));

        //Tìm và tương tác lên
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys("");

        //Tìm và lưu vào một biến ( chưa tương tác)
        //Khi biến này dùng 2 lần trở lên
        WebElement fullNameTexbox = driver.findElement(By.id(""));
        fullNameTexbox.clear();
        fullNameTexbox.click();
        fullNameTexbox.sendKeys("Automation FC");
        fullNameTexbox.getAttribute("value");

        //Dùng để xoá dữ liệu 1 field cho phép nhập/editable
        // Textbox/TextArea/ DropBox
        driver.findElement(By.id("")).clear();//*

        //dùng để nhập dữ liệu cho các field nêu trên
        driver.findElement(By.id("")).sendKeys("");//**

        //Dùng để click Element
        driver.findElement(By.id("")).click();//**

        //Find Element Tìm từ node cha vào node con
        driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));

        //Trả về 1 Element khớp với đk
        WebElement fullnameTextbox = driver.findElement(By.id(""));

        //Trả về nhiều Elements khớp với đk
        List<WebElement> textboxes = driver.findElements(By.id(""));

        //Java non Generic
        ArrayList name = new ArrayList();
        name.add("Automation FC");
        name.add(15);
        name.add('B');
        name.add(true);

        //Java Generic
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add("Automation FC");
        /*addresses.add(15); //báo lỗi ngay do k phải string
        addresses.add('B');//báo lỗi ngay do k phải string
        addresses.add(true);//báo lỗi ngay do k phải string
        */
        //Dùng để verify 1 checkbox/radio/dropdown (  default(đã được chọn hay chưa )
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());//*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dùng để verify 1 element có được hiển thị lên hay không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());//**
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //Dùng để verify 1 element có được thao tác lên không ( k phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());//*
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        //HTML ELement
        // trả ra gía trị của các attribut
        driver.findElement(By.id("")).getAttribute("title");//*
        driver.findElement(By.id("")).getAttribute("id");

        //Tab Accessibility và Properties
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURL");

        driver.findElement(By.id("")).getAriaRole();

        //Tab Styles trong Elements
        driver.findElement(By.id("")).getCssValue("background-colour");//*
        driver.findElement(By.id("")).getCssValue("font-size");

        //Lấy ra vị trí Element so với độ phân giải màn hình
        Point nametextbox = driver.findElement(By.id("")).getLocation();
        nametextbox.getX();
        nametextbox.getY();

        //Get location + size
        Rectangle nameTextbox = driver.findElement(By.id("")).getRect();
        nameTextbox.getHeight();
        nameTextbox.getWidth();
        nameTextbox.getX();
        nameTextbox.getY();
        nameTextbox.getPoint();

        //Location
        Point namepoint = nameTextbox.getPoint();
        //Dimension Size
        Dimension nameSize = nameTextbox.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        //Shadow root (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        //Từ id/class/css/x có thể truy ra ngược lại tagname HTML
        driver.findElement(By.id("firstname")).getTagName();
        driver.findElement(By.className("form-instructions")).getTagName();
        driver.findElement(By.cssSelector("#firstname")).getTagName();
        driver.findElement(By.xpath("//*[@class= 'form-list']")).getTagName();

        driver.findElement(By.id("")).getText();//**

        //Chụp hình bị lỗi và lưu dưới dạng nào
        // Byte / file / base64
        driver.findElement(By.cssSelector("#firstname")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("#firstname")).getScreenshotAs(OutputType.BYTES);
        driver.findElement(By.cssSelector("#firstname")).getScreenshotAs(OutputType.BASE64);//*

    }

    @Test
    public void TC_02_Logo() {

    }

    @Test
    public void TC_03_Form() {

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

