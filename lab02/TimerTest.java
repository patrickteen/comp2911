package lab02;

public class TimerTest
{
	Timer	timer	= new NanoTimer ();
	
	TimerTest (String header)
	{
		System.out.println ();
		System.out.println (header);
		display ("initially");
	}
	
	void display (String info)
	{
		System.out.format ("%10s ... elapsed time (sec) = ", info);
		System.out.println (timer.elapsed ().seconds ());
	}
	
	void start ()
	{
		timer.start ();
		display ("start");
		pause ();
		display ("pause");
		pause ();
		display ("pause");
	}
	
	void suspend ()
	{
		timer.suspend ();
		display ("suspend");
		pause ();
		display ("pause");
		pause ();
		display ("pause");
	}
	
	void resume ()
	{
		timer.resume ();
		display ("resume");
		pause ();
		display ("pause");
	}
	
	void stop ()
	{
		timer.stop ();
		display ("stop");
		pause ();
		display ("pause");
	}
	
	void startStop ()
	{
		start ();
		stop ();
	}
	
	void suspendResume ()
	{
		start ();
		suspend ();
		resume ();
		suspend ();
		suspend ();
		resume ();
		resume ();
		stop ();
	}
	
	void restart ()
	{
		start ();
		startStop ();
		startStop ();
		stop ();
		resume ();
		suspend ();
	}
	
	private void pause ()
	{
		try {
			Thread.sleep (1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace ();
		}
	}
	
	public static void main (String [] args)
	{
		TimerTest test;
		
		test = new TimerTest ("start test:");
		test.start ();
		
		test = new TimerTest ("stop test:");
		test.stop ();
		
		test = new TimerTest ("suspend test:");
		test.suspend ();
		
		test = new TimerTest ("resume test:");
		test.resume ();
		
		test = new TimerTest ("startStop test:");
		test.startStop ();
		
		test = new TimerTest ("suspendResume test:");
		test.suspendResume ();
		
		test = new TimerTest ("restart test:");
		test.restart ();
		
		System.out.println ();
		System.out.println ("end of tests!");
	}
}
