
import java.util.Scanner;
import java.util.Random;

class GuessingGame {
    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;

    GuessingGame() {
        Random rand = new Random();
        number = rand.nextInt(100);
    }

    void takeUserInput() {
        System.out.println("Please Guess the Number");
        Scanner sc = new Scanner(System.in);
        ;
        inputNumber = sc.nextInt();
    }

    boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == number) {
            System.out.format("Congratulation! You Guess the right number %d\nYou Guessed it in %d attempt", number,
                    noOfGuesses);
            return true;
        } else if (inputNumber < number) {
            System.out.println("Entered Number Too low...");
        } else if (inputNumber > number) {
            System.out.println(" Entered Number Too High...");
        }
        return false;
    }
}

public class GuessNumber {
    public static void main(String[] args) {

        GuessingGame g = new GuessingGame();
        boolean b = false;
        System.out.println("\n==================================");
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("==================================\n");
        while (!b) {
            g.takeUserInput();
            b = g.isCorrectNumber();
        }
    }
}