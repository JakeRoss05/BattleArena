package model.enemies;

import model.Enemy;
import util.Dice;
public class Critter extends Enemy {
    public Critter(String name) {
        super(name, 30); // Critters have low health
    }

    @Override
    public int attack() {
        return Dice.range(10) + 2; // Critters have a weak attack
    }
}