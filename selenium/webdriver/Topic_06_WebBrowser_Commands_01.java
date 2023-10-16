package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Topic_06_WebBrowser_Commands_01 {
    //Các câu lệnh để thao tác với driver
    //driver.
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được thì phải khởi tạo
        // Nếu k khởi tạo sẽ bị lõi : NullPointerException: lối call/dùng biến chưa khởi tạo để dùng
        driver = new FirefoxDriver();
        //In ra driver: FirefoxDriver: firefox on mac (73444ffe-61af-4819-8589-cc65c7534c08)
        System.out.println(driver.toString());
        //GUID: Globla Unit Identifier Number ( duy nhất k trùng lặp )

        //driver = new ChromeDriver();
        //driver = new EdgeDriver();
        //driver = new InternetExplorerDriver();
        // driver = new OperaDriver(); ngừng sử dụng từ selenium 4
        //driver = new HTMLUnit(); ngừng sử dụng từ 2016 Headless browser: Crawl Data ( Data analyst)/Dev FE
        //driver = new SafariDriver();// đang k có driver nên bị False

        //Selenium v3
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @Test
    public void TC_01_Url() throws MalformedURLException {
    // 1. Set trực tiếp - Mở ra một page URL bất kỳ
        driver.get("https://www.facebook.com/");

        //In ra TabID hoặc window
        System.out.println("Window/ TabID = "+driver.getWindowHandle());
    //2- Khai báo biến rồi gán vào sau
    // Nếu như biến này chỉ dùng duy nhất 1 lần thì k nên tạo biến

    // Nếu như có 1 tab/window thì close như quit
    // Nhiều hơn một thì close sẽ đóng cái đang active
    driver.close();

    // Đóng Browser ( k care có bao nhiêu tab/window) tắt tất cả
    driver.quit();

    // Hai hàm này chịu ảnh hưởng timeout của ImpliciWait
    // findElement và findElements

    /* Sẽ đi tìm với loại By nào và trả về element nếu như tìm thấy
        K được tìm thấy sẽ Fail tại step này - throw exception: NoSuchElementException
         Trả về 1 element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy ( thao tác với cái đầu tiên)
     */
    WebElement emailAddress =  driver.findElement(By.id("email"));

    // Tại sao phải lấy dữ liệu ra để làm gì => Cần so sánh với Expected có đúng k
    // Lấy các thông tin của Page hiện tại đang dùng
    driver.getCurrentUrl();
    driver.getPageSource();
    driver.getCurrentUrl().contains("Facebook helps you connect and share with the people in your lìfe.");
    Assert.assertTrue(driver.getCurrentUrl().contains("Facebook helps you connect and share with the people in your lìfe."));

    driver.getTitle();
    driver.getWindowHandle();
    //Lấy ra title hiện tại của page
    driver.getTitle();

    // Lấy ra ID của cửa sổ/tab hiện tại
    driver.getWindowHandle();
    driver.getWindowHandles();

    //Cookies - framework
    driver.manage().getCookies();

    //Get ra những cái log ở DEV tool - Framework
    driver.manage().logs().get(LogType.DRIVER);

    //apply cho việc tìm Element
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    //Thường k dùng mấy
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    // Set trước khi dùng vs thư viện JavascriptExecutor
    // Inject 1 đoạn code JS vào trong Browser/ Element
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

    //Selenium 4 mới có
    driver.manage().window().fullscreen();
    driver.manage().window().maximize();
    driver.manage().window().minimize();

    //Test Responsive
    driver.manage().window().setSize(new Dimension(1366,768));
    driver.manage().window().setSize(new Dimension(1920,1680));
    driver.manage().window().setSize(new Dimension(2560,1440));

    //Dùng test GUI
    driver.manage().window().getSize();
    //Góc trên cùng bên trái 0,0
    driver.manage().window().setPosition(new Point(605,533));// Set cái điểm cao nhất bên trái của Webbrowser

    driver.navigate().back();
    driver.navigate().refresh();
    driver.navigate().forward();
    driver.navigate().to("https://www.facebook.com/");
    driver.navigate().to(new URL("https://www.facebook.com/"));

    //Alert Window/Frame/ (iFrame)
    driver.switchTo().alert().accept();
    driver.switchTo().alert().dismiss();
    driver.switchTo().alert().getText();
    driver.switchTo().alert().sendKeys("Test");

    //Lấy ra ID / cửa sổ hiện tại
    String homePageWindowID = driver.getWindowHandle();
    driver.switchTo().window(homePageWindowID);



    //Switch/ Handle  Frame/ iFrame
    driver.switchTo().frame(0);
    driver.switchTo().frame("34948853");
    driver.switchTo().frame(driver.findElement(By.id("")));

    //Switch về HTML chứa Frame trước đó
    driver.switchTo().defaultContent();

    //Từ Frame trong đi ra frame ngoài
    driver.switchTo().parentFrame();







    //Kiểm tra
    Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

    //Nếu cần dùng đi dùng lại thì khai báo biến, khởi tạo và sử dụng nhiều lần
    String loginPageURL = driver.getCurrentUrl();
    Assert.assertEquals(loginPageURL,"https://www.facebook.com/");
    driver.get(loginPageURL);



    //Sẽ đi tìm với loại By nào và trả về 1 danh sách elements nếu như được tìm thấy
    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    checkboxes.get(0).click();
    checkboxes.get(1).click();
    driver.findElement(By.cssSelector("button#login")).click();


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
}
