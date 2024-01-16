package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;


public class Topic_23_Wait_02_Find_Element {
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //Implicit Wait
        //Set implicit với Selenium 4.x trở lên
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        //Set Implicit với Selenium 3.x trở xuống
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //ver 4.x
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        //Ver 3.x
//        //explicitWait = new WebDriverWait(driver,10);
//
//        fluentWait = new FluentWait(driver);
//
//        //ver 4.x
//        fluentWait.withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(500));
//
////        ver 3.x
////        fluentWait.withTimeout(5000, TimeUnit.MILLISECONDS)
////                .pollingEvery(250,TimeUnit.MILLISECONDS);

        driver.get("https://www.facebook.com/");


        //Full màn hình
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_FindElement() {
        //Case 1 - Element tìm thấy chỉ có 1
        //Sẽ k cần chờ hết timeout 10s
        //Tìm thấy sẽ trả về 1 WebElement
        //Qua step tiếp theo
//        System.out.println("Star step:" + getDateTimeNow());
//        driver.findElement(By.cssSelector("input#email"));
//        System.out.println("End step:" + getDateTimeNow());

        //Case 2 - Element tìm thấy có nhiều hơn 1
        //Sẽ k cần chờ hết timeout 10s
        //Lấy cái đầu tiên dù tìm được n node
        //Qua step tiếp theo
//        System.out.println("Star step:" + getDateTimeNow());
//        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("haauto@gmail.com");
//        System.out.println("End step:" + getDateTimeNow());

        //Case 3 - Element k được tìm thấy
        //Chờ hết timeout là 10s
        //Trong thời gian này cứ mỗi nửa giây lại tìm lại 1 lần
        //Nếu tìm lại mà thấy thì sẽ trả ra Element và qua bước tiếp theo
        //Nếu hết thời gian tìm lại mà k thấy thì đánh Fail Tc và throw exception : NoSuchElementException
        //Các step còn lại k chạy nữa
        //click Create New Account thì tìm thấy Element
        System.out.println("Star step:" + getDateTimeNow());
        driver.findElement(By.cssSelector("input[name='reg_email__']"));
        System.out.println("End step:" + getDateTimeNow());


    }

    @Test
    public void TC_02_FindElements() {
        List<WebElement> elementList;
        //Case 1 - Tìm được Element trong khoảng thời gian đã set
        //K cần chờ hết 10s timeout
        //Trả ra trong List 1 phần tử tương đương 1 Element
        System.out.println("Star step:" + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step:" + getDateTimeNow());

        //Case 2 - Elements được tìm thấy nhiều hơn 1
        //K cần chờ hết 10s timeout
        //Trả ra trong List nhiều Element
        System.out.println("Star step 2:" + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List 2 have: " + elementList.size());
        System.out.println("End step 2:" + getDateTimeNow());

        //Case 3 - Elements k được tìm thấy
        //Chờ hết timeout là 10s
        //Trong thời gian này cứ mỗi nửa giây lại tìm lại 1 lần
        //Nếu tìm lại mà thấy thì sẽ trả ra List Elements và qua bước tiếp theo
        //Nếu hết thời gian tìm lại mà k thấy thì trả ra List rỗng
        //Qua step tiếp theo
        System.out.println("Star step 3:" + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("List 3 have: " + elementList.size());
        System.out.println("End step 3:" + getDateTimeNow());

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }
}


