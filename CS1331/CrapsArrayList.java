
import java.util.ArrayList;

public class CrapsArrayList {
	
	private Die die1, die2;
	private int point;
	private ArrayList<Integer> die1History, die2History;
	private int tossCount;
	
	public CrapsArrayList() {
		die1 = new Die();
		die2 = new Die();
		die1History = new ArrayList<Integer>();
		die2History = new ArrayList<Integer>();
		tossCount = 0;
	}
	
	private int toss() {
		
		die1History.add(die1.roll()); //will it autobox for me?
		die2History.add(die2.roll());
		
		int total = die1History.get(tossCount) + die2History.get(tossCount);
		System.out.println("total: " + total);
		
		tossCount++;
		//	System.out.println("Die 1: " + die1 + "Die 2: " + die2);
		return total;
		
	}
		
	
	public void go() {
		
		point = toss();
		//System.out.println("Point: " + point);
		
		if ((point == 7) || (point == 11)) { 
			System.out.println("Winner");
		}
		else if ((point == 2) || (point == 3) || (point == 12)) { 
			System.out.println("You lose. Go home!");
		}
		else {
			stage2();
		}
	}
	
	private void stage2() {
		int total = toss();
		//System.out.println("total: " + total);
		if (total == point) {
			System.out.println("Winner");
		}
		else if (total == 7) {
			System.out.println("Craps, you lose!");
		}
		else {
			stage2();
		}
		
	}
	
	
	public String toString() {
		
		String history = "";
		/*
		for (int i = 0; i < tossCount; i++) {
			history += (die1History[i] + " --- " + die2History[i] + "\n");
		}
		 */
		history+="Die 1 History\n";
		for (Integer tot : die1History) {
			history += ""+tot+"\n";
		}
		history += "\n";
		
		history+="Die 2 History\n";
		for (Integer tot : die2History) {
			history += ""+tot+"\n";
		}
		history +="\n";
		
		return history;
	}
	
	public static void main(String[] args) {
		//Create an instance of the game of craps
		CrapsArrayList game = new CrapsArrayList();
		game.go();
		System.out.println(game.toString());
		
	}
	
}
