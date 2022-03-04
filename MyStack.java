/**
 *  A generic stack class that implements the QueueInterface 
 *  @author yanaL
 */
import java.util.ArrayList;

public class MyStack<T> {
	
	public T[] data;
	public int capacity;
	public int numOfElements;
	public int front=0;
	
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	public MyStack()
	{
		data = (T[])new Object [100];
		numOfElements =0 ;
	}
	public MyStack(int capacity)
	{
		data = (T[])new Object [capacity];
		numOfElements = 0 ;
		this.capacity = capacity;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if (numOfElements == 0)
			return true;
		else
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull()
	{
		if (numOfElements >= capacity)
			return true;
		else
			return false;
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException
	{
		
		if (isEmpty())
			throw new StackUnderflowException("This should have caused an StackUnderflowException");
		else
		{
			T removed = null;
			removed = data[numOfElements-1];
			data[numOfElements-1] = null;
			numOfElements --;
			return removed;
		}
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException
	{
		if (isEmpty())
			throw new StackUnderflowException("This should have caused an StackUnderflowException");
		else
			return data[numOfElements-1];
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size()
	{
		return numOfElements;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException
	{
		if (isFull())
			throw new StackOverflowException("This should have caused an StackOverflowException");		
		else
		{
			data[numOfElements] = e;
			numOfElements ++ ;
			return true;
		}
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{
		String stack="";
		for(int i=0; i< numOfElements; i++)
			stack += data[i];
		return stack;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String stack="";
		for(int i=0; i< numOfElements; i++)
		{
			if (i == numOfElements -1)
				stack += data[i] ;
			else
				stack += data[i]+ delimiter;
		}
		return stack;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list)
	{
		T temp;
		for (int i=0; i< list.size(); i++)
		{
			temp = list.get(i);
			if (isFull())
				throw new StackOverflowException("This should have caused an StackOverflowException");
			data[numOfElements] = temp;
			numOfElements ++ ;
		}
	}
 
}
