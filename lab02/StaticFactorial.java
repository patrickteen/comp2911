package lab02;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class StaticFactorial
{
	
	/** Precondition checker.
	 * An exception will be thrown if the precondition does not hold.
	 * This does not depend on assertion checking being enabled.
	 * @param message for display in precondition violation exception
	 * @param condition precondition that must be true
	 */
	public static void require (String message, boolean condition)
	{
		if (!condition)
			throw new IllegalArgumentException ("require " + message);
	}
	
	/** Is the argument nonnegative?
	 * @param n
	 * @return n >= 0
	 */
	public static boolean validIndex (int n)
	{
		return n >= 0;
	}

	/** Factorial n using int values.
	 * @param n
	 * @return n!
	 */
	public static int asInt (int n)
	{
		require ("Nonnegative index", validIndex (n));
		int result = 1;
		for (int i = 2; i <= n; ++i)
			result *= i;
		return result;
	}
	
	/** Factorial n using long values.
	 * @param n
	 * @return n!
	 */
	public static long asLong (int n)
	{
		require ("Nonnegative index", validIndex (n));
		long result = 1;
		for (int i = 2; i <= n; ++i)
			result *= i;
		return result;
	}
	
	/** Factorial n using float values.
	 * @param n
	 * @return n!
	 */
	public static float asFloat (int n)
	{
		require ("Nonnegative index", validIndex (n));
		float result = 1;
		for (int i = 2; i <= n; ++i)
			result *= i;
		return result;
	}
	
	/** Factorial n using double values.
	 * @param n
	 * @return n!
	 */
	public static double asDouble (int n)
	{
		require ("Nonnegative index", validIndex (n));
		double result = 1;
		for (int i = 2; i <= n; ++i)
			result *= i;
		return result;
	}
	
	/** Factorial n using BigInteger values.
	 * @param n
	 * @return n!
	 */
	public static BigInteger asBigInteger (int n)
	{
		require ("Nonnegative index", validIndex (n));
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; ++i)
			result = result.multiply (BigInteger.valueOf (i));
		return result;
	}
	
	// remaining methods are for IO handling
	
	/** The standard output stream.
	 */
	public static final PrintStream	OUT	= System.out;
	
	/** A scanner for the standard input stream.
	 */
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

	private static void process (int n)
	{
		OUT.println ("factorial(" + n + ") =");
		OUT.println ("asInt: " + asInt (n));
		OUT.println ("asLong: " + asLong (n));
		OUT.println ("asFloat: " + asFloat (n));
		OUT.println ("asDouble: " + asDouble (n));
		OUT.println ("asBigInteger: " + asBigInteger (n));
		OUT.println ();
	}
	
	public static void main (String [] args)
	{
		OUT.println ("Calculate factorial(n) using different number representations");
		OUT.println ();
		
		while (hasNext ()) next ();
		
		OUT.println ();
		OUT.println ("Done");
	}
	
}
