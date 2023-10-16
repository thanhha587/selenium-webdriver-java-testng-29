package javaTester;

import java.util.Random;

public class Topic_06_Random {
    //Java Builtin (Cung cấp sẵn lấy ra sử dụng)
    //Java Libraries (Do 1 cá nhân/ tổ chức họ tự viết)

    public static void main(String[] args){
        System.out.println("Hello World");
        Random ran = new Random();
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());

        System.out.println(ran.nextDouble());
        System.out.println(ran.nextBoolean());
        System.out.println(ran.nextFloat());

        System.out.println(ran.nextInt(999));
        System.out.println(ran.nextInt(90));
        System.out.println(ran.nextInt(9));
    }
}
