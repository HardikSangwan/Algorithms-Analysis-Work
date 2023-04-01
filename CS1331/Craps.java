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

public class Craps {
    
    
    private Die die1, die2;
    private int point;
    
    public Craps() {
        die1 = new Die();
        die2 = new Die();
    }
    
    private int toss() {
        int total = die1.roll() + die2.roll();
        System.out.println("Die 1: " + die1.getFaceValue() + " Die 2: " + die2.getFaceValue());
        return total;
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
        Craps game;
        while (keepGoing) {
            game = new Craps();
            game.go();
            
            System.out.println("Would you like to continue? (Y/N)");
            String keepGoingStr = scan.nextLine();
            
            if (keepGoingStr.equalsIgnoreCase("N")) {
                keepGoing = false;
                
            }
            
            
            
        }
    }
}