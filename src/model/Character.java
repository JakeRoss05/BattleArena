package model;

public abstract class Character {
    private final String name;
    private final int maxHealth;
    private int health;

    protected Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    
    public boolean isAlive() { return health > 0; }

    public void takeDamage(int amount) {
        if (amount < 0) amount = 0;
        health = Math.max(0, health - amount);
    }

    public void restoreHealth(int amount) {
        if (amount < 0) amount = 0;
        health = Math.min(maxHealth, health + amount);
    }

    public String shortStats() {
        return name + " (HP: " + health + "/" + maxHealth + ")";
    }

    public String fullStats() {
        return name + " - HP: " + health + "/" + maxHealth;
    }

    public abstract int attack();
}