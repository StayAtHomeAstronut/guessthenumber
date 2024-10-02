import java.io.*;
import java.util.Random;
import java.util.Scanner;

// Class implementing the Guess the Number game, adhering to the IGuessGame interface
public class GuessTheNumber implements IGuessGame {
    private int numberToGuess; // The number that players need to guess
    private int maxAttempts;    // Maximum number of attempts allowed for guessing
    private Player player;      // The player participating in the game

    // Constructor to initialize the game with a player and set maximum attempts
    public GuessTheNumber(Player player) {
        this.maxAttempts = 5; // Limit the number of attempts to 5
        this.player = player;  // Set the current player
        generateRandomNumber(); // Generate a random number for the game
    }

    // Method to generate a random number between 1 and 100
    public void generateRandomNumber() {
        Random rand = new Random();
        this.numberToGuess = rand.nextInt(100) + 1; // Random number from 1 to 100
    }

    // Method to start the guessing game
    @Override
    public void startGame() {
        // Show player their lifetime wins before starting the game
        System.out.println("Loading game data...");
        int lifetimeWins = GameSaveManager.loadPlayerWins(player.getName());
        
        // Welcome the player and display lifetime wins if available
        if (lifetimeWins > 0) {
            System.out.println("Welcome back, " + player.getName() + "! You have " + lifetimeWins + " lifetime wins.");
            player.setScore(lifetimeWins); // Set the player's score to their lifetime wins
        } else {
            System.out.println("Welcome to the Guess the Number Game, " + player.getName() + "!");
        }

        // Begin the game loop for user guesses
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in); // Create a scanner to read user input
            System.out.println("Guess a number between 1 and 100.");

            // Loop through the allowed attempts
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": ");
                int guess = scanner.nextInt(); // Read the user's guess

                // Check if the guessed number is correct
                if (guess == numberToGuess) {
                    System.out.println("Congratulations, " + player.getName() + "! You guessed the correct number.");
                    player.incrementScore(); // Increment score only if they win
                    break; // Exit the loop if the guess is correct
                } else if (guess < numberToGuess) {
                    System.out.println("The number is higher."); // Hint for the player
                } else {
                    System.out.println("The number is lower."); // Hint for the player
                }

                // Check if the player has used all their attempts
                if (attempt == maxAttempts) {
                    System.out.println("You've run out of attempts! The correct number was: " + numberToGuess);
                }
            }

            // Save the game data if the game session ends
            saveGameData();
        } finally {
            // Ensure the scanner is closed to avoid resource leaks
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Method to save game data if the player has won
    public void saveGameData() {
        // Save the player's game data
        GameSaveManager.saveGame(player);
    }

    // Main method to start the application
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in); // Create a scanner for reading player input
            System.out.println("Enter your player name: ");
            String name = scanner.nextLine(); // Read the player's name

            // Create a new AdvancedPlayer (using inheritance)
            Player player = new AdvancedPlayer(name);
            // Initialize the game with the player
            GuessTheNumber game = new GuessTheNumber(player);
            // Start the game
            game.startGame();
        } finally {
            // Close the scanner to free resources
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}