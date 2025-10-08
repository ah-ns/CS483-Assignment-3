/**
 * Purpose: Generate random words from a list, check if guesses are valid
 * 
 * @author Hans van Lierop, Christopher Saia
 * @version 1
 */
package assignment3;

import java.time.LocalTime;

public class Dictionary {

	private final String[] words = {
			"apple", "these", "super", "paint", "clean",
			"jesty", "apply", "wrong", "curry", "drain",
			"slain", "sword", "irate", "crazy", "close"
	};
	
	public Dictionary() {
		
	}
	
	/**
	 * Determine if a word is a valid guess
	 * 
	 * @param word The word to be checked
	 * @return true if the word is valid, false if not
	 */
	public boolean isValidWord(String word) {
		// Make sure each character of the word is a proper letter
		int lower = 65;
		int upper = 122;
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			if ((int) current < lower | (int) current > upper)
				return false;
		}

		return true;
	}
	
	/**
	 * Get random word from words array
	 * 
	 * @return Random string from the array
	 */
	public String getRandomWord() {
		// Generate random number from current time
		int randomNum = LocalTime.now().getMinute() % (this.words.length);
		// Return element at the random index
		return this.words[randomNum];
	}
}
