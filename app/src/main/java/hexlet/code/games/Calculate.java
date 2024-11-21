package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculate {
    private final Engine gameEngine;
    private final Random random;
    private int score;

    public Calculate(Engine gameEngine) {
        this.gameEngine = gameEngine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        gameEngine.printRules("What is the result of the expression?");

        while (score < 3) {
            int num1 = random.nextInt(100) + 1; // Генерация числа от 1 до 50
            int num2 = random.nextInt(100) + 1;
            char operator = randomOperator();

            int correctAnswer = calculate(num1, num2, operator);
            System.out.println("Question: " + num1 + " " + operator + " " + num2);

            String userAnswer = gameEngine.getUserInput();
            if (gameEngine.isAnswerCorrect(userAnswer, String.valueOf(correctAnswer))) {
                score++;
                System.out.println("Correct!");
            } else {
                gameEngine.printLoseMessage(userAnswer, String.valueOf(correctAnswer));
                return;
            }
        }
        gameEngine.printWinMessage();
    }

    private char randomOperator() {
        char[] operators = {'+', '-', '*'};
        return operators[random.nextInt(operators.length)];
    }

    private int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("No-know operator: " + operator);
        };
    }
}
