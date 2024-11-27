package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final Random RANDOM = new Random();


    /**
     * Starts the "Prime Number" game by preparing the game data and passing it to the engine.
     *
     * <p>This method generates the game data by calling {@link #getArResult()}, which prepares a set of questions
     * and their correct answers. It then uses the {@link Engine#play(String, String[][])} method to execute the game
     * with the provided game rules and data.</p>
     */
    public static void startGamePrime() {
        String[][] arResult = getArResult();
        Engine.play(GAME_RULE, arResult);
    }

    /**
     * Generates a 2D array containing questions and correct answers for the "Prime Number" game.
     *
     * <p>This method creates a set of random numbers as questions and determines whether each number is prime.
     * The results are stored in a 2D array, where each row consists of a question (the number as a string)
     * and the correct answer ("yes" if the number is prime, "no" otherwise).</p>
     *
     * @return A 2D array of questions and correct answers for the "Prime Number" game. Each row contains:
     *         <ul>
     *             <li>Column 0: The question (a random number as a string).</li>
     *             <li>Column 1: The correct answer ("yes" if the number is prime, "no" otherwise).</li>
     *         </ul>
     */
    private static String[][] getArResult() {
        int columns = 2; // count of variable answer (right or wrong)
        int endOfRange = 100; // integer, higher number range
        int oneStep = 1; // integer for add number to 100
        int WinScore = Engine.getWinValue();
        String[][] arResult = new String[WinScore][columns];

        for (int i = 0; i < WinScore; i++) {
            int number = RANDOM.nextInt(endOfRange) + oneStep;
            String question = String.valueOf(number);
            String correctAnswer = getCorrectAnswer(number);
            arResult[i][0] = question;
            arResult[i][1] = correctAnswer;
        }
        return arResult;
    }

    /**
     * Determines the correct answer for the "Prime Number" game based on whether the input number is prime.
     *
     * <p>This method checks if the provided number is a prime number using the getCorrectAnswer method.
     * It returns "yes" if the number is prime, or "no" otherwise.</p>
     *
     * @param number The number to check for primality.
     * @return "yes" if the number is prime, "no" otherwise.
     */
    private static String getCorrectAnswer(int number) {
        return calculate(number) ? "yes" : "no";
    }

    /**
     * Determines whether a given number is prime.
     *
     * <p>This method checks if a number is prime using a loop that tests divisors
     * from 2 to the square root of the number.
     * A number is considered prime if it is greater than 1 and has no divisors other than 1 and itself.</p>
     *
     * @param number The number to check for primality.
     * @return {@code true} if the number is prime, {@code false} otherwise.
     */
    public static boolean calculate(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
