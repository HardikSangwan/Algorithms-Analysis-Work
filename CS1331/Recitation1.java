import java.util.Scanner;
import java.text.DecimalFormat;
public class Recitation1 {
    public static void main(String[] args) {
        System.out.print("Me");
        System.out.print("ow!");

        System.out.println("Johhny");
        System.out.println("Chimpo");

        String hello = "    Hello, World!    ";
        String helloFixed = hello.trim();
        System.out.println(helloFixed);
        System.out.println(helloFixed.toLowerCase());
        System.out.println(helloFixed.charAt(1));
        System.out.println(helloFixed.indexOf("W"));
        System.out.println(helloFixed.equals(helloFixed));
        System.out.println(helloFixed.equals(helloFixed.toUpperCase()));

        System.out.printf("%d %s.\n", 7, "Samurai");
        System.out.printf("%10d\n", 10);

        System.out.printf("I like %3.2f.%n", Math.PI);

        DecimalFormat d = new DecimalFormat("###,###.##");
        System.out.println(d.format(123456789.123));

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your three test scores, seperated by spaces.");
        int exam1 = scan.nextInt();
        int exam2 = scan.nextInt();
        int exam3 = scan.nextInt();
        int examAvg = (int) ((exam1 + exam2 + exam3) / 3.0);

        System.out.printf("Your exam average is %d%n", examAvg);
    }
}
