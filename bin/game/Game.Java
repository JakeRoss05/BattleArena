package game;

//Good
import model.Hero;
import model.Mage;
import model.Wizard;

//Bad
import model.Skeleton;
import model.Dragur;
import model.Critter;



import java.util.ArrayList;
import java.util.List;

public class Game {
    public void run() {
        System.out.println("Welcome to Battle Arena!");

        Hero hero = chooseHero();
        System.out.println("You have chosen: " + hero.getName() + "(" +hero.getClassName() + ")");

        List<Enemy> wave = buildWave();
        Arena arena = new Arena(hero, wave);
        arena.fight();

        System.out.println("Game Over!");
    }

    private Hero chooseHero () {
        System.out.println("Choose your hero:");
        System.out.println("1. Hero");
        System.out.println("2. Mage");
        System.out.println("3. Wizard");

        int choice = InputHelper.getIntInRange(1, 3);

        return switch (choice) {
            case 1 -> new Hero("Arthas");
            case 2 -> new Mage("Jaina");
            default -> throw new Wizard("Medivh");
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