import static java.lang.System.*;
import java.util.ArrayList;

public class Palin {

    private String word;

    public Palin(String word) {
        this.word = word;
    }

    public int getLength() {
        return word.length();
    }

    public String getWord() {
        return word;
    }

    public boolean isPalin() {
        StringBuffer reversedWord = new StringBuffer(word).reverse();
        return word.equals(reversedWord.toString());
    }


    public String toString() {
        return word;
    }

}
