package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;


public class Topic_26_Wait_05_Explicit_01_Knowledge {
    WebDriver driver;
    //C1: Khai báo
    WebDriverWait explicitWait;

    //C2:Vừa khai báo vừa khởi tạo
    //Khai báo ntn thì driver lại chưa khởi tạo nên chạy sẽ lỗi
    //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass //Precondition - Khởi tạo dữ liệu / data test / page class / variable
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Khởi tạo 1 explicit Wait có tổng thời gian là 10s - polling là 0.5 mặc
        // 500 ms = 0.5 s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Khởi tạo 1 explicit Wait có tổng thời gian là 10s - polling là 0.3s
        //explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5),Duration.ofMillis(300));

        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_() {
        //Chờ cho 1 Alert presence trong HTML/DOM trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        //chờ cho Element k còn ở trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //Chờ cho element có trong DOM (k quan tâm có hiển thị ở UI hay k )
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#search-form input#live-search-bar")));

        //Chờ cho cả list element có trong DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector("form#search-form"),By.cssSelector("input#live-search-bar"));

        //Chờ cho 1-n Element hay list Element hiển thị trên UI
        // Cho 1 Element( k có chữ ALL) / Nhiều Elements ( có chữ ALL) , tham số là gì
        explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(""))));
          //Vẫn chạy được dù truyền 1 Element hay nhiều Element hay List Element
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector(""))));

        //Chờ cho phép được click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        //Dùng cái này trước hàm gọi trang để Verify
        explicitWait.until(ExpectedConditions.titleIs("A"));//Chờ cho đến khi chuyển sang trang thành công
        Assert.assertEquals(driver.getTitle(),"A");

        //Nhiều điều kiện
        //Phải cả hai đk đúng AND
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(""))));

        //Một trong 2 đk đúng là được OR
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(""))));

        //Chờ cho 1 element có attribute chứa giá trị mong đợi tương đối
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"),"id","sea"));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"),"id","search"));

        //Chờ Element tuyệt đối phải có đúng  như mong đợi
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"",""));

        //Chờ cho 1 Element có attribute khác null dùng để check chuyển trạng thái từ k có dữ liệu > có dữ liệu
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("input#search")),"id"));

        //
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"namespaceURI","http.."));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"namespaceURI","http.."));

        //Chờ cho 1 Element được chọn =>  Checkbox/Radio/Dropdown (Default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Chờ cho 1 Element được Selected rồi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));
        // Chờ cho 1 Element chưa được Selected ( chuyển từ Selected -> Deselected)
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));

        //Frame
        //By Element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        //Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("name"));
        //Index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        //Chờ cho run 1 đoạn code java trả giá trị
        //JS return Value
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));

        //Cho 1 đoạn code JS được thực thi k ném ra ngoại lệ nào
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return document.documentElement.innerText;"));
        Assert.assertTrue( explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return document.documentElement.innerText;")));

        //Chờ cho số lượng Elements xuất hiện là bn, hơn kém
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),11));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),9));

        //Chờ cho Window / Tab là bn
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        //Dùng để kiểm tra có hiển thị text như mong muốn => đặt trong Assert
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),"Hello World!"));
        //Nhận giá trị Regex
        Pattern  pattern = Pattern.compile("school",Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""),pattern));

        //Bắt buộc text này phải có trong DOM ( có trong UI hay k, k quan trọng)
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(""),""));

        //URL tuyệt đối
        explicitWait.until(ExpectedConditions.urlToBe(""));
        //URL tương đối
        explicitWait.until(ExpectedConditions.urlMatches("[ab^c]"));
        explicitWait.until(ExpectedConditions.urlContains(""));

        //Chờ cho 1 đk mà  này nó bị update trạng thái - load laị HTML
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

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

