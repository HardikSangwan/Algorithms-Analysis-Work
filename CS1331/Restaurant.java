import java.util.Scanner;
import java.util.Random;

/**
*Represents a restaurant open from 5 pm - 11 pm
*that has 3 chefs that only serve three types of ramen bowls
*It's really niche
*
*@author Hardik Sangwan
*@version 6.9
*/

public class Restaurant {
    /**
    *main being main
    *@param args Who knows
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.printf("Noodle Chef's Name: ");
        String noodleChefName = scan.nextLine();

        System.out.printf("Amount of Noodles for Chef: ");
        double noodleChefNoodles = Double.parseDouble(scan.nextLine());

        Chef noodleChef = new Chef(noodleChefName, noodleChefNoodles);

        System.out.printf("\nVegetarian Chef's Name: ");
        String vegChefName = scan.nextLine();

        System.out.printf("Amount of Noodles for Chef: ");
        double vegChefNoodles = Double.parseDouble(scan.nextLine());

        System.out.printf("Amount of Vegetables for Chef: ");
        double vegChefVeg = Double.parseDouble(scan.nextLine());

        Chef vegChef = new Chef(vegChefName, vegChefNoodles, vegChefVeg);

        System.out.printf("\nCombo Chef's Name: ");
        String comboChefName = scan.nextLine();

        System.out.printf("Amount of Noodles for Chef: ");
        double comboChefNoodles = Double.parseDouble(scan.nextLine());

        System.out.printf("Amount of Vegetables for Chef: ");
        double comboChefVeg = Double.parseDouble(scan.nextLine());

        System.out.printf("Amount of Pork for Chef: ");
        double comboChefPork = Double.parseDouble(scan.nextLine());

        Chef comboChef = new Chef(comboChefName, comboChefNoodles,
            comboChefVeg, comboChefPork);

        double time = 5;
        double dt = 0.5;

        System.out.println("\n* SIMULATING *");

        while (time <= 10.5) {

            if (time % 1 == 0) {
                System.out.println("\n* Time: " + (int) time + ":00 - "
                    + (int) time  + ":30 *\n");
            } else {
                System.out.println("\n* Time: " + (int) time + ":30 - "
                    + (int) (time + 1)  + ":00 *\n");
            }

            int order1 = rand.nextInt(6);
            for (int i = 1; i <= order1; i++) {
                noodleChef.cook((double) ((rand.nextInt(49) + 1) / 10));
            }

            int order2 = rand.nextInt(6);
            for (int i = 1; i <= order2; i++) {
                vegChef.cook((double) ((rand.nextInt(49) + 1) / 10),
                    (double) ((rand.nextInt(49) + 1) / 10));
            }

            int order3 = rand.nextInt(6);
            for (int i = 1; i <= order3; i++) {
                comboChef.cook((double) ((rand.nextInt(49) + 1) / 10),
                    (double) ((rand.nextInt(49) + 1) / 10),
                    (double) ((rand.nextInt(49) + 1) / 10));
            }

            System.out.println(noodleChef.toString());
            System.out.println(vegChef.toString());
            System.out.println(comboChef.toString());
            time = time + dt;
            if (time % 1 == 0) {
                System.out.println("\n* RESUPPLY! *");
                noodleChef.restock(20, 0, 0);
                vegChef.restock(20, 20, 0);
                comboChef.restock(20, 20, 20);
            }
        }
        System.out.println("\n* FINAL RESULTS : *");
        System.out.println(noodleChef.toString());
        System.out.println(vegChef.toString());
        System.out.println(comboChef.toString());
        System.out.println(String.format("\nIn total, %.0f bowls of ramen were"
            + " served.", Chef.getTotalBowls()));
    }
}