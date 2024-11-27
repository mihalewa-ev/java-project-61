package hexlet.code.games;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.StringJoiner;
import hexlet.code.Engine;

public class Progression {
    public static final String GAME_RULE = "What number is missing in the progression?";
    private static final Random RANDOM = new Random();
    public static int maxDifferenceBetweenNumber = 10;
    public static int WinScore = Engine.getWinValue();

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
        int columns = 2; // count of variable answer (right or wrong)
        int endOfRange = 100; // integer, higher number range
        int oneStep = 1; // integer for add number to 100
        int arraySize = 10; // size of array
        String[][] arResult = new String[WinScore][columns];

        for (int i = 0; i < WinScore; i++) {
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
        var joiner = new StringJoiner(" ");

        for (var i = 0; i < progression.length; i += 1) {
            var element = i == hiddenIndex ? ".." : Integer.toString(progression[i]);
            joiner.add(element);
        }

        return joiner.toString();
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
