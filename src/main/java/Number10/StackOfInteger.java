package Number10;
public class StackOfInteger 
{
	private int elements[];
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	public StackOfInteger()
	  {
		elements = new int[DEFAULT_CAPACITY];
	  }
	public StackOfInteger(int capacity)
	  {
		elements = new int[capacity];
	  }
	public boolean empty()
	  {
		if(size == 0)
		  {
			return true;
		  }
		else
		  {
			return false;
		  }
	  }
	public int peek()
	  {
		return elements[size - 1];
	  }
	public void push(int value)
	  {
		elements[size] = value;
		size++;   //先进后增
	  }
	public int pop()
	  {
		size--;
		return elements[size]; //先减后出
	  }
	public int getSize()
	  {
		return size;
	  }
}
