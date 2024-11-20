package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Gcd {
    private final Engine engine;
    private final Random random;
    private int score;

    public Gcd(Engine engine) {
        this.engine = engine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        engine.printRules("Find the greatest common divisor of given numbers.");

        while (score < 3) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;

            int correctAnswer = calculate(num1, num2);
            System.out.println(num1 + " and " + num2);

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

    private int calculate(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
