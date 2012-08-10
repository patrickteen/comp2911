package lab02;

public class NanoTimer implements Timer
{
	
	public enum State {
		RUNNING,
		SUSPENDED,
		STOPPED
	}
	
	Interval elapsedTimeInterval = new NanoInterval(0);
	long lastPausedStoppedTime;
	State state = State.STOPPED;
	
	public static long currentTime ()
	{
		return System.nanoTime ();
	}

	public void start ()
	{
		this.elapsedTimeInterval = new NanoInterval(0);
		this.lastPausedStoppedTime = System.nanoTime();
		this.state = State.RUNNING;
	}

	public Interval elapsed ()
	{
		if (this.state == State.RUNNING) {
			this.elapsedTimeInterval = this.elapsedTimeInterval.add(this.lastPausedStoppedTime, System.nanoTime());
			this.lastPausedStoppedTime = System.nanoTime();
		}
		return this.elapsedTimeInterval;
	}
	
	public void stop ()
	{
		if (this.state == State.RUNNING) {
			this.elapsedTimeInterval = this.elapsedTimeInterval.add(this.lastPausedStoppedTime, System.nanoTime());
		}
		this.state = State.STOPPED;
	}

	public void suspend ()
	{
		if (this.state == State.RUNNING) {
			this.state = State.SUSPENDED;
			this.elapsedTimeInterval = this.elapsedTimeInterval.add(this.lastPausedStoppedTime, System.nanoTime());
		}
	}

	public void resume ()
	{
		if (this.state == State.SUSPENDED) {
			this.state = State.RUNNING;
			this.lastPausedStoppedTime = System.nanoTime();
		}
	}
	
}
