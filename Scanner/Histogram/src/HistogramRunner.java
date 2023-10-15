import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram();
		test.setSentence("a b c d e f g h i a c d e g h i h k");
		System.out.println(test);
	}
}