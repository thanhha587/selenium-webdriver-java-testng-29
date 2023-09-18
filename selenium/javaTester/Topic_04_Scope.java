package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Scope {
    //Các biến được khai báo ở bên ngoài hàm => phạm vi là Class
    // Biến global (toàn cục)
    // Có thể đúng cho tất cả các hàm ở trong 1 CLass đó
    WebDriver driver;

    String homePageURL = "https://www.facebook.com/"; // khai báo declare only
    String fullName = "Automation FC";// khái báo + khởi tạo ( Initial)


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_Url() {
    // Các biến được khai báo ở trong 1 hàm/1 block code -> phạm vi cục bộ ( local)
    // Dùng trong cái hàm nó được khai báo/ block code được sinh ra
        // String homePageURL ; // khai báo declare only
        // Trong 1 hàm: nếu như có biến cùng tên Global và Local thì ưu tiên lấy local
        //Vì thế câu lệnh dưới lấy biến trên được khai báo trong hàm
        //Nếu lấy biến dùng mà chưa khởi tạo => sẽ báo lỗi ngay khi compile code
        String homePageURL = "Test thôi";
        driver.get(homePageURL);

        // Trong hàm mà lấy biến Global thì dùng this => báo lỗi
        // phải chú ý khởi tạo phải khai báo mới lôi ra dùng được
        // Biến Global chưa khởi tạo mà dùng thì Không báo lỗi ở level Compile code
        // Lỗi ở level Runtime báo lỗi testcase
        driver.get(this.homePageURL);

    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }




}
