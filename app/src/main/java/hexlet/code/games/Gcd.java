package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Gcd {
    public static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final Random RANDOM = new Random();

    /**
     * Starts the game for the "Greatest Common Divisor (GCD)" challenge.
     *
     * <p>This method retrieves the game data, including questions and answers, by calling {@link #getArResult()}.
     * It then passes the game rules and data to the
     * {@link Engine#play(String, String[][])} method to initiate the game.</p>
     */
    public static void startGameGCD() {
        String[][] arResult = getArResult();
        Engine.play(GAME_RULE, arResult);
    }

    /**
     * Generates a 2D array containing questions and their corresponding correct answers for the GCD challenge.
     *
     * <p>This method generates pairs of random numbers and calculates their greatest common divisor (GCD).
     * Each pair of numbers forms a question, and the GCD is the correct answer. The results are stored in a 2D array
     * where each row contains a question and its correct answer.</p>
     *
     * @return A 2D array of questions and correct answers for the GCD game. Each row contains:
     *         <ul>
     *             <li>Column 0: The question (a pair of numbers as a string).</li>
     *             <li>Column 1: The correct answer (the GCD of the numbers).</li>
     *         </ul>
     */
    private static String[][] getArResult() {

        int winScore = Engine.getWinValue();
        final int COLUMNS = 2; // count of variable answer (right or wrong)
        final int END_OF_RANGE = 100; // higher number range to 100
        final int ONE_STEP = 1; // integer for add number to 100
        String[][] arResult = new String[winScore][COLUMNS];

        for (int i = 0; i < winScore; i++) {
            int num1 = RANDOM.nextInt(END_OF_RANGE) + ONE_STEP;
            int num2 = RANDOM.nextInt(END_OF_RANGE) + ONE_STEP;

            String question = (num1) + " " + (num2);
            String correctAnswer = calculate(num1, num2);
            arResult[i][0] = question;
            arResult[i][1] = correctAnswer;
        }
        return arResult;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * <p>The method repeatedly divides the larger number by the smaller number and replaces the larger number with
     * the remainder until the remainder is zero. The last non-zero remainder is the GCD.</p>
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The greatest common divisor (GCD) of the two integers.
     */
    public static String calculate(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return String.valueOf(num1);
    }
}
