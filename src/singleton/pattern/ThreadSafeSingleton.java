package singleton.pattern;

public class ThreadSafeSingleton {
	
	private static volatile ThreadSafeSingleton instance;
	
	private static final Object key = new Object();
	
	private ThreadSafeSingleton() {}
	
	public static ThreadSafeSingleton getInstance() {
		if(instance != null) {
			return instance;
		}
		//also known as double checked locking
		synchronized (key) {
			if(instance == null) {
				instance = new ThreadSafeSingleton();
			}
			return instance;
		}
	}
	
}
