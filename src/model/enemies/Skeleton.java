package model.enemies;

import model.Enemy;
import util.Dice;

public class Skeleton extends Enemy {
    public Skeleton(String name) {
        super(name, 85); // Skeletons have high health
    }

    @Override
    public int attack() {
        return Dice.range(18) + 12; // Skeletons have a strong attack
    }
}