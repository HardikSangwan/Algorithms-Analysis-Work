/**
*Define a Pokemon object
*@author Hardik Sangwan
*@version 13.31
*/

public abstract class Pokemon implements Comparable<Pokemon> {
    private int level;
    private int currentHealth;
    private int maxHealth;
    private int speed;

    /**
    *Create a pokemon
    *
    *@param level level of Pokemon
    *@param maxHealth Pokemon's max health
    *@param speed Pokemon's speed
    */

    public Pokemon(int level, int maxHealth, int speed) {
        this.setLevel(level);
        this.setMaxHealth(maxHealth);
        this.setSpeed(speed);
        this.setCurrentHealth(maxHealth);
    }

    /**
    *Abstract class attack to be defined in derived classes
    *@param other Pokemon to be attacked
    */

    public abstract void attack(Pokemon other);

    /**
    *Checks if Pokemon are equal
    *@param other Pokemon object to be checked against
    *@return equal Whether they are equal or not
    */

    public boolean equals(Object other) {
        if (other == null
            || !Pokemon.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        Pokemon otherPok = (Pokemon) other;
        return this.getLevel() == otherPok.getLevel()
            && this.getMaxHealth() == otherPok.getMaxHealth()
            && this.getSpeed() == otherPok.getSpeed()
            && this.getCurrentHealth() == otherPok.getCurrentHealth();
    }

    @Override
    public int compareTo(Pokemon other) {
        if (this.level == other.getLevel()) {
            if (this.maxHealth == other.getMaxHealth()) {
                return this.speed - other.getSpeed();
            } else {
                return this.maxHealth - other.getMaxHealth();
            }
        } else {
            return this.level - other.getLevel();
        }
    }

    /**
    *Set the Pokemon's level
    *@param level Pokemon's current level
    */

    public void setLevel(int level) {
        if (level > 100 || level < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        this.level = level;
    }

    /**
    *Set the Pokemon's maxHealth
    *@param maxHealth Pokemon's max Health
    */

    public void setMaxHealth(int maxHealth) {
        if (maxHealth > 500 || level < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        this.maxHealth = maxHealth;
    }

    /**
    *Set the Pokemon's speed
    *@param speed Pokemon's speed
    */

    public void setSpeed(int speed) {
        if (speed > 180 || speed < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        this.speed = speed;
    }

    /**
    *Set the Pokemon's currentHealth
    *@param currentHealth Pokemon's current health
    */

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth > maxHealth || currentHealth < 0) {
            throw new IllegalArgumentException("Out of Range");
        }
        this.currentHealth = currentHealth;
    }

    /**
    *Get the Pokemon's level
    *@return level Pokemon's current level
    */

    public int getLevel() {
        return level;
    }

    /**
    *Get the Pokemon's max Health
    *@return maxHealth Pokemon's max Health
    */

    public int getMaxHealth() {
        return maxHealth;
    }

    /**
    *Get the Pokemon's speed
    *@return speed Pokemon's current speed
    */

    public int getSpeed() {
        return speed;
    }

    /**
    *Get the Pokemon's speed
    *@return current Health Pokemon's current health
    */

    public int getCurrentHealth() {
        return currentHealth;
    }
}