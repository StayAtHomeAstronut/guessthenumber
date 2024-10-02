// Abstract class representing a generic player in the game
public abstract class Player {
    private String name; // Player's name
    private int score; // Player's score, initialized to 0

    // Constructor to initialize the player with a name and a score of 0
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Getter method for the player's name
    public String getName() {
        return name;
    }

    // Getter method for the player's score
    public int getScore() {
        return score;
    }

    // Method to increment the player's score by 1
    public void incrementScore() {
        this.score++;
    }

    // Setter method to set the player's score, useful when loading from a save file
    public void setScore(int score) {
        this.score = score;
    }

    // Abstract method to display the type of player; must be implemented by subclasses
    public abstract void displayPlayerType();
}

// Concrete class representing an advanced player, extending the Player class
class AdvancedPlayer extends Player {

    // Constructor to initialize the advanced player with a name
    public AdvancedPlayer(String name) {
        super(name); // Call the parent constructor to set the name
    }

    // Implementation of the abstract method to display player type
    @Override
    public void displayPlayerType() {
        System.out.println("This is an advanced player."); // Message indicating player type
    }
}