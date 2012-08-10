package lab02;

/**
 * Linked list implementation. Add method adds to start of list. Implements
 * getLast() method.
 * 
 * @author John Potter
 * 
 */
public class LinkedList implements List
{
	
	private int		size;
	private Link	first;
	
	public void add (Object o)
	{
		first = new Link (o, first);
		++size;
	}
	
	public boolean find (Object o)
	{
		for (Link current = first; current != null; current = current.getNext ())
			if (current.getItem ().equals (o))
				return true;
		return false;
	}
	
	public void print ()
	{
		Link current = first;
		for (int i = 0; i < size; ++i) {
			System.out.println ("" + i + ":" + current.getItem ());
			current = current.getNext ();
		}
	}
	
	public int size ()
	{
		return size;
	}
	
	public Object getLast ()
	{
		return this.first.getItem();
	}
	
	public Object remove ()
	{
		this.size--;
		Link temp = this.first;
		this.first = this.first.getNext();
		return temp.getItem();
	}
	
}
