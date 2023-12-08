public class Word {
	private String theValue;

	// Constructor method
	public Word(String theValue) {
		this.theValue = theValue;
	}

	// Get the value of the word
	public String getValue() {
		return theValue;
	}

	// Check if two words are equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Word word = (Word) obj;
		return theValue.equalsIgnoreCase(word.theValue);
	}

	// Generate a hash code for the word
	@Override
	public int hashCode() {
		return theValue.toLowerCase().hashCode();
	}

	// Convert the word to a string
	@Override
	public String toString() {
		return theValue;
	}
}
