import java.util.Stack;
import static java.lang.System.*;


public class SyntaxChecker
{
	private String exp;


	private Stack<Character> symbols;


	private String open;


	private String close;


	public SyntaxChecker()
	{


	}


	public SyntaxChecker(String o, String c)
	{
		open = o;
		close = c;


	}


	public void setExpression(String s)
	{
		exp = s;
	}


	public boolean checkExpression()
	{
		symbols = new Stack<Character>();


		for (int i = 0; i < exp.length(); i++){
			String current = exp.charAt(i)+ "";


			if (open.contains(current)){
				symbols.push(exp.charAt(i));
			}
			else if (close.contains(current)){
				if (symbols.isEmpty())
					return false;


				char just_popped = symbols.pop();
				if (open.indexOf(just_popped) != close.indexOf(current))
					return false;
			}


		}
		return symbols.isEmpty();
	}


	public String toString (){


		if (checkExpression())
			return exp + " is correct.";
		else return exp + " is incorrect";


	}
}
