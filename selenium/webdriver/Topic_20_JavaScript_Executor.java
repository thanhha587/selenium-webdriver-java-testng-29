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

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Topic_20_JavaScript_Executor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    public void TC_00_Console() {
        //Khai báo biến để dùng trên console trên webbrowser
//        var element = $$("button.login-button")[0];
//        element.click();
//        element.scrollIntoView(true); //Kéo tới mép trên cùng
//        element.scrollIntoView(false); //Kéo tới mép dưới cùng
    }
    @Test
    public void TC_01_JE() {
        //thay vì dùng driver.get ta dùng JE
        jsExecutor.executeScript("window.location = 'http://live.techpanda.org/'");
        SleepInSecond(1);

        //có thể rút gọn lại thành như sau sau khi thêm hàm
        executeForBrowser("window.location = 'http://live.techpanda.org/'");
        SleepInSecond(4);
        String techPandaDomain = (String) executeForBrowser("return document.domain;");
        Assert.assertEquals(techPandaDomain, "live.techpanda.org");

        String homePageURL = (String) executeForBrowser("return document.URL");
        Assert.assertEquals(homePageURL,"http://live.techpanda.org/");

        //Mở trang Mobile
        hightlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");

        //Add to card
        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        //Mở trang Customer Service
        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String titleCustomerService = (String) executeForBrowser("return document.title");
        Assert.assertEquals(titleCustomerService,"Customer Service");

        scrollToBottomPage();
        hightlightElement("//input[@id= 'newsletter']");
        sendkeyToElementByJS("//input[@id= 'newsletter']","thanhha@gmail.com");

        hightlightElement("//button[@title ='Subscribe']");
        clickToElementByJS("//button[@title ='Subscribe']");
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));

        navigateToUrlByJS("https://www.facebook.com/");
        String domain = (String) executeForBrowser("return document.domain");
        Assert.assertEquals(domain,"facebook.com");
    }

    @Test
    public void TC_02_() {
        //executeForBrowser("window.location = 'https://login.ubuntu.com/'");


        executeForBrowser("window.location = 'https://sieuthimaymocthietbi.com/account/register'");
        SleepInSecond(4);
        hightlightElement("//h1[@class='title-head text-center']");
        hightlightElement("//input[@id='lastName']");
        sendkeyToElementByJS("//input[@id='lastName']","Thanh Hà");
        SleepInSecond(2);

        executeForBrowser("window.location = 'https://warranty.rode.com/'");
        SleepInSecond(5);
        hightlightElement("//a[text()=' Create an Account ']");
        clickToElementByJS("//a[text()=' Create an Account ']");
        SleepInSecond(5);
        hightlightElement("//input[@id='name']");
        sendkeyToElementByJS("//input[@id='name']","Thanh Hà");
        SleepInSecond(3);

    }

    @Test
    public void TC_03_() {
        executeForBrowser("window.location = 'http://live.techpanda.org/'");
        SleepInSecond(2);
        hightlightElement("//header[@id='header']/div//span[text()='Account']");
        clickToElementByJS("//header[@id='header']/div//span[text()='Account']");
        SleepInSecond(1);
        hightlightElement("//header[@id='header']/div//a[text()='My Account']");
        clickToElementByJS("//header[@id='header']/div//a[text()='My Account']");
        SleepInSecond(1);
        hightlightElement("//a[@title='Create an Account']");
        clickToElementByJS("//a[@title='Create an Account']");
        SleepInSecond(1);
        //Nhập thông tin hợp lệ
        String email = getEmailAddress();
        sendkeyToElementByJS("//input[@title='First Name']","Thanh Hà");
        sendkeyToElementByJS("//input[@title='Last Name']","Nguyễn");
        sendkeyToElementByJS("//input[@title='Email Address']",email);
        sendkeyToElementByJS("//input[@title='Password']","abc@1234");
        sendkeyToElementByJS("//input[@title='Confirm Password']","abc@1234");
        clickToElementByJS("//span[text()='Register']");
        SleepInSecond(2);
        String a = getElementValidationMessage("//li[@class='success-msg']/ul/li/span");
        //Assert.assertEquals(a,"Thank you for registering with Main Website Store.");
        Assert.assertTrue(getInnerText().contains("Thank you for registering with Main Website Store."));

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
    public String getEmailAddress() {
        Random rand = new Random();
        return "thanhha" + rand.nextInt(99999) + "@gmail.net";
    }

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        SleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        SleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        SleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}

