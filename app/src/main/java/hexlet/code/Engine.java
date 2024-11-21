package hexlet.code;

import java.util.Scanner;

public class Engine {
    private final Scanner scanner = new Scanner(System.in);
    private String userName;

    /**
     * Получает имя пользователя и сохраняет его.
     * Запрашивает у пользователя ввод имени и приветствует его.
     */
    public void getUserName() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        this.userName = inputScanner.next();
        System.out.println("Hello, " + userName);
    }

    /**
     * Выводит правила игры.
     * Сначала запрашивает имя пользователя, а затем выводит предоставленные правила игры.
     *
     * @param gameRules правила игры, которые будут выведены на экран.
     */
    public void printRules(String gameRules) {
        getUserName();
        System.out.println(gameRules);
    }

    /**
     * Получает ввод пользователя.
     * Подклассы должны переопределить этот метод,
     * чтобы предоставить свою собственную реализацию получения данных от пользователя.
     *
     * @return ввод пользователя в виде строки.
     */
    public String getUserInput() {
        return scanner.next();
    }

    /**
     * Проверяет правильность ответа пользователя.
     * Сравнивает введенный пользователем ответ с корректным ответом,
     * игнорируя регистры символов.
     *
     * @param userAnswer ответ, введенный пользователем.
     * @param correctAnswer правильный ответ для сравнения.
     * @return true, если ответ пользователя правильный, иначе false.
     */
    public boolean isAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    /**
     * Выводит сообщение о победе.
     * Поздравляет пользователя с победой, используя его имя.
     */
    public void printWinMessage() {
        System.out.println("Congratulations, " + userName + "!");
    }

    /**
     * Выводит сообщение о поражении.
     * Информирует пользователя о неверном ответе и предоставляет правильный ответ.
     *
     * @param userAnswer ответ, введенный пользователем.
     * @param correctAnswer правильный ответ, который необходимо показать.
     */
    public void printLoseMessage(String userAnswer, String correctAnswer) {
        System.out.println(userAnswer + " is wrong answer ;( Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + userName + "!");
    }
}
