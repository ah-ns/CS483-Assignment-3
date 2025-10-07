package assignment3;

public class WordleGame {
	
	private String secret;
	private String guess;
	private int guesses;
	private Feedback feedback;
	
	public WordleGame() {
		this.secret = "apple";
		this.guesses = 6;
		this.feedback = new Feedback();
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
		return this.secret;
	}
	
	public static void main(String[] args) {
		
	}
}
