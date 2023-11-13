package javaTester;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_11_List {
    @Test
    public void testList() {
        //Array truy xuất dữ liệu (query)
        List<String> studentName = new ArrayList<String>();
        studentName.add("Nguyễn Đình Lương");
        studentName.add("Nguyễn Thi Bình");
        studentName.add("Trần Vị Đình");
        studentName.add("Phan Văn Phương");

        //4 Elements trong nhóm
        System.out.println(studentName.size());
        System.out.println(studentName.get(0));
        System.out.println(studentName.get(1));
        System.out.println(studentName.get(2));
        System.out.println(studentName.get(3));
       // System.out.println(studentName.get(4));





        //LinkedList - thêm sửa xoá



    }

}
