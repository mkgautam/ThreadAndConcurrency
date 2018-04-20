package singleton.pattern;

public class MainClass {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					//System.out.println(EnumSingleton.INSTANCE.hashCode());
					//System.out.println(FactoryMethodSingleton.getInstance().hashCode());
					//System.out.println(LazyInitializedSingleton.getInstance().hashCode());
					System.out.println(ThreadSafeSingleton.getInstance().hashCode());
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
	}

}
