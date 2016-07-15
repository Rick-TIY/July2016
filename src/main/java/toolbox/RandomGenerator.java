package toolbox;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random(System.currentTimeMillis());

    // Just a random number
    public static int randomInt() {
        return random.nextInt();
    }

    // A random number between two numbers
    public static int randomInt(int min, int max) {
        int randomNumber = random.nextInt((max - min) +1) +min;
        return randomNumber;
    }
}
