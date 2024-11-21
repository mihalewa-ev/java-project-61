package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculate {
    private final Engine engine;
    private final Random random;
    private int score;

    public Calculate(Engine engine) {
        this.engine = engine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        engine.printRules("What is the result of the expression?");

        while (score < 3) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
            char operator = randomOperator();

            int correctAnswer = calculate(num1, num2, operator);
            System.out.println("Question: " + num1 + " " + operator + " " + num2);

            String userAnswer = engine.getUserInput();
            if (engine.isAnswerCorrect(userAnswer, String.valueOf(correctAnswer))) {
                score++;
                System.out.println("Correct!");
            } else {
                engine.printLoseMessage(userAnswer, String.valueOf(correctAnswer));
                return;
            }
        }
        engine.printWinMessage();
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
