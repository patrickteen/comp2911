package lab02;

import java.io.PrintStream;
import java.util.Scanner;

public class FactorialTest
{
	
	public static final PrintStream	OUT	= System.out;
	public static final Scanner		IN	= new Scanner (System.in);
	
	private static boolean hasNext ()
	{
		prompt ();
		while (IN.hasNext () && !IN.hasNextInt ()) {
			IN.next (); // advance past invalid input
			invalidInputMessage ();
			prompt ();
		}
		return IN.hasNext ();
	}
	
	private static void prompt ()
	{
		OUT.print ("n = ");
	}
	
	private static void invalidInputMessage ()
	{
		OUT.println ("Input must be a nonnegative int. Try again. Terminate with EOF character");
	}
	
	private static void next ()
	{
		assert IN.hasNextInt ();
		
		int n = IN.nextInt ();
		if (validIndex (n))
			process (n);
		else
			invalidInputMessage ();
	}
	
	public static boolean validIndex (int n)
	{
		return n >= 0;
	}
	
	private static void process (int n)
	{
		Factorial fac = new Factorial (n);
		
		OUT.println ("factorial(" + n + ") =");
		OUT.println ("asInt: " + fac.asInt ());
		OUT.println ("asLong: " + fac.asLong ());
		OUT.println ("asFloat: " + fac.asFloat ());
		OUT.println ("asDouble: " + fac.asDouble ());
		OUT.println ("asBigInteger: " + fac.asBigInteger ());
		OUT.println ();
	}
	
	public static void main (String [] args)
	{
		OUT.println ("Calculate factorial(n) using different number representations");
		OUT.println ();
		
		while (hasNext ())
			next ();
		
		OUT.println ();
		OUT.println ("Done");
	}
	
}
