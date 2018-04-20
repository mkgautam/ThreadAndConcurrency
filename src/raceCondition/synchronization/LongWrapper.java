package raceCondition.synchronization;

public class LongWrapper {
	
	private final Object key = new Object();
	
	private long l;
	
	public LongWrapper(long l) {
		super();
		this.l = l;
	}

	public long getValue() {
		//here reading for l is not synchronized, it doesn't guarantee the value returning
		// from Line 31 will be same for threads. So code is till buggy

		// So, we have this block also as synchronized also
		synchronized (key) {
			return l;
		}
	}

	/**	
	 * remove synchronized block, it will be an example of race condition.
	 * after adding synchronized block, race condition is eradicated.
	 * 
	 */
	public void incrementValue() {
		synchronized (key) {
			//this is read and write operation
			//reading l first
			//writing incremented value to l then 
			l = l + 1;
		}
	}
	
}
