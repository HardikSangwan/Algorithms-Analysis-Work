import java.util.Scanner;
public class Recitation3 {
    public static void main(String[] args) {
        //aliasing

        String hi1 = "hi";
        String hi2 = "hi";
        System.out.println("hi1 == hi2 is " + (hi1 == hi2));
        System.out.println("hi1.equals(hi2) is " + hi1.equals(hi2));

        String hello1 = new String("hello");
        String hello2 = new String("hello");
        System.out.println("hi1 == hi2 is " + (hello1 == hello2));
        System.out.println("hi1.equals(hi2) is " + hello1.equals(hello2));

        String greetings1 = new String("greetings");
        String greetings2 = "greetings";
        System.out.println("greetings1 == greetings2 is " + (greetings1 == greetings2));
        System.out.println("greetings1.equals(greetings2) is " + (greetings1.equals(greetings2)));

        //circle class

        //homework help

        //working with branching events
        //
        // if (a) {
        //     //event a happened
        //     if (c) {
        //         //event a and c happened
        //     } else {
        //         //event a and d happened
        //     }
        // } else {
        //     //event b happened
        //     if (e) {
        //         //event b and e happened
        //     } else {
        //         //event b and f happened
        //     }
        // }

        //getting valid input
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("What do you do? [break, wait]");
        do {
            response = scan.nextLine();
            if (!(response.equalsIgnoreCase("break") || response.equalsIgnoreCase("wait"))) {
                System.out.println("Sorry, what was that?");
            }
        } while (!(response.equalsIgnoreCase("break") || response.equalsIgnoreCase("wait")));

        //using a helper method
        response = getResponse("hide", "run");
        if (response.equalsIgnoreCase("hide")) {
            //chose hide
        } else {
            //chose run
        }
    }

    static String getResponse(String optionA, String optionB) {
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("What do you do? [" + optionA + ", " + optionB + "]");
        do {
            response = scan.nextLine();
            if (!(response.equalsIgnoreCase(optionA) || response.equalsIgnoreCase(optionB))) {
                System.out.println("Sorry, what was that?");
            }
        } while (!(response.equalsIgnoreCase(optionA) || response.equalsIgnoreCase(optionB)));
        return response;
    }
}
