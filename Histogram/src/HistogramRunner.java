import java.io.IOException;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram();
		test.setSentence("a b c d e f g h i a c d e g h i h k");
		System.out.println(test);
	}
}