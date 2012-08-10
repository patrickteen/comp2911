package lab02;

public class NanoInterval implements Interval
{
	public static final long	ONE_MICROSECOND	= 1000L;
	public static final long	ONE_MILLISECOND	= 1000000L;
	public static final long	ONE_SECOND		= 1000000000L;
	
	private long				nanoSeconds;
	
	public NanoInterval (long duration)
	{
		if (duration < 0)
			throw new IllegalArgumentException ("Require nonnegative duration");
		nanoSeconds = duration;
	}
	
	public long nanoSeconds ()
	{
		return nanoSeconds;
	}
	
	public long microSeconds ()
	{
		return (nanoSeconds + ONE_MICROSECOND / 2) / ONE_MICROSECOND; // round up to nearest
	}
	
	public long milliSeconds ()
	{
		return (nanoSeconds + ONE_MILLISECOND / 2) / ONE_MILLISECOND; // round up to nearest
	}
	
	public long seconds ()
	{
		return (nanoSeconds + ONE_SECOND / 2) / ONE_SECOND; // round up to nearest
	}
	
	public Interval add (long nanoFrom, long nanoTo)
	{
		long duration = nanoTo - nanoFrom;
		long total = nanoSeconds + duration;
		if (duration < 0 || total < 0)
			throw new IllegalArgumentException ("Require nonnegative intervals");
		return new NanoInterval (total);
	}
}
