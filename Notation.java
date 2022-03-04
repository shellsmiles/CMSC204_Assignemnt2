import java.util.ArrayList;
public class Notation {

	
	public Notation()
	{
	}

	
	public static boolean highPrecedence(String s, char ch)
	{
		if ((s.equals("+") || s.equals("-")) && (ch == '+' || ch == '-'))
			return true;
		else if ((s.equals("*")|| s.equals("/") ) && (ch == '*' || ch == '/'))
			return true;
		else if ( (s.equals("*") || s.equals("/")) && (ch == '+' || ch == '-'))
			return true;
		else
			return false;
	}
	
	/**
	 * Use a queue for the internal structure that holds the 
	 * postfix solution. Then use the toString method of the 
	 * Queue to return the solution as a string
	 * @param infixExpr
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException- if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException
	{
		MyQueue <String> postFix = new MyQueue<>();
		MyStack <String> operStack = new MyStack<>();
		for (int i=0; i< infix.length(); i++)
		{
			int cur= i;
			char curChar = infix.charAt(i);
			if (infix.charAt(cur) == ' ')	
				continue;
			else if ( infix.charAt(cur) >= 48 && infix.charAt(cur) <= 57)
				postFix.enqueue(curChar+"") ;
			else if ( infix.charAt(cur) == '(')
				operStack.push (curChar+"" );
			else if ( infix.charAt(cur) == '+'|| infix.charAt(cur) == '-'
				   || infix.charAt(cur) == '*'|| infix.charAt(cur) == '/')
			{
				if (!operStack.isEmpty() && highPrecedence(operStack.top(), curChar ) )
				{
					postFix.enqueue(operStack.top());
					operStack.pop();
					operStack.push ( curChar+"" );
				}
				else 
					operStack.push ( curChar+"" );
					
			}
			else if ( infix.charAt(cur) == ')')
			{
				while ( !operStack.top().equals("("))
				{
					postFix.enqueue(operStack.top());
					operStack.pop();
					if ( operStack.isEmpty())
						throw new InvalidNotationFormatException("This should have thrown an InvalidNotationFormatException");
				}
				if ( operStack.top().equals("("))
				{
					operStack.pop();
				}
			}
		
		}
		
		
//		
//		int cur = 0;
//		while ( cur >= 0 )
//		{
//			
//			char curChar = infix.charAt(cur); 
//			switch (curChar)
//			{
//				case ' ':
//					continue;
//				case 0: case 1: case 2: case 3: case 4: 
//				case 5: case 6: case 7: case 8: case 9:
//					postFix.enqueue(curChar+"") ;
//				case '+': case '-': case '*': case '/':
//				{
//					if (!operStack.isEmpty() && highPrecedence(operStack.top(),curChar) )
//					{
//						postFix.enqueue(operStack.top()) ;
//						operStack.pop();
//						operStack.push ( curChar+"" );
//					}
//					else 
//						operStack.push ( curChar+"" );
//				}
//				case '(':
//					operStack.push ( curChar+"" );
//				case ')':
//					while ( !operStack.top().equals("("))
//					{
//						postFix.enqueue(operStack.top());
//						operStack.pop();
//						if ( operStack.isEmpty())
//							throw new InvalidNotationFormatException("This should have thrown an InvalidNotationFormatException");
//					}
//					if ( operStack.top().equals("("))
//					{
//						operStack.pop();
//					}
//			}
//			cur ++;
//		}
		return postFix.toString();
	}
	
	/**
	 * 
	 * @param postfix
	 * @return
	 * @throws InvalidNotationFormatException- if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException
	{
		return null;
	}
	
	/**
	 * 
	 * @param postfixExpr
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfix(String postfixExpr) throws InvalidNotationFormatException
	{
		return 0.00;
	}
}
