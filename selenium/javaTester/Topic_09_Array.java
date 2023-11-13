package javaTester;

public class Topic_09_Array {
    int[] studentAge = {5,10,15,22};
    static String[] studentName = {"Nguyễn Văn A","Trần Thị B"};

    public static void main(String[] args){
        String[] studentAddress = new String[5];

        studentAddress[0] = "Nguyễn Trãi";
        studentAddress[1] = "Nguyễn Du";
        studentAddress[2] = "Nguyễn Thi Định";
        studentAddress[3] = "Trần";
        studentAddress[4] = "Trãi";
       // studentAddress[5] = "Nguyễn Trãi"; sẽ báo lỗi nếu gán giá trị quá số mảng có

        System.out.println(studentName[0]);
        System.out.println(studentName[1]);
//        Topic_09_Array topic = new Topic_09_Array();
//        System.out.println(topic.studentAge[0]);

        for (int i = 0; i < studentAddress.length;i++){
            System.out.println(studentAddress[i]);
        }

    }
}
