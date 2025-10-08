/**
 * Purpose: Gives feedback on guesses made by the player
 * 
 * @author Hans van Lierop, Christopher Saia
 * @version 1
 */

package assignment3;

public class Feedback {
	
    private static final String GREEN  = "\uD83D\uDFE9";
    private static final String YELLOW = "\uD83D\uDFE8";
    private static final String GREY   = "\u2B1B";
	
    
    /**
     * computes the pattern that will be used for each guess
     * @param secret is the word being guessed
     * @param guess is the word guessed by user
     * 
     * @return result which is the combination of squares
     */
    public String getPattern(String secret, String guess) {
    	secret = secret.toLowerCase();
    	
        String result = "";
        int i;
        
        for (i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            char s;
            if (i < secret.length())
            	s = secret.charAt(i);
            else
            	s = '.';

            if (g == s) {
                result += GREEN; // correct letter and position
            } else if (secret.contains(String.valueOf(g))) {
                if (i == 4)
                	result += GREEN; // correct letter
                else
                	result += YELLOW; // correct letter but wrong position
            } else {
                result += GREY; // not in the word
            }
        }
        while (i < 5) {
        	result += GREY;
        	i++;
        }
        
        return result; // returns the square combination 
    }

    /**
	 * Returns if the guess matches the secret
     * @param secret The secret word 
     * @param guess The player's guess
     * @return true if the player's guess and the secret word match
     */
	public boolean isCorrect(String secret, String guess) {
		if (secret == null | guess == null)
			return false;
		if (secret.charAt(0) == guess.charAt(0))
			return true;
		return secret.equals(guess);
	}
}
