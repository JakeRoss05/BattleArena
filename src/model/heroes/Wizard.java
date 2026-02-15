package model.heroes;

import model.Hero;
import util.Dice;

public class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 70, 7); // Wizards have less health but more potions
    }

    @Override
    public int attack() {
        return Dice.range(25) + 15; // Wizards have a stronger basic attack
    }

    @Override
    public int specialAttack() {
        return Dice.range(50) + 30; // Wizards have a powerful special attack
    }

    @Override
    public String getClassName() {
        return "Wizard";
    }
}
