package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private final Engine engine;
    private final Random random;
    private int score;

    public Even(Engine engine) {
        this.engine = engine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        engine.printRules("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (score < 3) {
            int number = random.nextInt(100) + 1;
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            System.out.println("Question: " + number);
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
}
