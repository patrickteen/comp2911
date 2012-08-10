package lab02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

	protected List list;
	Object item1 = "aString";
	Object item2 = "anotherString";
	Object item3 = "yetAnotherString";

	@Before
	public void setUp() throws Exception {
//		list = new ArrayList();
		list = new LinkedList();
	}

	public ListTest() {
		super();
	}

	@Test
	public void testSetUp() {
		assertNotNull (list);
	}

	@Test
	public void testInitSize() {
		assertEquals ("Empty list", 0, list.size ());
	}

	@Test
	public void testInitFind() {
		assertFalse ("Empty list", list.find (item1));
	}

	@Test
	public void testInitPrint() {
		list.print ();
	}

	@Test
	public void testAddSize() {
		list.add (item1);
		assertEquals ("One item added", 1, list.size ());
	}

	@Test
	public void testAddFind() {
		list.add (item1);
		assertTrue ("One item added", list.find ("aString"));
		assertFalse ("One item added", list.find (item2));
	}

	@Test
	public void testAddPrint() {
		System.out.println ();
		System.out.println ("Output for testAddPrint ... ");
		list.add (item1);
		list.print ();
	}

	@Test
	public void testMultipleAddSize() {
		multipleAdd ();
		assertEquals ("Many items added", 1025, list.size ());
	}

	@Test
	public void testMultipleAddFind() {
		multipleAdd ();
		assertTrue ("Many items added", list.find (item1));
		assertTrue ("Many items added", list.find (item2));
		assertFalse ("Many items added", list.find (item3));
	}

	@Test
	public void testMultipleAddPrint() {
		System.out.println ();
		System.out.println ("Output for testMultipleAddPrint ... ");
		multipleAdd ();
		list.print ();
	}

	void multipleAdd() {
		for (int i = 0; i < 1024; ++i)
			list.add (item1);
		list.add (item2);
	}

	@Test(expected = Throwable.class)
	public void testGetLast() {
		assertEquals ("GetLast precondition violated", null, list.getLast ());
	}

	@Test
	public void testAddLast() {
		list.add (item1);
		assertEquals ("The one item added, is last item", item1,
				list.getLast ());
	}

	@Test
	public void testMultipleAddLast() {
		multipleAdd ();
		assertEquals ("Many items added, last added is last item", item2,
				list.getLast ());
	}

	@Test(expected = Throwable.class)
	public void testInitRemove() {
		assertEquals ("Remove precondition violated", null, list.remove ());
	}

	@Test
	public void testAddRemove() {
		list.add (item1);
		assertEquals ("The one item added is removed", item1, list.remove ());
		assertEquals ("List is now empty", 0, list.size ());
	}

	@Test
	public void testMultipleAddRemove() {
		multipleAdd ();
		assertEquals ("Many items added, last added is last item", item2,
				list.remove ());
		assertEquals ("List has 1024 elements", 1024, list.size ());
	}

	@Test
	public void testMultipleRemove() {
		multipleAdd ();
		list.remove ();
		assertEquals ("Second last item is removed", item1, list.remove ());
		assertEquals ("List has 1023 elements", 1023, list.size ());
		for (int i = 1023; i > 1; --i)
			list.remove ();
		assertEquals ("List has 1 element", 1, list.size ());
		assertEquals ("First item is removed", item1, list.remove ());
		assertEquals ("List has 0 elements", 0, list.size ());
		
	}

}