import java.util.Scanner;

public class ExceptionsProp {

    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("start main");
        foo();
        System.out.println("end main");
    }
    
    public static void foo() {
        System.out.println("start foo");
        System.out.println("Please enter a number:");
        try {
        bar(Integer.parseInt(scan.nextLine()));
        }
        catch(ArithmeticException ae) {
            foo();
        }
        System.out.println("end foo");

    }
    
    public static void bar(int denom) {
        System.out.println("start bar");
        int x = 9/denom;
        System.out.println("end bar");


    }


}