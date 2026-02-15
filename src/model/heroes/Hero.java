package model.heroes;

import util.Dice;

public class Hero extends model.Hero {
    public Hero(String name) {
        super(name, 100, 3);
    }

    @Override
    public int attack() {
        return Dice.range(15) + 5; // Basic attack damage
    }

    @Override
    public int specialAttack() {
        return Dice.range(30) + 10; // Stronger attack damage
    }

    @Override
    public String getClassName() {
        return "Hero";
    }
}
