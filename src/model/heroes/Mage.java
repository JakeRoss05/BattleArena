package model.heroes;

import model.Hero;
import util.Dice;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 80, 5); // Mages have less health but more potions
    }

    @Override
    public int attack() {
        return Dice.range(20) + 10; // Mages have a stronger basic attack
    }

    @Override
    public int specialAttack() {
        return Dice.range(40) + 20; // Mages have a powerful special attack
    }

    @Override
    public String getClassName() {
        return "Mage";
    }
}