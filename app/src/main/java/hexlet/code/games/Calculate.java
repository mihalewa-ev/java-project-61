package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculate {
    private final Engine engine;
    private final Random random;
    private int score;

    public Calculate(Engine engineObj) {
        this.engine = engineObj;
        this.random = new Random();
        this.score = 0;
    }

    /**
     * Запускает игру.
     * Этот метод должен быть переопределен в подклассах, если вы хотите изменить логику игры.
     * В противном случае, он обеспечивает стандартный процесс игры, включая
     * генерацию случайных чисел, выбор оператора и проверку ответов пользователя.
     */
    public void play() {
        engine.printRules("What is the result of the expression?");

        final int winScore = 3; // Константа для представления необходимого количества правильных ответов
        final int endOfRange = 100; // Константа, обозначающая верхний предел генерируемых чисел
        final int oneStep = 1; // Константа, обозначающая один шаг для округления числа
        while (score < winScore) {
            int num1 = random.nextInt(endOfRange) + oneStep;
            int num2 = random.nextInt(endOfRange) + oneStep;
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

    /**
     * Генерирует случайный оператор для математической операции.
     * @return случайный оператор ('+', '-', '*').
     */
    private char randomOperator() {
        char[] operators = {'+', '-', '*'};
        return operators[random.nextInt(operators.length)];
    }

    /**
     * Вычисляет результат математической операции.
     */
    private int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("No-know operator: " + operator);
        };
    }
}
