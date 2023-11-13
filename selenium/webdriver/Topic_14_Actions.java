package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Topic_14_Actions {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Hoover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        // Nó đang giả lập lại hành vi của Mouse/ Keyboard/ Pen nên khi nó đang chạy mình k sử dụng các thiết bị này
        //Tránh conflict
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(ageTextbox).perform();
        SleepInSecond(1);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),
                "We ask for your age only for statistical purposes.");
    }


    @Test
    public void TC_02_Hoover_menu_myntra() {
        driver.get("http://www.myntra.com/");
        WebElement kids = driver.findElement(By.xpath("//a[@data-group='kids']"));
        actions.moveToElement(kids).perform();
        SleepInSecond(3);
        //Cách1
        //driver.findElement(By.xpath("//a[text()='Party wear']")).click();
        //cách 2
        actions.click(driver.findElement(By.xpath("//a[text()='Party wear']"))).perform();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Kdsprtywr - Buy Kdsprtywr online in India");
    }

    @Test
    public void TC_03_Hoover_menu_fahasa() {
        driver.get("https://www.fahasa.com/");
        //SleepInSecond(3);
        //driver.findElement(By.cssSelector("button.close-icon")).click();
        WebElement menu = driver.findElement(By.cssSelector("span.icon_menu"));
        actions.moveToElement(menu).perform();
        SleepInSecond(1);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Sách Trong Nước']"))).perform();
        SleepInSecond(2);
        //VPP - Dụng Cụ Học Sinh
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='VPP - Dụng Cụ Học Sinh']"))).perform();
        SleepInSecond(2);
        actions.click(driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content ')]//a[text()='Bộ Dụng Cụ Học Tập']"))).perform();
        //Assert.assertEquals(driver.findElement(By.xpath("//strong[text()='Bộ Dụng Cụ Học Tập']")).getText(),"BỘ DỤNG CỤ HỌC TẬP");
        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"BỘ DỤNG CỤ HỌC TẬP");
        Assert.assertTrue(driver.findElement(By.xpath("//strong[text()='Bộ Dụng Cụ Học Tập']")).isDisplayed());
    }

    @Test
    public void TC_04_ClickandHoover_block() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allnumbers= driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allnumbers.size(),20);

        //Chọn theo Block ngang dọc
        //Chọn 1-> 15
        actions.clickAndHold(allnumbers.get(0))  //Click lên số 1 và giữ chuột
                .pause(2000)                   //Dừng 2s
                .moveToElement(allnumbers.get(14))// Di chuột trái đến số 15
                .release()  //Nhả chuột trái ra
                .perform(); //Excute tất cả các action trên
        SleepInSecond(2);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),12);

        //Kiểm tra các số đã chọn có đúng là các số mong muốn k
        List<String> allNumbersTextExpected = new ArrayList<String>();
        allNumbersTextExpected.add("1");allNumbersTextExpected.add("2");allNumbersTextExpected.add("3");
        allNumbersTextExpected.add("5");allNumbersTextExpected.add("6");allNumbersTextExpected.add("7");
        allNumbersTextExpected.add("9");allNumbersTextExpected.add("10");allNumbersTextExpected.add("11");
        allNumbersTextExpected.add("13");allNumbersTextExpected.add("14");allNumbersTextExpected.add("15");

        List<String> allNumbersTextActual = new ArrayList<String>();
        for (WebElement element  : allNumbersSelected){
            allNumbersTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumbersTextActual,allNumbersTextExpected);
        System.out.println(allNumbersTextActual.get(0));
        System.out.println(allNumbersTextActual.get(1));
        System.out.println(allNumbersTextActual.get(2));
        System.out.println(allNumbersTextActual.get(3));
        System.out.println(allNumbersTextActual.get(10));
        System.out.println(allNumbersTextActual.get(11));
        System.out.println(allNumbersTextActual.get(9)); System.out.println(allNumbersTextActual.get(8));
    }

    @Test
    public void TC_04_ClickandHoover_command() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        /*
        String osName = System.getProperty("os.name");
        Keys keys;

        if (osName.startsWith("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        Keys cmdCTRL = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;
*/

        Keys keys = Keys.COMMAND;
        List<WebElement> allnumbers= driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allnumbers.size(),20);

        //Chọn theo Block ngang dọc
        //Chọn 1-> 15 đủ số k theo ngang dọc
        actions.clickAndHold(allnumbers.get(0))  //Click lên số 1 và giữ chuột
                .moveToElement(allnumbers.get(11))// Di chuột trái đến số 12
                .release()
                .perform(); //Excute tất cả các action trên

        actions.keyDown(keys).perform();
        actions.click(allnumbers.get(12)).click(allnumbers.get(13)).click(allnumbers.get(14))
                .keyUp(keys) //Nhả Command/Ctrl
                .perform(); //Excute tất cả các action trên
        SleepInSecond(2);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),15);

        //Kiểm tra các số đã chọn có đúng là các số mong muốn k
        List<String> allNumbersTextExpected = new ArrayList<String>();
        allNumbersTextExpected.add("1");allNumbersTextExpected.add("2");allNumbersTextExpected.add("3");allNumbersTextExpected.add("4");
        allNumbersTextExpected.add("5");allNumbersTextExpected.add("6");allNumbersTextExpected.add("7");allNumbersTextExpected.add("8");
        allNumbersTextExpected.add("9");allNumbersTextExpected.add("10");allNumbersTextExpected.add("11");allNumbersTextExpected.add("12");
        allNumbersTextExpected.add("13");allNumbersTextExpected.add("14");allNumbersTextExpected.add("15");

        List<String> allNumbersTextActual = new ArrayList<String>();
        for (WebElement element  : allNumbersSelected){
            allNumbersTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumbersTextActual,allNumbersTextExpected);
        System.out.println(allNumbersTextActual.get(0));
        System.out.println(allNumbersTextActual.get(1));
        System.out.println(allNumbersTextActual.get(2));
        System.out.println(allNumbersTextActual.get(3));
        System.out.println(allNumbersTextActual.get(10));
        System.out.println(allNumbersTextActual.get(14));
        System.out.println(allNumbersTextActual.get(9)); System.out.println(allNumbersTextActual.get(8));
    }

    @Test
    public void TC_04_ClickandHoover_random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        Keys keys = Keys.COMMAND;

        List<WebElement> allnumbers= driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allnumbers.size(),20);

        //Chọn bất kỳ
        actions.keyDown(keys).perform();
        actions.click(allnumbers.get(12)).click(allnumbers.get(1)).click(allnumbers.get(16)).click(allnumbers.get(3))
                .keyUp(keys) //Nhả Command/Ctrl
                .perform(); //Excute tất cả các action trên
        SleepInSecond(2);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),4);

        //Kiểm tra các số đã chọn có đúng là các số mong muốn k
        List<String> allNumbersTextExpected = new ArrayList<String>();
        allNumbersTextExpected.add("2");allNumbersTextExpected.add("4");
        allNumbersTextExpected.add("13");allNumbersTextExpected.add("17");


        List<String> allNumbersTextActual = new ArrayList<String>();
        for (WebElement element  : allNumbersSelected){
            allNumbersTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumbersTextActual,allNumbersTextExpected);
        System.out.println(allNumbersTextActual.get(0));
        System.out.println(allNumbersTextActual.get(1));
        System.out.println(allNumbersTextActual.get(2));
        System.out.println(allNumbersTextActual.get(3));

    }
    @Test
    public void TC_04_ClickandHoover_all() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        Keys keys = Keys.COMMAND;

        List<WebElement> allnumbers= driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allnumbers.size(),20);


        //Chọn bất kỳ
        int Num = 16;
        for  (int i = 0;i < allnumbers.size(); i++){
            actions.keyDown(keys).perform();
            if (i < Num){
                actions.click(allnumbers.get(i));
            }
            actions.perform();
            actions.keyUp(keys).perform();
        }

        SleepInSecond(2);

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),Num);

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

