package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final int winScore = 3; // scores needs to win
    private static final Scanner scanner = new Scanner(System.in);

    public static int getWinValue() {
        return winScore;
    }

    /**
     * Gets the username and stores it.
     * Prompts the user for their name and greets them.
     */
    public static String getUserName() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = inputScanner.next();
        System.out.println("Hello, " + userName);

        return userName;
    }

    /**
     * Displays the game rules.
     * First prompts for the username, then displays the provided game rules.
     *
     * @param gameRules the game rules to display.
     */
    public static void printRules(String gameRules) {
        System.out.println(gameRules);
    }

    /**
     * Displays a message about the win.
     * Congratulates the user on the win, using their name.
     */
    public static void printWinMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    /**
     * Displays a defeat message.
     * Informs the user of an incorrect answer and provides the correct answer.
     *
     * @param userReply the answer entered by the user.
     * @param correctAnswer the correct answer to display.
     */
    public static void printLoseMessage(String userReply, String correctAnswer, String userName) {
        System.out.println(userReply + " is wrong answer ;( Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + userName + "!");
    }

    /**
     * Starts a game where the user is asked questions and the answer is checked.
     *
     * <p>This method performs the sequence of steps for the game:</p>
     * <ul>
     * <li>Get the username.</li>
     * <li>Print the game rules.</li>
     * <li>A loop where questions are asked and answers are checked.</li>
     * <li>If the user answers correctly, their score is increased.</li>
     * <li>If the answer is incorrect, the game ends and a message is displayed about the loss.</li>
     * <li>If the user has collected enough points, the game ends with a win.</li>
     * </ul>
     *
     * @param gameRules a string containing a description of the game rules that will be displayed before the game starts.
     */
    public static void play(String gameRules, String[][] arResult) {
        String userName = getUserName();
        printRules(gameRules);

        int score = 0; // user's starting points

        for (; score < getWinValue(); score++) {

            String question = arResult[score][0];
            String correctAnswer = arResult[score][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userReply = scanner.next();

            if (userReply.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                printLoseMessage(userReply, correctAnswer, userName);
                return;
            }
        }

        printWinMessage(userName);
    }
}
