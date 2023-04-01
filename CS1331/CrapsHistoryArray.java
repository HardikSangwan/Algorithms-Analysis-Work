import java.util.Scanner;
/*
 Brief rules:
 come out roll:
 win: 7 or 11
 lose 2, 3, or 12
 
 4, 5, 6, 7, 8, 9, 10 (called the point numbers)
 
 stage2
 win: roll the point
 lose: 7
 */

public class CrapsHistoryArray {
    
    
    private Die die1, die2;
    private int[] die1History, die2History;
    private int point;
    private int tossCount;
    public static final int HISTORY_SIZE = 4;
    
    public CrapsHistoryArray() {
        die1 = new Die();
        die2 = new Die();
        die1History = new int[HISTORY_SIZE];
        die2History = new int[HISTORY_SIZE];
        tossCount = 0;

    }
    
    private int toss() {
        
//        if (tossCount > (die1History.length - 2)) {
        if (tossCount == die1History.length) {
            growHistories();
        }
        die1History[tossCount] = die1.roll();
        die2History[tossCount] = die2.roll();

        int total = die1History[tossCount] + die2History[tossCount];
        System.out.println("Die 1: " + die1History[tossCount] + " Die 2: " + die2History[tossCount]);
        tossCount++;
        return total;
    }
    
    private void growHistories() {
        System.out.println("growing...");
        int[] temp1History = new int[2 * die1History.length];
        int[] temp2History = new int[2 * die2History.length];
        
        for(int i = 0; i < die1History.length; i++) {
            temp1History[i] = die1History[i];
            temp2History[i] = die2History[i];
        }

        die1History = temp1History;
        die2History = temp2History;
    }
    
    public void go() {
        point = toss();
        System.out.println("First toss is: " + point);
        if ((point == 7) || (point == 11)) {
            System.out.println("You rock! Win!!!");
        }
        else if ((point == 2) || (point == 3) || (point == 12)) {
            System.out.println("You dont rock! Lose!!!");
        }
        else {
            //stage2();
            stage2Recursive();
        }
    }
    
    private void stage2() {
        
        boolean endGame = false;
        
        while (!endGame) {
            int total = toss();
            System.out.println("Toss is: " + total);
            if (total == point) {
                System.out.println("You rock! Win!!!");
                endGame = true;
            }
            else if (total == 7) {
                System.out.println("You dont rock! Lose!!!");
                endGame = true;
            }
            
        }
    }
    
    private void stage2Recursive() {
        
        
        int total = toss();
        System.out.println("Toss is: " + total);
        if (total == point) {
            System.out.println("You rock! Win!!!");
        }
        else if (total == 7) {
            System.out.println("You dont rock! Lose!!!");
        }
        else {
            stage2Recursive();
        }
        
    }
    
    
    public static void main(String[] args) {
        boolean keepGoing = true;
        Scanner scan = new Scanner(System.in);
        CrapsHistoryArray game;
        while (keepGoing) {
            game = new CrapsHistoryArray();
            game.go();
            
            System.out.println("Would you like to continue? (Y/N)");
            String keepGoingStr = scan.nextLine();
            
            if (keepGoingStr.equalsIgnoreCase("N")) {
                keepGoing = false;
                
            }
            
            
            
        }
    }
}