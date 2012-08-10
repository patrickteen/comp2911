package lab02;

/**
 * Resizable array-based list implementation. Add method adds to end of list.
 * 
 * @author John Potter
 * 
 */
public class ArrayList implements List
{
	
	private static final double	RESIZE_FACTOR	= 1.5;	// a static final field
														// is a constant
	private Object []			items;
	private int					size;
	
	private int					capacity;
	
	public ArrayList ()
	{
		capacity = 8;
		items = new Object [capacity];
		size = 0;
		assert capacity > 0;
	}
	
	public void add (Object o)
	{
		if (size == capacity)
			resize ();
		assert size < capacity;
		items [size] = o;
		++size;
	}
	
	private void resize ()
	{
		int newCapacity = (int) (RESIZE_FACTOR * capacity);
		Object [] newItems = new Object [newCapacity];
		System.arraycopy (items, 0, newItems, 0, size);
		
		capacity = newCapacity;
		items = newItems;
	}
	
	public boolean find (Object o)
	{
		for (int i = 0; i < size; ++i)
			if (items [i].equals (o))
				return true;
		return false;
	}
	
	public void print ()
	{
		for (int i = 0; i < size; ++i)
			System.out.println ("" + i + ":" + items [i]);
	}
	
	public int size ()
	{
		return size;
	}
	
	public Object getLast ()
	{
		if (size == 0)
			throw new IllegalStateException ("empty list");
		return items [size - 1];
	}
	
	public Object remove ()
	{
		
		// exception if attempting to remove empty list
		if (size == 0)
			throw new IllegalStateException ("empty list");
		this.size--;
		return items[size];
		
	}
	
}
