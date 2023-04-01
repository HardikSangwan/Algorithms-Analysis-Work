import java.util.Scanner;

public class DynamicTemp2 {
    
    
    public static void main(String[] args) {
        
        boolean keepGoing = true;
        double celsius;
        int temp;
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing) {
            System.out.println("Please enter a Fahrenheit temperature" +
                               " to convert to Celsius: <then press enter>");
            temp = Integer.parseInt(scan.nextLine());
            
            System.out.println("What city is that?");
            String city = scan.nextLine();
            
            double celsiusx = (5.0/9)*(temp - 32);
            
            System.out.println("The temp in " + city + " is " + celsiusx + "C");
            
            System.out.println("Would you like to continue? (Y/N)");
            String keepGoingStr = scan.nextLine();
            
            if (keepGoingStr.equalsIgnoreCase("N")) {
                keepGoing = false;
                
            }
            
        }
        
        //System.out.println(celsius);

        
    }
    
}