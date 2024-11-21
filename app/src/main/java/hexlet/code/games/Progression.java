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

        final int winScore = 3; // Константа для представления необходимого количества правильных ответов
        final int rangeOfFirstElement = 20; // Константа, обозначающая предел для первого элемента прогрессии
        final int maxDifferenceBetweenNumber = 10; // Константа, обозначающая максильманую разницу между двумя числами
        final int oneStep = 1; // Константа, обозначающая один шаг для округления числа
        final int maxHiddenIndex = 10; // Константа, ограничивающая появление скрытого элемента длиной прогрессии
        final int endOfProgression = 11; // Обозначение максимальной длины прогрессии
        while (score < winScore) {

            int firstElement = random.nextInt(rangeOfFirstElement);
            int step = random.nextInt(maxDifferenceBetweenNumber) + oneStep;
            int hiddenIndex = random.nextInt(maxHiddenIndex);
            int correctAnswer = 0;

            System.out.print("Question: ");
            for (int i = 0; i < endOfProgression; i++) {
                if (i != hiddenIndex) {
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
