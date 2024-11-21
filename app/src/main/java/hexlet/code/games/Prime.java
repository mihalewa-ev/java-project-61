package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    private final Engine engine;
    private final Random random;
    private int score;

    public Prime(Engine engineObj) {
        this.engine = engineObj;
        this.random = new Random();
        this.score = 0;
    }

    /**
     * Запускает игру.
     * В этом методе игроку задаются вопросы о том, является ли случайное число простым.
     * Игрок должен ответить "yes", если число простое, и "no", если нет.
     * Игра продолжается, пока игрок не наберет 3 правильных ответа.
     */
    public void play() {
        engine.printRules("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (score < 3) {
            int number = random.nextInt(100) + 1;
            String correctAnswer = calculate(number) ? "yes" : "no";

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

    /**
     * Проверяет, является ли число простым.
     *
     * @param number число для проверки
     * @return true, если число простое, иначе false
     */
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
