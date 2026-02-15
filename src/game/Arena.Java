package game;

import java.util.List;
import model.Enemy;
import model.Hero;

public class Arena {
    private final Hero hero;
    private final List<Enemy> enemies;

    public Arena(Hero hero, List<Enemy> enemies) {
        this.hero = hero;
        this.enemies = enemies;
    }

    public void fight() {
        for (Enemy enemy : enemies) {
            System.out.println("A wild " + enemy.getName() + " appears!");

            while (hero.isAlive() && enemy.isAlive()) {
                System.out.println("\n" + hero.shortStats() + " vs " + enemy.shortStats());
                heroTurn(enemy);

                if (enemy.isAlive()) {
                    enemyTurn(enemy);
                }
            }

            if (!hero.isAlive()) {
                System.out.println("You have been defeated by " + enemy.getName() + "!");
                return;
            }

            System.out.println("You have defeated " + enemy.getName() + "!");
            hero.onWinReward();
        }

        System.out.println("You cleared the Battle Arena!");
    }

    private void heroTurn(Enemy enemy) {
        System.out.println("Choose your action:");
        System.out.println("1. Attack");
        System.out.println("2. Special Attack");
        System.out.println("3. Heal");
        System.out.println("4. View Stats");

        int choice = Input.getIntInRange(1, 4);

        switch (choice) {
            case 1 -> {
                int damage = hero.attack();
                enemy.takeDamage(damage);
                System.out.println("You dealt " + damage + " damage to " + enemy.getName() + "!");
            }
            case 2 -> {
                int damage = hero.specialAttack();
                enemy.takeDamage(damage);
                System.out.println("You used your special attack and dealt " + damage + " damage to " + enemy.getName() + "!");
            }
            case 3 -> {
                int healed = hero.heal();
                System.out.println("You healed yourself for " + healed + " HP!");
            }
            case 4 -> {
                System.out.println("\n" + hero.fullStats());
                heroTurn(enemy); // Allow the player to choose an action again after viewing stats
            }
        }
    }

    private void enemyTurn(Enemy enemy) {
        int damage = enemy.attack();
        hero.takeDamage(damage);
        System.out.println(enemy.getName() + " attacks you and deals " + damage + " damage!");
    }
}