import java.util.Random;

public class Die {
    
    
    private int faceValue;
    private Random rand;

    public final static int SIDES = 6;
    
    public Die() {
        rand = new Random();
        roll();
    }
    
    public int roll() {
        faceValue = rand.nextInt(SIDES) + 1;
        return faceValue;
    }

    
    
    public int getFaceValue() {
        return faceValue;
    }
    
    public String toString() {
        return("Die face value = " + faceValue);
    }


    
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();

        System.out.println(die1.roll());
        System.out.println(die1.roll());

        System.out.println(die2.roll());

        System.out.println(die2.roll());
        
    }

}