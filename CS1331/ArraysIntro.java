public class ArraysIntro {


    public static void main(String[] args) {
        
        int[] cavsScores = {89, 77, 120, 78, 112, 115, 93};
        
        int last = cavsScores[7];
        
        //boolean[] cavWin = new boolean[7];
        boolean[] cavWin = new boolean[cavsScores.length];
        //length is a static and final
        
        for (int i=0; i < cavsScores.length; i++) {
            System.out.println(cavsScores[i]);
        }
        
        int total = 0;
        for (int x : cavsScores) {  //for each
            total +=x;
        }
        System.out.println("Average PPG: " + total/cavsScores.length);
        
        boolean[] wins = new boolean[5];
        for (int i=0; i < wins.length; i++) {
            System.out.println(wins[i]);
        }
        
    }
}