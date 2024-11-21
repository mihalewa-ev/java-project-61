package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private final Engine engine;
    private final Random random;
    private int score;

    public Progression(Engine engineObj) {
        this.engine = engineObj;
        this.random = new Random();
        this.score = 0;
    }

    /**
     * Запускает игру.
     * В этом методе игроку задаются вопросы о нахождении пропущенного числа в
     * арифметической прогрессии. Игрок должен правильно ответить на 3 вопроса, чтобы выиграть.
     * Игра продолжается, пока игрок не наберет 3 правильных ответа.
     * В процессе игры генерируется прогрессия с заданным первым элементом, шагом и
     * индексов, в котором пропущено число. Пользователь должен угадать это число.
     */
    public void play() {
        engine.printRules("What number is missing in the progression?");

        int winScore = 3;
        int oneStep = 1;
        while (score < winScore) {

            int firstElement = random.nextInt(20);
            int step = random.nextInt(10) + oneStep;
            int hiddenIndex = random.nextInt(10);
            int correctAnswer = 0;
            System.out.print("Question: ");
            for (int i = 0; i < 11; i++) {
                if(i != hiddenIndex) {
                    System.out.print(firstElement + i * step + " ");
                } else {
                    correctAnswer = firstElement + i * step;
                    System.out.print(".. ");
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
