/*
 * @Player
 * Defines the player that plays in Adventure
 * Provides setter and getter methods for player variables
 */

public class Player{
    private double game = 0;
    private String name = "NA";
    private int guess = 1;

    public void setGame(double game){
	this.game = game;
    }
    public void setName(String val){
	name = val;
    }
    public void setGuess(int num2){
	guess = num2;
    }
    public double getGame(){
	return game;
    }
    public String getName(){
	return name;
    }
    public int getGuess(){
	return guess;
    }
}
