package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    public static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    /**
     * Starts the game for the "Even" challenge by retrieving the game data and passing it to the engine for processing.
     *
     * <p>This method fetches the results array (arResult) through the {@link #getArResult()} method,
     * which contains the necessary
     * game data, and then calls the {@link Engine#play(String, String[][])} method to
     * initiate the game using the game rules
     * (GAME_RULE) and the retrieved data.</p>
     */
    public static void startGameEven() {
        String[][] arResult = getArResult();
        Engine.play(GAME_RULE, arResult);
    }

    /**
     * Generates a 2D array containing questions and their corresponding correct answers for the "Even" challenge.
     *
     * <p>This method generates a set of random numbers and determines whether each number is even or odd. It creates a
     * 2D array where each row consists of a question (the number) and the correct
     * answer ("yes" for even, "no" for odd).</p>
     *
     * @return A 2D array of questions and correct answers, where each row contains a
     * question and its corresponding correct answer.
     */
    private static String[][] getArResult() {

        int winScore = Engine.getWinValue();
        int columns = 2; // count of variable answer (right or wrong)
        int endOfRange = 100; // higher number range to 100
        int oneStep = 1; // integer for add number to 100
        String[][] arResult = new String[winScore][columns];

        for (int i = 0; i < winScore; i++) {
            Random random = new Random();
            int number = random.nextInt(endOfRange) + oneStep;
            String question = String.valueOf(number);
            String correctAnswer = isEven(number);
            arResult[i][0] = question;
            arResult[i][1] = correctAnswer;
        }
        return arResult;
    }

    /**
     * Determines whether a given number is even or odd.
     *
     * <p>This method checks if the provided number is divisible by 2 and returns "yes" if the number is even,
     * or "no" if the number is odd.</p>
     *
     * @param number The number to be checked for evenness.
     * @return "yes" if the number is even, "no" if the number is odd.
     */
    private static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
