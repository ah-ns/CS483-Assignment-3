package assignment3;

public class WordleGame {
	
	private String secret;
	private String guess;
	private int guesses;
	private Feedback feedback;
	private Dictionary dict;
	private String lastPattern;
	
	public WordleGame() {
		this.secret = "apple";
		this.guesses = 6;
		this.feedback = new Feedback();
		this.dict = new Dictionary();
	}
	
	public void startGame() {
		this.secret = dict.getRandomWord().toLowerCase();
		this.guesses = 6;
		this.guess = null;
        this.lastPattern = null;
		
	}
	
	public void makeGuess(String guess) {
		if (guess == null) {
			System.out.println("Guess cannot be null");
		}
		
        guess = guess.trim().toLowerCase();
        
        //check if word is valid
        if (!dict.isValidWord(guess)) {
			System.out.println("Guess does not follow the requirements");
			return;
        }
       
      
        this.guess = guess;
        this.lastPattern = feedback.getPattern(secret, guess);
        this.guesses--;
	}
	
	public boolean isGameOver() {
		if (this.guesses > 0 && !this.feedback.isCorrect(this.secret, this.guess))
			return false;
		else
			return true;
	}
	
	public String getSecretWord() {
		return this.secret;
	}

	public boolean lastGuessCorrect() {
        return (guess != null) && feedback.isCorrect(secret, guess);
    }
	
    public int getRemainingGuesses() {
        return this.guesses;
    }
    
    public String getLastPattern() {
    	return this.lastPattern;
    }
	
	public static void main(String[] args) {
	    WordleGame game = new WordleGame();
	    java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.println("Hello, Welcome to buggy wordle by Chris and Hans");
	    while (!game.isGameOver()) {
	        System.out.println("Enter your guess:" + game.getRemainingGuesses() + " left");
	        String input = scanner.nextLine();

	        game.makeGuess(input);
	        System.out.println("Feedback: " + game.getLastPattern());

	        if (game.lastGuessCorrect()) {
	        	System.out.println("Correct! You won");
	        		break;
	        }
	    }
		


	    if (game.isGameOver()) {
	        System.out.println("\n Out of guesses! The word was: " + game.getSecretWord());
	    }
	    scanner.close();
	}
}
