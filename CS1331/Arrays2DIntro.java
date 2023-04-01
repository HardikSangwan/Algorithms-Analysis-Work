import java.util.Random;

public class Arrays2DIntro {


    public static void main(String[] args) {
        
        /*
        Random rand = new Random();
        
        int[][] testGrades = new int[150][4];
        
        for(int row = 0; row < testGrades.length; row++) {
            for(int col = 0; col < testGrades[row].length; col++) {
                testGrades[row][col] = rand.nextInt(21) + 80; //all As/Bs
                System.out.print(testGrades[row][col] + " ");
            }
            System.out.println();
        }
         */
        /*
        String[][] zoo = new String[2][];
        zoo[0] = new String[2];
        zoo[0][0] = "lion";
        zoo[0][1] = "tiger";
        
        zoo[1] = new String[3];
        zoo[1][0] = "cardinal";
        zoo[1][1] = "eagle";
        zoo[1][2] = "hawks";
        */
        String[][] zoo = {{"lion", "tiger"}, {"cardinal", "eagle", "hawk"}};
        
        for(String[] animalGroup : zoo) {
            for(String animal : animalGroup) {
                System.out.print(animal + " ");
            }
            System.out.println();
        }


    }
}