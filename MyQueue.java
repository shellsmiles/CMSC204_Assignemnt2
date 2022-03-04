/**
 * A generic queue class that implements the QueueInterface 
 * @author yanaL
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {

	public T[] data;
	public int capacity;
	public int front=0;
	public int numOfElements;
	
	/** provide two constructors 
	 * 1. default constructor - uses a default as the size of the queue
	 * 2. takes an int as the size of the queue
	 */
	@SuppressWarnings("unchecked")
	public MyQueue() 
	{
		data = (T[]) new Object [100];
		numOfElements = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity) 
	{
		data = (T[]) new Object [capacity];
		this.capacity= capacity;
		numOfElements = 0;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() 
	{
		if (numOfElements == 0)
			return true;
		else
			return false;
	}
		
	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull()
	{
		if (numOfElements >= capacity)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size()
	{	
		return numOfElements;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if (isEmpty())
			throw new QueueUnderflowException("This should have caused an QueueUnderflowException");
		else
		{
			T removed = null;
			removed = data[front];
			data[front] = null;
			front ++; 
			numOfElements -- ;
			return removed;
		}
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if (isFull())
			throw new QueueOverflowException("This should have caused an QueueOverflowException");		
		else
		{
			data[numOfElements] = e;
			numOfElements ++ ;
			return true;
		}
		
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString()
	{
		String queue = "";
		for (int i= 0; i< numOfElements; i++)  //data.length != numOfElements
		{
			queue += data[i];
		}
		return queue;
//		for ( T item:  data)
//			queue += (String) item;
//		return queue;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter)
	{
		String queue = "";
		for (int i= 0; i< numOfElements; i++)
		{
			if (i== numOfElements-1 )
				queue += data[i];
			else
				queue += data[i] + delimiter ;
		}
		return queue;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill (ArrayList<T> list) throws QueueOverflowException
	{
		for(int i= 0; i< list.size(); i++)
		{
			T temp;
			temp= list.get(i);
			if (isFull())
				throw new QueueOverflowException("This should have caused an QueueOverflowException");
		
			data[numOfElements] = temp;
			numOfElements ++ ;
		}
		
		
	}
	

	}

	

