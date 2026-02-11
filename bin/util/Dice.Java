package util;

import java.util.Random;

public class Dice {
    private static final Random RNG = new Random();

    public static int range(int sides) {
        return RNG.nextInt(sides) + 1;
    }

    public static boolean chancePercent(int percent) {
        return range(100) <= percent;
    }
}