package assignment3;

import java.util.Map;

public class Feedback {
	
    private static final String GREEN  = "\uD83D\uDFE9";
    private static final String YELLOW = "\uD83D\uDFE8";
    private static final String GREY   = "\u2B1B";
	
    
    /* computes the pattern that will be used for each guess
     * @param secret is the word being guessed
     * @param guess is the word guessed by user
     * 
     * @return result which is the combination of squares
     */
    public String getPattern(String secret, String guess) {
        secret = secret.toLowerCase();
        guess = guess.toLowerCase();

        String result = "";

        for (int i = 0; i < 5; i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);

            if (g == s) {
                result += GREEN; // correct letter and position
            } else if (secret.contains(String.valueOf(g))) {
                result += YELLOW; // correct letter but wrong position
            } else {
                result += GREY; // not in the word
            }
        }

        return result; // resturns the square combination 
    }
	
	public boolean isCorrect(String secret, String guess) {
		return secret.compareTo(guess) == 0 ? true : false;
	}
}
