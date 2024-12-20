package hexlet.code.games;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Arrays;
import hexlet.code.Engine;

public class Progression {
    public static final String GAME_RULE = "What number is missing in the progression?";
    private static final Random RANDOM = new Random();

    /**
     * Starts the "Progression" game by preparing game data and passing it to the game engine.
     *
     * <p>This method generates questions and correct answers for the game. In this game,
     * the player identifies the missing number in a mathematical progression. It uses
     * {@link #getArResult()} to prepare game data {@link Engine#play(String, String[][])} method.</p>
     */
    public static void startGameProgression() {
        String[][] arResult = getArResult();
        Engine.play(GAME_RULE, arResult);
    }

    /**
     * Generates a 2D array of questions and correct answers for the "Progression" game.
     *
     * <p>This method creates a random arithmetic progression with one missing element,
     * generates the corresponding question, and calculates the correct answer.</p>
     *
     * @return A 2D array where:
     *         <ul>
     *             <li>Column 0: The progression question with one missing number.</li>
     *             <li>Column 1: The correct answer for the missing number.</li>
     *         </ul>
     */
    private static String[][] getArResult() {
        int winScore = Engine.getWinValue();
        final int maxDifferenceBetweenNumber = 10; // max difference between two closer number
        final int columns = 2; // count of variable answer (right or wrong)
        final int endOfRange = 100; // higher number range to 100
        final int oneStep = 1; // integer for add number to 100
        final int arraySize = 10; // size of array
        String[][] arResult = new String[winScore][columns];

        for (int i = 0; i < winScore; i++) {
            int number = RANDOM.nextInt(endOfRange) + oneStep;
            int progressionStep = RANDOM.nextInt(maxDifferenceBetweenNumber) + oneStep;
            int[] progression = getProgression(number, progressionStep, arraySize);
            int hiddenIndex = RANDOM.nextInt(arraySize);
            String question = getQuestion(progression, hiddenIndex);
            int correctAnswer = getData(hiddenIndex, progression);
            arResult[i][0] = question;
            arResult[i][1] = String.valueOf(correctAnswer);
        }
        return arResult;
    }

    /**
     * Retrieves the missing number from the progression.
     *
     * @param hiddenIndex The index of the missing number.
     * @param progression The progression array.
     * @return The missing number from the progression.
     */
    private static int getData(int hiddenIndex, int[] progression) {
        if (progression.length > 0) {
            return (int) Array.get(progression, hiddenIndex);
        }
        return 0;
    }

    /**
     * Generates a progression question with a missing number replaced by '.'.
     *
     * @param hiddenIndex The index of the missing number.
     * @param progression The progression array.
     * @return A string representation of the progression with the missing number replaced by ".".
     */
    static String getQuestion(int[] progression, int hiddenIndex) {

        String[] stringProgression = Arrays.stream(progression)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        stringProgression[hiddenIndex] = "..";

        return String.join(" ", stringProgression);
    }

    /**
     * Generates an arithmetic progression.
     *
     * @param number The starting number of the progression.
     * @param progressionStep The step of the progression.
     * @param arraySize The length of the progression.
     * @return An array representing the arithmetic progression.
     */
    private static int[] getProgression(int number, int progressionStep, int arraySize) {
        int[] result = new int[arraySize];
        for (int i = 0; i < result.length; i++) {
            number = number + progressionStep;
            result[i] = number;
        }
        return result;
    }
}
