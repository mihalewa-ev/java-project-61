package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculate {
    public static final String GAME_RULE = "What is the result of the expression?";
    private static final Random RANDOM = new Random();

    /**
     * Starts the "Calculate" game by preparing the game data and passing it to the game engine.
     *
     * <p>This method generates questions and correct answers for a math-based game where the player
     * calculates the result of random arithmetic expressions. It uses the {@link #getArResult()} method
     * to prepare the game data and then invokes the {@link Engine#play(String, String[][])} method to run the game.</p>
     */
    public static void startGameCalculate() {
        String[][] arResult = getArResult();
        Engine.play(GAME_RULE, arResult);
    }

    /**
     * Generates a 2D array of questions and correct answers for the "Calculate" game.
     *
     * <p>This method creates random arithmetic expressions using two operands and a random operator
     * ('+', '-', or '*') and calculates their results. Each question and its corresponding correct answer
     * are stored in a 2D array.</p>
     *
     * @return A 2D array containing:
     *         <ul>
     *             <li>Column 0: The question (e.g., "5 + 3").</li>
     *             <li>Column 1: The correct answer (e.g., "8").</li>
     *         </ul>
     */
    private static String[][] getArResult() {

        int columns = 2; // count of variable answer (right or wrong)
        int endOfRange = 100; // integer, higher number range
        int oneStep = 1; // integer for add number to 100
        int WinScore = Engine.getWinValue();
        String[][] arResult = new String[WinScore][columns];

        for (int i = 0; i < WinScore; i++) {
            Random random = new Random();
            int num1 = random.nextInt(endOfRange) + oneStep;
            int num2 = random.nextInt(endOfRange) + oneStep;
            String operator = randomMathOperator();
            String question = num1 + " " + operator + " " + num2;
            String correctAnswer = String.valueOf(calculate(num1, num2, operator));
            arResult[i][0] = question;
            arResult[i][1] = correctAnswer;
        }
        return arResult;
    }

    /**
     * Performs a calculation based on the given operator and two operands.
     *
     * @param num1    the first operand
     * @param num2    the second operand
     * @param operator the mathematical operator as a String ("+", "-", or "*")
     * @return the result of the operation
     * @throws IllegalArgumentException if the operator is not one of "+", "-", or "*"
     */
    public static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("No-know operator: " + operator);
        };
    }

    /**
     * Generates a random mathematical operator as a String.
     *
     * @return a randomly selected operator ("+", "-", or "*")
     */
    public static String randomMathOperator() {
        String[] operators = {"+", "-", "*"};
        return operators[RANDOM.nextInt(operators.length)];
    }
}
