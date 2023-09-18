package javaTester;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.ArrayList;


public class Topic_01_Data_Type {
    /*Kiểu dữ liệu
    I. Kiểu dữ liệu nguyên thuỷ (Primitive Type)
    Số nguyên: byte - short - int - long
    K có phần thập phân: nhân viên công ty/ học sinh/...
     */
    byte Number = 40;
    short sNumber = 5087;
    int iNumber = 2343;
    long lNumber = 27823758;

    /* Số thực : float - double
    Có phần thập phân: điểm số, tiền ...
     */
    float fNumber = 23.45f;
    double dNumber = 24.9008;

    /* Ký tự: char
    đại diện cho 1 ký tự
     */
    char c ='m';
    /* Logic: boolean ( luận lý)
    Kết qủa bài test : pass/fail ( k ngoại lệ)
     */
    boolean status = false;
    /* II. Kiểu dữ liệu tham chiếu
    Class
     */
    FirefoxDriver firefoxDriver= new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    //Interface
    WebDriver driver;
    //JavascriptExecutor jsExecutor;

    //Object
    Object name = "Automation FC";

    //Array (kiểu nguyên thuỷ/tham chiếu)
    int[] student_Age = {15,18,20};
    String[] student_Name = {"Automation","Test"};
    String String = "LAM VIEC";
    /*Collection: List/Set/Queue
    List[String] student_Address = new ArrayList<String>();
    List[String] student_City = new LinkedList<>();
    List[String] student_phone = new Vector<>();

    //String chuỗi ký tự
    String Fullname = "Thanh Hà";

     */









}
