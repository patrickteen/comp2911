package lab02;

public interface Interval
{
	long nanoSeconds ();
	
	long microSeconds ();
	
	long milliSeconds ();
	
	long seconds ();
	
	Interval add (long nanoFrom, long nanoTo);
}