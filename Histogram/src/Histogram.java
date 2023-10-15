import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Histogram
{
	private Map<String,Integer> histogram;

	public Histogram() {
		histogram = new TreeMap<>();
	}

	public Histogram(String sent) {
		setSentence(sent);
	}

	public void setSentence(String sent) {
		String clean = sent.replaceAll(" ","");
		for (int i = 0; i < clean.length(); i++) {
			String charString = clean.substring(i, i + 1);
			int count = histogram.getOrDefault(charString, 0);
			histogram.put(charString, count + 1);
		}
	}

	public String toString()
	{
		String output = "";
		for (String word : histogram.keySet()) {
			output += word + "  ";
			for (int i = 0; i < histogram.get(word); i++) {
				output += "*";
			}
			output += "\n";
		}
		return output;
	}

}