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
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Topic_10_Custome_Dropdown {
    WebDriver driver;

    //Tường minh: trạng thái cụ thể cho element
    // Visible/ Invisible/ Presence/ Number/ Clickable/....
    WebDriverWait explicitWait;
   // private Function<? super WebDriver,? extends Object> ExpectedConditions;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Wait ngầm định: k rõ ràng cho 1 trạng thái cụ thể nào của element hết
        //Cho việc tìm element findElements()
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    //@Test
    public void TC_01_() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
       // 1 - Click vào 1 thẻ để cho nó xổ hết các item bên trong dropdown ra
        driver.findElement(By.cssSelector("span#number-button")).click();
        SleepInSecond(10);

       // 2.1 - Nó sẽ xổ ra chứa hết tất cả các item
       // 2.2 - Nó sẽ xổ ra nhưng chỉ chứa 1 phần và đang load thêm
       // Ngàn/ Triệu record
        //Chờ cho nó xổ ra hết tất cả các item trong dropdown

        //Có case item k visible hết tất cả (Angular/ React/..)
       // explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(""));

        //  Displayed / Visibility
        // Presnece: nhìn thấy/k nhìn thấy cũng thoả mãn
        // 1. Có/ k có trên UI
        // 2. Có trong HTML là đc

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
        // allItems đang lưu trữ 19 items

        for (WebElement item: allItems) {
            String textItem =  item.getText();
            System.out.println("Text item = "+textItem);

            //3. Kiểm tra điều kiện đúng thì click vào
            if (textItem.equals("8")){
                item.click();
                break; //9-19 k được kiểm tra nữa
            }

        //Các phép toán trong if : == bằng; != khác bằng ; >= lớn hơn bằng; <= cho case
        // int student = 100; if (student == 100)
        }


       // 3.1 - Nếu như item cần chọn nó hiển thị thì click vào
       // 3.2 - Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiển thị lên rồi mới chọn (Angular/ React/ VueJS/..)
       // 4 - Trước khi click cần kiểm tra nếu như text của item bằng vs item cần chọn thì click vào

        //Rút gọn lại n vẫn dài => viêt hàm
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
        allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
        for (WebElement item: allItems) {
            String textItem =  item.getText();
            System.out.println("Text item = "+textItem);
            if (textItem.equals("10")){
                item.click();
                break;
            }
        }

        //Ngắn gọn bằng hàm
        selectItemDropDown("span#number-button","ul#number-menu div","15");
        SleepInSecond(3);
        driver.navigate().refresh();
        selectItemDropDown("span#number-button","ul#number-menu div","17");
        SleepInSecond(3);
        driver.navigate().refresh();
        selectItemDropDown("span#number-button","ul#number-menu div","18");
        SleepInSecond(3);
        driver.navigate().refresh();
        //
    }


    @Test
    public void TC_01_Jquery() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemDropDown("span#speed-button","ul#speed-menu div","Faster");
        SleepInSecond(2);

        selectItemDropDown("span#files-button","ul#files-menu div","jQuery.js");
        SleepInSecond(1);

        selectItemDropDown("span#number-button","ul#number-menu div","18");
        SleepInSecond(1);

        selectItemDropDown("span#salutation-button","ul#salutation-menu div","Dr.");
        SleepInSecond(1);

    }


    @Test
    public void TC_02_React() {
         driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
         selectItemDropDown("i.dropdown.icon","div.item span","Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Elliot Fu");


        selectItemDropDown("i.dropdown.icon","div.item span","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");


        selectItemDropDown("i.dropdown.icon","div.item span","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");
    }
    @Test
    public void TC_03_VueJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemDropDown("li.dropdown-toggle","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

        selectItemDropDown("li.dropdown-toggle","ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");

        selectItemDropDown("li.dropdown-toggle","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
    }

    @Test
    public void TC_04_Editable_Dropdown() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemEditalbeDropDown("input.search","div.visible span","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("input.search")).getText(),"Algeria");

        selectItemDropDown("input.search","div.visible span","Aland Islands");
        Assert.assertEquals(driver.findElement(By.cssSelector("input.search")).getText(),"Aland Islands");

        selectItemDropDown("input.search","div.visible span","Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("input.search")).getText(),"Belgium");
    }

    @Test
    public void TC_05_Default_Dropdown() {
        driver.get("https://demo.nopcommerce.com/register");
        selectItemEditalbeDropDown("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay'] option", "18");
        //K dùng được
        // Assert.assertEquals(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")).getText(), "18");
        //Dùng isSelected()
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay'] option[value='18']")).isSelected());

        selectItemEditalbeDropDown("select[name='DateOfBirthMonth']", "select[name='DateOfBirthMonth'] option", "August");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth'] option[value='8']")).isSelected());

        selectItemEditalbeDropDown("select[name='DateOfBirthYear']", "select[name='DateOfBirthYear'] option", "1988");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear'] option[value='1988']")).isSelected());

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
    public void selectItemDropDown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click();
        SleepInSecond(1);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems){
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemEditalbeDropDown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        SleepInSecond(1);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems){
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}

