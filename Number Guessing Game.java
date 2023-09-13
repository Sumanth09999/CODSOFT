import java.util.Scanner;
import java.util.Random;

public class EnhancedNumberGuessingGame {
 public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int minRange = 1;
int maxRange = 100;
int maxAttempts = 10;
int score = 0;

 System.out.println("Welcome to the  Number Guessing Game!");
 while (true) {
 // Ask the player to choose a difficulty level
 System.out.println("Choose a difficulty level:");
 System.out.println("1. Easy (1-50)");
 System.out.println("2. Medium (1-100)");
 System.out.println("3. Hard (1-200)");
 System.out.print("Enter the level number: ");
 int levelChoice = scanner.nextInt();

 // Adjust the range based on the chosen difficulty level
 switch (levelChoice) {
 case 1:
 maxRange = 50;
 maxAttempts = 5;
 break;
 case 2:
 maxRange = 100;
 maxAttempts = 10;
 break;
 case 3:
 maxRange = 200;
 maxAttempts = 15;
 break;
 default:
 System.out.println("Invalid choice. Defaulting to Medium.");
 maxRange = 100;
 maxAttempts = 10;
 }

 int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
 int attempts = 0;

 System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts to guess it.");

 while (attempts < maxAttempts) {
 System.out.print("Enter your guess: ");
 int userGuess = scanner.nextInt();
 attempts++;

 if (userGuess == generatedNumber) {
 System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
 score++;
 break;
 } else if (userGuess < generatedNumber) {
 System.out.println("Too low. Try again.");
 } else {
 System.out.println("Too high. Try again.");
 }

 if (attempts == maxAttempts) {
 System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + generatedNumber);
 }
 }

 System.out.print("Do you want to play again? (yes/no): ");
 String playAgain = scanner.next();

 if (!playAgain.equalsIgnoreCase("yes")) {
 System.out.println("Thanks for playing! Your final score is: " + score);
 break;
 }
 }

 scanner.close();
 }
}