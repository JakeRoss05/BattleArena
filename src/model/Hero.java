package model;

public abstract class Hero extends Character {
    private int potions;

    protected Hero(String name, int maxHealth, int potions) {
        super(name, maxHealth);
        this.potions = potions;
    }

    public int heal() {
        if (potions <= 0) {
            System.out.println("No potions left!");
            return 0;
        }
        potions--;
        int healAmount = Math.max(10, getMaxHealth() / 5);
        restoreHealth(healAmount);
        return healAmount;
    }

    public void onWinReward() {
        potions++;
        System.out.println("You found a potion on the defeated enemy! Potions: " + potions);
    }

    public abstract int specialAttack();

    public abstract String getClassName();

    @Override
    public String fullStats() {
        return super.fullStats() + "\nClass: " + getClassName() + "\nPotions: " + potions;
    }
}