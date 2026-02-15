package game;

import java.util.ArrayList;
import java.util.List;

import model.Enemy;
import model.enemies.Critter;
import model.enemies.Dragur;
import model.enemies.Skeleton;
import model.heroes.Hero;
import model.heroes.Mage;
import model.heroes.Wizard;

public class Game {
    public void run() {
        System.out.println("Welcome to Battle Arena!");

        model.Hero hero = chooseHero();
        System.out.println("You have chosen: " + hero.getName() + "(" +hero.getClassName() + ")");

        List<Enemy> wave = buildWave();
        Arena arena = new Arena(hero, wave);
        arena.fight();

        System.out.println("Game Over!");
    }

    private model.Hero chooseHero () {
        System.out.println("Choose your hero:");
        System.out.println("1. Hero");
        System.out.println("2. Mage");
        System.out.println("3. Wizard");

        int choice = Input.getIntInRange(1, 3);

        return switch (choice) {
            case 1 -> new Hero("Arthas");
            case 2 -> new Mage("Jaina");
            default -> new Wizard("Medivh");
        };
    }

    private List<Enemy> buildWave() {
        List<Enemy> wave = new ArrayList<>();
        wave.add(new Skeleton("Rob"));
        wave.add(new Dragur("Sven"));
        wave.add(new Critter("Bob"));
        return wave;
    }
}