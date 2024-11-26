### Hexlet tests and linter status:
[![Actions Status](https://github.com/mihalewa-ev/java-project-61/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/mihalewa-ev/java-project-61/actions)

<<<<<<< HEAD

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
=======
<a href="https://codeclimate.com/github/mihalewa-ev/java-project-61/maintainability"><img src="https://api.codeclimate.com/v1/badges/ed0170979b400b34eac7/maintainability" /></a>

[![asciicast]({[ссылка](https://asciinema.org/connect/ded0e8e1-cc04-41eb-851b-16c54396548a)}.svg)]({[ссылка](https://asciinema.org/connect/ded0e8e1-cc04-41eb-851b-16c54396548a)})  
Скринкаст 5-го шага обучения:
https://asciinema.org/connect/ded0e8e1-cc04-41eb-851b-16c54396548a

Скринкаст 6-го шага обучения:
https://asciinema.org/a/ehSnJ2NNZhSgk58JPQFsDr6Zb

Скринкаст 7-го шага обучения:
https://asciinema.org/a/595VLcpx6gBJWvGLByBspA4Dt

Скринкаст 8-го шага обучения:
https://asciinema.org/a/je0k3Q05JbMEJ2nvGYzH8i6y0

Скринкаст 9-го шага обучения:
https://asciinema.org/a/Yi5P5ZswaHLBwjUHdHR7ibMfa
>>>>>>> be9a70eba4740bf488d589638384a2989c981d77
