### Hexlet tests and linter status:
[![Actions Status](https://github.com/mihalewa-ev/java-project-61/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/mihalewa-ev/java-project-61/actions)


package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void game() {
        Cli.dialog();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Scanner scanner = new Scanner(System.in);
        int scores = 0;
        boolean gameActive = true;

        while (gameActive) {
            int randomNum = (int) (Math.random() * 100) + 1;
            System.out.println("Question: " + randomNum);

            boolean isEven = randomNum % 2 == 0;
            String correctAnswer = isEven ? "да" : "нет"; // Правильный ответ

            String userAnswer = scanner.next().trim().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                scores++;
                System.out.println("Correct!");

                // Проверка, достиг ли пользователь 3 правильных ответов подряд
                if (scores == 3) {
                    System.out.println("Congratulations!");
                    gameActive = false;
                }
            } else {
                System.out.println("Wrong answer ;(");
                gameActive = false; // Завершаем игру при ошибке
            }
        }
        scanner.close();
    }
}
