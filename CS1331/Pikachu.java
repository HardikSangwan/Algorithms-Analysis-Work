import java.util.Random;

/**
*Define a Pikachu object
*@author Hardik Sangwan
*@version 13.31
*/

public class Pikachu extends Pokemon {

    /**
    *Create a pikachu
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    */

    public Pikachu(int level, int maxHealth, int speed) {
        super(level, maxHealth, speed);
    }

    /**
    *Abstract class attack defined
    *@param other Pokemon to be attacked
    */

    public void attack(Pokemon other) {
        Random rand = new Random();
        try {
            other.setCurrentHealth(other.getCurrentHealth()
                - rand.nextInt(99) + 1);
        } catch (IllegalArgumentException a) {
            other.setCurrentHealth(0);
        }
    }

    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if (Pikachu.class.isInstance(other)) {
            equal = super.equals(other);
        }
        return equal;
    }

    @Override
    public String toString() {
        return "Pikachu Level:" + super.getLevel() + "HP:"
            + super.getCurrentHealth() + "/" + super.getMaxHealth()
            + "Speed:" + super.getSpeed();
    }
}