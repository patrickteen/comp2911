package lab02;

public class Link
{
	private Link	next;
	private Object	item;
	
	public Link (Object data, Link next)
	{
		this.item = data;
		this.next = next;
	}
	
	public Link (Link previous, Object data)
	{
		this (data, null);
		previous.next = this;
	}
	
	public Link getNext ()
	{
		return next;
	}
	
	public Object getItem ()
	{
		return item;
	}
}