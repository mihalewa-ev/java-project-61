package hexlet.code;

import java.util.Scanner;

public class Engine {
    private final Scanner scanner = new Scanner(System.in);
    private String userName;

    public final void getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        this.userName = scanner.next();
        System.out.println("Hello, " + userName);
    }

    // Метод для вывода правил игры
    public void printRules(String gameRules) {
        getUserName();
        System.out.println(gameRules);
    }

    // Метод для получения ввода пользователя
    public String getUserInput() {
        return scanner.next();
    }

    // Метод для анализа правильности ответа
    public boolean isAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    // Метод для вывода поздравления
    public void printWinMessage() {
        System.out.println("Congratulations, " + userName + "!");
    }

    // Метод для вывода сообщения о поражении
    public void printLoseMessage(String userAnswer, String correctAnswer) {
        System.out.println(userAnswer + " is wrong answer ;( Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + userName + "!");
    }
}
