import java.util.ArrayList;

public class LongPalindrome {

	private static class Palin {
		private String word;

		public Palin(String word) {
			this.word = word;
		}

		public String getWord() {
			return word;
		}

		@Override
		public String toString() {
			return word;
		}
	}

	public static ArrayList<Palin> getAllPalins(String word) {
		ArrayList<Palin> palindromes = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j <= word.length(); j++) {
				String substring = word.substring(i, j);
				if (isPalindrome(substring) && substring.length() > 1) {
					 palindromes.add(new Palin(substring));
				}
			}
		}
		palindromes.sort((p1, p2) -> p1.getWord().compareTo(p2.getWord()));
		return palindromes;
	}

	private static boolean isPalindrome(String word) {
		StringBuffer reversedWord = new StringBuffer(word).reverse();
		return word.equals(reversedWord.toString());
	}
	public static String getLongestPalindrome(String word) {
		String longest = "";
		ArrayList<Palin> palindromes = getAllPalins(word);
		if (palindromes.isEmpty()) {
			return null;
		}
		for (int i = 0; i < palindromes.size() ; i++) {
			String current = String.valueOf(palindromes.get(i));
			if (current.length() > longest.length()) {
				longest = current;
			}
		}
		return longest;
	}
}