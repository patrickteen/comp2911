package lab02;

import java.math.BigInteger;

public class Factorial
{
	int	n;
	
	public static void require (String message, boolean condition)
	{
		if (!condition)
			throw new IllegalArgumentException ("require " + message);
	}
	
	private static boolean validIndex (int n)
	{
		return n >= 0;
	}
	
	public Factorial (int n)
	{
		this.n = n;
	}
	
	public int asInt ()
	{
		require ("Nonnegative index", validIndex (this.n));
		int result = 1;
		for (int i = 2; i <= this.n; ++i)
			result *= i;
		
		return result;
	}
	
	public long asLong ()
	{
		require ("Nonnegative index", validIndex (this.n));
		long result = 1;
		for (int i = 2; i <= this.n; ++i)
			result *= i;
		return result;
	}
	
	public float asFloat ()
	{
		require ("Nonnegative index", validIndex (this.n));
		float result = 1;
		for (int i = 2; i <= this.n; ++i)
			result *= i;
		return result;
	}
	
	public double asDouble ()
	{
		require ("Nonnegative index", validIndex (this.n));
		double result = 1;
		for (int i = 2; i <= this.n; ++i)
			result *= i;
		return result;
	}
	
	public BigInteger asBigInteger ()
	{
		require ("Nonnegative index", validIndex (this.n));
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= this.n; ++i)
			result = result.multiply (BigInteger.valueOf (i));
		return result;
	}
}
