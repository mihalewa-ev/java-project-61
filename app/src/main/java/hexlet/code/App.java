package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculate;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) throws java.io.IOException {
        char choice;
            do {
                System.out.println("Welcome to the Brain Games!");
                System.out.println("Please enter the game number and press Enter");
                System.out.println("1 - Greet");
                System.out.println("2 - Even");
                System.out.println("3 - Calculate");
                System.out.println("4 - GCD");
                System.out.println("5 - Progression");
                System.out.println("6 - Prime");
                System.out.println("0 - Exit");
                choice = (char) System.in.read();
            } while (choice < 2);

            Engine engine = new Engine();
            switch (choice) {
                case '0':
                    System.out.println("See you later!");
                    break;
                case '1':
                    System.out.println("Your choice is Greet!");
                    Cli.dialog();
                    break;
                case '2':
                    System.out.println("Your choice is Even!");
                    Even evenGame = new Even(engine);
                    evenGame.play();
                    break;
                case '3':
                    System.out.println("Your choice is Calculate!");
                    Calculate calculate = new Calculate(engine);
                    calculate.play();
                    break;
                case '4':
                    System.out.println("Your choice is GCD!");
                    Gcd gcd = new Gcd(engine);
                    gcd.play();
                    break;
                case '5':
                    System.out.println("Your choice is Progression!");
                    Progression progression = new Progression(engine);
                    progression.play();
                    break;
                case '6':
                    System.out.println("Your choice is Prime!");
                    Prime prime = new Prime(engine);
                    prime.play();
                    break;
                default:
                    System.out.print("Wrong choose. Try again");
                    break;
            }
    }
}


