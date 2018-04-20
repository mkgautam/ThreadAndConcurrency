package deadlock;

public class RunningSample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Sample sp = new Sample();
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				sp.a();
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				sp.b();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
}
