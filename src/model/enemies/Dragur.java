package model.enemies;

import model.Enemy;
import util.Dice;

public class Dragur extends Enemy {
    public Dragur(String name) {
        super(name, 95); // Dragurs have high health
    }

    @Override
    public int attack() {
        return Dice.range(18) + 12; // Dragurs have a strong attack
    }
}