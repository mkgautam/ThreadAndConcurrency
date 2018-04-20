package raceCondition.synchronization;

public class RaceCondition {
	
	/**
	 * Race condition and solution example
	 */
	public static void main(String[] args) throws InterruptedException {
		LongWrapper lw = new LongWrapper(0L);
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					lw.incrementValue();
				}
			}
		};
		Thread[] threads = new Thread[1000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println(lw.getValue());
	}
}
