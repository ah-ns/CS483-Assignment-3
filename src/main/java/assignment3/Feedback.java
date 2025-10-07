package assignment3;

import java.util.Map;

public class Feedback {
	
	public String getPattern(String secret, String guess) {
		final Map<String, String> patternSquares = Map.ofEntries(
				Map.entry("green", "\uD83D\uDFE9"),
				Map.entry("yellow", "\uD83D\uDFE8"),
				Map.entry("grey", "\u2B1B")
		);
		return patternSquares.get("green");
	}
	
	public boolean isCorrect(String secret, String guess) {
		return secret.compareTo(guess) == 0 ? true : false;
	}
}
