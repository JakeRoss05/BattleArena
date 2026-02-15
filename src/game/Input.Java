package game;

import java.util.Scanner;

public class Input {
    public static final Scanner SC = new Scanner(System.in);

    public static int getIntInRange(int min, int max) {
        return readIntInRange("Enter choice: ", min, max);
    }

    public static int readIntInRange(String prompt, int min, int max) {
        while(true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int value = Integer.parseInt(s);
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}