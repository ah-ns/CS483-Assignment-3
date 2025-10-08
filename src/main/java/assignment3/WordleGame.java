/**
 * Purpose: Handle the creation and states of the game
 * 
 * @author Hans van Lierop, Christopher Saia
 * @version 1
 */

package assignment3;

import java.time.LocalTime;

public class WordleGame {
	
	private String secret;
	private String guess;
	private int guesses;
	private Feedback feedback;
	private Dictionary dict;
	private String lastPattern;
	
	public WordleGame() {
		this.secret = "apple";
		this.feedback = new Feedback();
		this.dict = new Dictionary();
	}
	
	/**
	 * Initializes variables that are needed for the game.
	 */
	public void startGame() {
		this.secret = dict.getRandomWord().toLowerCase();
		this.guesses = 6;
		this.guess = null;
        this.lastPattern = null;
	}
	
	/**
	 * Check and fetch the pattern of the player's guess.
	 * @param guess The player's guess
	 */
	public void makeGuess(String guess) {
		if (guess == null) {
			System.out.println("Guess cannot be null");
		}
		
        guess = guess.trim();
        
        //check if word is valid
        if (!dict.isValidWord(guess)) {
			System.out.println("Guess does not follow the requirements");
			this.guesses--;
			return;
        }
       
        this.guess = guess;
        if (!this.feedback.isCorrect(this.secret, this.guess))
        	this.lastPattern = feedback.getPattern(secret, guess);
        this.guesses--;
	}
	
	/**
	 * Checks if the game should be ended.
	 * @return true if the game is over, else otherwise
	 */
	public boolean isGameOver() {
		if (this.guesses > 0 && !this.feedback.isCorrect(this.secret, this.guess))
			return false;
		else
			return true;
	}
	
	/**
	 * Gets the secret word for testing purposes
	 * @param word The player's input
	 * @return The secret word
	 */
	public String getSecretWord(String word) {
		if (word.equals("ans"))
			return this.secret;
		else
			return "";
	}

	/**
	 * Gets if the player's guess was correct
	 * @return true if the guess is correct, else otherwise
	 */
	public boolean lastGuessCorrect() {
        return (guess != null) && feedback.isCorrect(secret, guess);
    }
	
	/**
	 * Returns the amount of guesses
	 * @return The number of guesses
	 */
    public int getRemainingGuesses() {
        return this.guesses;
    }
    
    /**
     * Returns the pattern of the last guess
     * @return The pattern of the last guess
     */
    public String getLastPattern() {
    	return this.lastPattern;
    }
	
	public static void main(String[] args) {
	    WordleGame game = new WordleGame();
	    game.startGame();
	    java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.println("Hello, Welcome to buggy wordle by Chris and Hans");
		System.out.println("Current time: " + LocalTime.now());
		// While the game shouldn't be finished
	    while (!game.isGameOver()) {
	        System.out.println("Enter your guess:" + game.getRemainingGuesses() + " left");
	        String input = scanner.nextLine();
	        
	        if (!game.getSecretWord(input).equals(""))
	        	System.out.println(game.getSecretWord(input));
	        // handle the guess
	        game.makeGuess(input);
	        System.out.println("Feedback: " + game.getLastPattern());

	        if (game.lastGuessCorrect()) {
	        	System.out.println("Correct! You won");
	        	break;
	        }
	    }

	    if (game.isGameOver()) {
	        System.out.println("\n Out of guesses! The word was: " + game.getSecretWord("ans"));
	    }
	    scanner.close();
	}
}
