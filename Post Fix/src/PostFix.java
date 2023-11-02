//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;




	public PostFix()
	{
		stack = new Stack<Double>();
		expression = "";
	}


	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		expression = exp;
	}


	public void setExpression(String exp)
	{
		expression = exp;
	}


	public double calc(double one, double two, char op)
	{
		return switch (op) {
			case '+' -> two + one;
			case '-' -> two - one;
			case '*' -> two * one;
			case '/' -> two / one;
			default -> 0.0;
		};


	}


	public void solve()
	{
		String[] pieces = expression.split(" ");
		String symbols = "+-*/";
		for (String index:
				pieces) {
			if (!symbols.contains(index)){
				stack.push(Double.parseDouble(index));
			}
			else stack.push(calc(stack.pop(), stack.pop(), index.charAt(0)));


		}


	}


	public String toString(){
		solve();
		return expression + " equals " + stack.pop();
	}
}
