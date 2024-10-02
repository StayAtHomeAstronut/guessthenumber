# Overview

This Java program is a number-guessing game where the computer generates a random number, and the player has to guess it within a limited number of attempts. The program can read save data from a file and allows the player to continue a saved game if they have played before, or start a new game.

At the end of the game session, the player's progress is saved to a text file which can be used to load a save the next time they play.

The game features:
- Random number generation.
- File read/write functionality for saving and loading game data.
- Limited attempts to guess the number.
- Demonstrates Java features: Variables, Conditionals, Loops, Functions, Classes, Inheritance, Interfaces, and Java Collection Framework.

The software contains four files: 
- GuessTheNumber: Containing the game and random number generation features
- GameSaveManager: A class containing logic to save and load the game
- Player: A class containing storing player information
- IGuessGame: An interface which provides structure that defines essential methods

I wrote this software to become more familiar with the Java coding language. This will allow me to write functional programs in Java in the future.

[Guess the Number Demo](https://youtu.be/w1PzEXKnCpw)

# Development Environment

To develop this software, I used VS Code coding environment. I had to install Java from Oracle and download additional modules onto VS Code in order to compile and run my Java program.

This program was run in Java, using the Java.IO library for read/write funcitonality, the java.util.random library for random number generation, and the java.util.scanner library for functionality needed to read and parse information from certain sources like a text file.

# Useful Websites

{Make a list of websites that you found helpful in this project}

- [Oracle Java SE Documentation](https://docs.oracle.com/javase/8/docs/api/)
- [Stack Overflow](https://stackoverflow.com/)

# Future Work

- Create an Easy, Medium, and Hard mode so that players can choose how many attempts they have to guess the number.
- Prompt the user to play again after they have played a round, rather than restarting the program.
- Create a user interface so the game can be played on a seperate window instead of in the console.
