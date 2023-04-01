import java.util.Random;

/**
*Define a Pikachu object
*@author Hardik Sangwan
*@version 13.31
*/

public class Magikarp  extends Pokemon {
    private double luck;

    /**
    *Create a Magikarp
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    */

    public Magikarp(int level, int maxHealth, int speed) {
        this(level, maxHealth, speed, 0.15);
    }

    /**
    *Create a Magikarp
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    *@param luck Pokemon's luck
    */

    public Magikarp(int level, int maxHealth, int speed, double luck) {
        super(level, maxHealth, speed);
        this.setLuck(luck);
    }

    /**
    *Set the Pokemon's luck
    *@param luck Pokemon's luck
    */

    public void setLuck(double luck) {
        if (luck > 1 || luck < 0) {
            throw new IllegalArgumentException("Out of Range");
        }
        this.luck = luck;
    }

    /**
    *Abstract class attack defined
    *@param other Pokemon to be attacked
    */

    public void attack(Pokemon other) {
        Random rand = new Random();
        if (rand.nextDouble() < luck) {
            other.setCurrentHealth(0);
        }
    }

    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if (Magikarp.class.isInstance(other)) {
            equal = super.equals(other);
        }
        return equal;
    }

    @Override
    public String toString() {
        return "Magikarp Level:" + super.getLevel() + " HP:"
            + super.getCurrentHealth() + "/" + super.getMaxHealth()
            + " Speed:" + super.getSpeed() + " Luck:"
            + String.format("%.2f", luck);
    }
}