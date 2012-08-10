package lab02;

public interface Timer
{
	void start ();
	
	void stop ();
	
	Interval elapsed ();
	
	void suspend ();
	
	void resume ();
	
}
