package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private final Engine engine;
    private final Random random;
    private int score;

    public Progression(Engine engine) {
        this.engine = engine;
        this.random = new Random();
        this.score = 0;
    }

    public void play() {
        engine.printRules("What number is missing in the progression?");

        while (score < 3) {

            int firstElement = random.nextInt(20);
            int step = random.nextInt(10) + 1;
            int hiddenIndex = random.nextInt(10);
            int correctAnswer = 0;
            for (int i = 0; i < 11; i++) {
                if(i != hiddenIndex) {
                    System.out.print(firstElement + i * step + " ");
                } else {
                    correctAnswer = firstElement + i * step;
                    System.out.print("... ");
                }
            }

            System.out.print("\nYour answer: ");

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
}
