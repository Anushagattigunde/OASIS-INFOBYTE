package labprograms;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;
        
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                score += (maxAttempts - attempts + 1); // Assign score based on attempts.
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts.");
            } else {
                System.out.println("Remaining attempts: " + (maxAttempts - attempts));
            }
        }
        
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}

