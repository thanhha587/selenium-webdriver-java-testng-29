package javaTester;

public class Topic_08_Parameter {
    static String fullNameglobal = "Automation Testing";
    public static void main(String[] args){
       System.out.println(getFullname());
       
       //Tham số
        setFullName("manual Testing");
        System.out.println(getFullname());

    }
    public static void setFullName(String fullName){
        fullNameglobal = fullName;
    }
    
    public static String getFullname() {
        return fullNameglobal;
    }



}
