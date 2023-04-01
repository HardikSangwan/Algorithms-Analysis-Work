import java.util.Scanner;
import java.util.Random;

/* 
 * @Adventure
 * Lets the user choose between and play two guessing games and play again if they want to
 * The options for the two games are 1 digit Lottery where a number from 1-9 is randomly generated
 * And, a simple heads or tails game
 * If the user wants to play again they are prompted to select the game they want to play and then the game starts 
 */

    public class Adventure{
    public static void main(String args[]){

	Scanner scan = new Scanner(System.in); //To check user input
	Player player = new Player(); //Creates a player object for the user
	Random rand = new Random(); //To create random numbers for the selected Guessing game
	int play = 1; //To check whether the user wants to continue play
	String value; //value of heads or tails for the Heads or Tails game
	int choiceSet; //To check whether the choice to play or not has been set
	int gameSet; //To check whether the choice of game has been
	int valueSet; //To confirm that the user has only entered h or t (or H or T)
	              //A check for number entered is not required in case of the 1 digit lottery game
	              //because Scanner class's nextInt() method throws an exception if the user does not enter a number
	double game = 0;
	int Actual;
	
	System.out.println("Welcome to the Numbers Adventure \nEnter your Name");
	player.setName(scan.nextLine());
	   
	while (play == 1) {
	    gameSet=0;
	    while (gameSet == 0){
		System.out.println("\nHello "+player.getName()+
			           ", Enter the number for the game you would like to play"
			           +"\n1. 1 Digit Lottery \n2. Heads or Tails"); 
	        game=scan.nextDouble();
		if (game==1 || game==2) {
			    player.setGame(game);
			    gameSet=1;
			}
		    else {
			System.out.println("\nPlease enter either 1 or 2");
			game=scan.nextDouble();
			gameSet=0;
		    }
		}
		if (player.getGame() == 1) {
			System.out.println("\nEnter a guess from 0 to 9");
			player.setGuess(scan.nextInt());
			Actual = rand.nextInt(9);
			if (player.getGuess()==Actual){
				System.out.println("\nThe number was " + Actual +
						   "\nYou Won! Would you like to play again?" +
						   "\nEnter 'N' for No or 'Y' to start again");
			    }
			else {
			    System.out.println("\nThe number was " + Actual +
					       "\nYou Lost. Would you like to play again?" +
					       "\nEnter 'N' for No or 'Y' to start again");
			}
		    }
		else {
		    Actual = rand.nextInt(2);
		    if (Actual==1){
			value="Heads";
		    }
		    else {
			value="Tails";
		    }
		    System.out.println("\nEnter a guess of H or T");
		    valueSet=0;
		    while (valueSet<1){
			if (valueSet==0){
			    scan.nextLine();
			}
			String guess = scan.nextLine();
		        if (guess.equalsIgnoreCase("h")){
			        player.setGuess(1);
			        valueSet=1;
			    }
		        else if (guess.equalsIgnoreCase("t")) {
			    player.setGuess(2);
			    valueSet=1;
		        }
			    else {
			        System.out.println("Please enter either H or T");
			        valueSet=-1;
			    }
		    }
		    
		    if (player.getGuess()==Actual){
			    System.out.println("\nThe value is " + value +
					       "\nYou Won! Would you like to play again?" +
					       "\nEnter 'N' to exit or 'Y' key to start again");
			}
		    else {
		        System.out.println("\nThe value is " + value +
					   "\nYou Lost. Would you like to play again?" +
					   "\nEnter 'N' to exit or 'Y' to start again");
		    }
		}
		choiceSet=0;
		while (choiceSet<1) {
		    if (game == 1 && choiceSet==0){
			scan.nextLine();
		    }
		    String choice=scan.nextLine();
		    if (choice.equalsIgnoreCase("n")){
			    play=0;
			    choiceSet=1;
		        }
		    else if (choice.equalsIgnoreCase("y")){
		        play=1;
		        choiceSet=1;
		    }
		        else {
			    System.out.println("\nPlease enter either y or n");
			    choiceSet=-1;
		        }
		}
	}
    }
    }
		       
	
