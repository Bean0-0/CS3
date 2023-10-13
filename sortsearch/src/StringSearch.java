//(c) A+ Computer Science
//www.apluscompsci.com
//Name - 

public class StringSearch
{
	/*
	 *method countWords will count the occurrences of word in sent
	 *there may many occurrences of word or none at all
	 */
	public static int countWords(String sent, String word)
	{
		int count = 0;
		int wordLength = word.length();

		for (int i = 0; i < sent.length() - wordLength + 1; i++) {
			if (sent.substring(i, i + wordLength).equals(word)) {
				count++;
			}
		}

		return count;
	}

	/*
	 *method countLetters will count the occurrences of letter in sent
	 *there may many occurrences of letter or none at all
	 */
	public static int countLetters(String sent, String letter)
	{
		return (countWords(sent,letter));
	}
}