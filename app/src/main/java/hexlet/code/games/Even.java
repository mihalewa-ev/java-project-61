package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private final Engine engine;
    private final Random random;
    private int score;

    public Even(Engine engineObj) {
        this.engine = engineObj;
        this.random = new Random();
        this.score = 0;
    }

    /**
     * Запускает игру.
     * В этом методе игроку задаются вопросы о том, является ли случайное число четным.
     * Игрок должен ответить "yes", если число четное, и "no", если число нечетное.
     * Игра продолжается, пока игрок не наберет 3 правильных ответа.
     */
    public void play() {
        engine.printRules("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int winScore = 3;
        int oneStep = 1;
        while (score < winScore) {
            int number = random.nextInt(100) + oneStep;
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
