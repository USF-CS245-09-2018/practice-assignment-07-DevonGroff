public class ArrayList implements List
{
	// Data Members.
	private Object array[];
	private int arraySize;
	private int maxArraySize = 10;

	// Default constructor.
	public ArrayList()
	{
		this.maxArraySize = maxArraySize;
		this.arraySize = 0;
		array = new Object[maxArraySize];
	}

	// A method to add an item to the end of the array.
	public void add(Object obj)
	{
		// Condition to ensure we haven't filled our array.
		if (arraySize == array.length) 
		{
			// Returns a doubled array if the current array was filled.
			growArray();
		}
		
		// Adds an item to the next open index in the array.
		array[arraySize] = obj;
		arraySize++;
	}
	
	// A method to add an item to the array at a specific position.
	public void add(int pos, Object obj)
	{
		int currentIndex;

		// Condition to ensure the position is within the array.
		if (pos < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		// Condition to ensure we haven't filled our array.
		else if (pos >= array.length)
		{
			// Returns a doubled array if the current array was filled.
			growArray();
		}

		Object current = array[pos];

		// Iterates over the array to add the item to a given position.
		for (int i = pos; i < array.length - 1; i++)
		{
			array[pos + 1] = current;
			current = array[pos];
		}

		array[pos] = obj;
		arraySize++;
	}
	
	// A method to get an item from the array.
	public Object get(int pos)
	{
		// Condition to ensure the position is within the array.
		if (pos >= array.length || pos < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		// Returns the value at the given position in the array.
		else
		{
			return array[pos];
		}
	}

	// A method to remove an item from the array.
	public Object remove(int pos)
	{
		// Condition to ensure the position is within the array.
		if (pos > array.length || pos < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		// Creates a new temp object to hold value at position to be removed.
		Object temp = array[pos];

		// Iterates and moves everything past the removed item forward.
		for (int i = pos; i < arraySize; i++)
		{
			array[i] = array[i + 1];
			i++;
		}

		// Decreases array size.
		--arraySize;

		// Returns the removed item.
		return temp;
	}
	
	// A method to return the size of our array.
	public int size()
	{
		return arraySize;
	}

	// A method to grow our array by doubling its size.
	public void growArray()
	{
		// Creates a new object to store our doubled array.
		Object[] newArray = new Object[array.length * 2];

		// Iterates over current array, adding items to the new doubled array.
		for (int i = 0; i < array.length; i++)
		{
			array[i] = newArray[i];
			i++;
		}

		// Returns the new array.
		array = newArray;
	}
}