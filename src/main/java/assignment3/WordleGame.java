package assignment3;

public class WordleGame {
	
	private String secret;
	private String guess;
	private int guesses;
	private Feedback feedback;
	private Dictionary dict;
	
	public WordleGame() {
		this.secret = "apple";
		this.guesses = 6;
		this.feedback = new Feedback();
		this.dict = new Dictionary();
	}
	
	public void startGame() {
		
	}
	
	public void makeGuess(String guess) {
		
	}
	
	public boolean isGameOver() {
		if (this.guesses > 0 | !this.feedback.isCorrect(this.secret, this.guess))
			return false;
		else
			return true;
	}
	
	public String getSecretWord() {
		return "";
	}
	
	public static void main(String[] args) {
		
	}
}
