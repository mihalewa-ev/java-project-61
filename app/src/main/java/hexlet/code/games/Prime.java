package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    private final Engine engine;
    private final Random random;
    private int score;

    public Prime(Engine engine) {
        this.engine = engine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        engine.printRules("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (score < 3) {
            int number = random.nextInt(100) + 1;
            String correctAnswer = calculate(number) ? "yes" : "no";

            System.out.println("Question " + number);
            String userAnswer = engine.getUserInput();

            if (engine.isAnswerCorrect(userAnswer, correctAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                engine.printLoseMessage(userAnswer, correctAnswer);
                return;
            }
        }

        engine.printWinMessage();
    }

    private boolean calculate(int number) {
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