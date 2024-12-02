package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final int WIN_SCORE = 3; // scores needs to win
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getWinValue() {
        return WIN_SCORE;
    }

    /**
     * Gets the username and stores it.
     * Prompts the user for their name and greets them.
     * @return means a user's name
     * @param gameRules the game rules to display.
     */
    public static String greetingUser(String gameRules) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = inputScanner.next();
        System.out.println("Hello, " + userName);
        System.out.println(gameRules);

        return userName;
    }

    /**
     * Displays a message about the win.
     * Congratulates the user on the win, using their name.
     * @param userName the user's name to display.
     */
    public static void printFinalMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    /**
     * Displays a defeat message.
     * Informs the user of an incorrect answer and provides the correct answer.
     *
     * @param userReply the answer entered by the user.
     * @param correctAnswer the correct answer to display.
     * @param userName the user's name to display.
     */
    public static void printFinalMessage(String userReply, String correctAnswer, String userName) {
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
     * @param gameRules a string containing a description of the game rules.
     * @param arResult an array of result method.
     */
    public static void play(String gameRules, String[][] arResult) {
        String userName = greetingUser(gameRules);

        int score = 0; // user's starting points

        for (; score < getWinValue(); score++) {

            String question = arResult[score][0];
            String correctAnswer = arResult[score][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userReply = SCANNER.next();

            if (userReply.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                printFinalMessage(userReply, correctAnswer, userName);
                return;
            }
        }

        printFinalMessage(userName);
    }
}
