import java.io.*;

// Class responsible for managing game save operations
public class GameSaveManager {

    // Load the player's saved wins from a file, if it exists
    public static int loadPlayerWins(String playerName) {
        int wins = 0; // Default wins for new players
        
        // Create a file object based on the player's name
        File file = new File(playerName + "_game.txt");
        
        // Check if the file exists before attempting to read from it
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                
                // Read lines from the file until we find the wins
                while ((line = reader.readLine()) != null) {
                    // Check for the line that contains the wins
                    if (line.startsWith("Wins: ")) {
                        // Parse the number of wins from the line
                        wins = Integer.parseInt(line.split(": ")[1]);
                        break; // Exit the loop once we've found the wins
                    }
                }
            } catch (IOException e) {
                // Handle potential IOExceptions while reading the file
                System.out.println("Error loading game data.");
                e.printStackTrace(); // Print stack trace for debugging
            }
        } else {
            // Inform the player they are a new player if the file does not exist
            System.out.println("Welcome, new player!");
        }
        return wins; // Return the number of wins loaded (or default if new player)
    }

    // Save the player's data (name and updated wins) to a file
    public static void saveGame(Player player) {
        // Attempt to write the player's data to their corresponding file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(player.getName() + "_game.txt"))) {
            writer.write("Player: " + player.getName()); // Write player name
            writer.newLine(); // Insert a new line in the file
            writer.write("Wins: " + player.getScore()); // Write the number of wins
            writer.newLine(); // Insert a new line after wins
            System.out.println("Game saved successfully."); // Confirmation message
        } catch (IOException e) {
            // Handle potential IOExceptions while writing to the file
            System.out.println("Error saving game data.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}