/**
*Define a Pikachu object
*@author Hardik Sangwan
*@version 13.31
*/

public class Ditto extends Pokemon {
    private Pokemon form;

    /**
    *Create a Ditto
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    */

    public Ditto(int level, int maxHealth, int speed) {
        this(level, maxHealth, speed, null);
    }

    /**
    *Create a ditto
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    *@param form Pokemon's form
    */

    public Ditto(int level, int maxHealth, int speed, Pokemon form) {
        super(level, maxHealth, speed);
        this.transform(form);
    }

    /**
    *Abstract class attack defined
    *@param other Pokemon to be attacked
    */

    public void attack(Pokemon other) {
        if (form == null && Ditto.class.isAssignableFrom(other.getClass())) {
            form = other;
        } else if (form == null) {
            other.setCurrentHealth(other.getCurrentHealth() - 1);
        } else {
            form.attack(other);
        }
    }

    /**
    *Initialize form with other
    *@param other Pokemon to be initialized into form
    */

    public void transform(Pokemon other) {
        if (Ditto.class.isAssignableFrom(other.getClass()) && other != null) {
            throw new IllegalArgumentException("Cannot be Ditto");
        }
        form = other;
    }

    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if (Ditto.class.isInstance(other)) {
            equal = super.equals(other);
        }
        return equal;
    }

    @Override
    public String toString() {
        return "Ditto Level:" + super.getLevel() + "HP:"
            + super.getCurrentHealth() + "/" + super.getMaxHealth()
            + "Speed:" + super.getSpeed();
    }
}