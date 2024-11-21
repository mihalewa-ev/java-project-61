package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Gcd {
    private final Engine engine;
    private final Random random;
    private int score;

    public Gcd(Engine engineObj) {
        this.engine = engineObj;
        this.random = new Random();
        this.score = 0;
    }

    /**
     * Запускает игру.
     * В этом методе игроку задаются вопросы о нахождении наибольшего общего делителя
     * двух случайных чисел. Игрок должен правильно ответить на 3 вопроса, чтобы выиграть.
     * Игра продолжается, пока игрок не наберет 3 правильных ответа.
     */
    public void play() {
        engine.printRules("Find the greatest common divisor of given numbers.");

        final int winScore = 3; // Константа для представления необходимого количества правильных ответов
        final int endOfRange = 100; // Константа, обозначающая верхний предел генерируемых чисел
        final int oneStep = 1; // Константа, обозначающая один шаг для округления числа
        while (score < winScore) {
            int num1 = random.nextInt(endOfRange) + oneStep;
            int num2 = random.nextInt(endOfRange) + oneStep;

            int correctAnswer = calculate(num1, num2);
            System.out.println("Question: " + num1 + " " + num2);

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

    /**
     * Вычисляет наибольший общий делитель (НОД) двух чисел с использованием алгоритма Евклида.
     *
     * @param num1 первое число
     * @param num2 второе число
     * @return наибольший общий делитель двух чисел
     */
    private int calculate(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
