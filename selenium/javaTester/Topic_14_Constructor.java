package javaTester;

public class Topic_14_Constructor {
    //1 class nêú k define cái constructor cụ thể thì nó sẽ có 1 constructor rỗng ( default)

    // Là 1 cái hàm cùng tên vs class
    // k có kiểu dữ liệu trả về ( nên k có void String hay gì cả...)
    //Trong 1 class có nhiều constructor được
    // 1 class nếu k define constructor cụ thể thì nó sẽ có 1 constructor rống (default)
    // nếu define thì khi khởi tạo nó bắt buộc phải gọi tới constructor mà mình define
    public Topic_14_Constructor(String name) {
        System.out.println(name);
    }
    public Topic_14_Constructor(int numberofStudent) {
        System.out.println(numberofStudent);
    }
    //Dùng nhiều tham số
    public Topic_14_Constructor(String name, int numberofStudent) {
        System.out.println(numberofStudent);
    }

    public static void main(String[] args) {
        Topic_14_Constructor topic01 = new Topic_14_Constructor("Automation FC");// gọi cái hàm String
        Topic_14_Constructor topic02 = new Topic_14_Constructor(15); // gọi cái hàm int
        Topic_14_Constructor topic03 = new Topic_14_Constructor("Automation",14); // gọi cái hàm int và String
    }

}

