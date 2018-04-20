package producer.consumer.unsynchronized_with_RaceCondition;

public class ProducerConsumer {
	
	private static final int BUFFER_SIZE = 10;
	private static final int WORK_LOAD_PRODUCE = 50;
	private static final int WORK_LOAD_CONSUME = 50;
	
	private static int[] buffer;
	private static int count;
	
	public static class Producer {
		public void produce() {
			while(isFull(buffer)) {
				
			}
			buffer[count++] = 1;
		}
	}
	
	public static class Consumer{
		public void consume() {
			while(isEmpty(buffer)) {
				
			}
			buffer[--count] = 0;
		}
	}
	
	private static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	private static boolean isEmpty(int[] buffer2) {
		return count == 0;
	}
	
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[BUFFER_SIZE];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable producerTask = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < WORK_LOAD_PRODUCE; i++) {
					producer.produce();
				}
				System.out.println("Done producing");
			}
		};
		Runnable consumerTask = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < WORK_LOAD_CONSUME; i++) {
					consumer.consume();
				}
				System.out.println("Done consuming");
			}
		};
		
		Thread producerThread = new Thread(producerTask);
		Thread consumerThread = new Thread(consumerTask);
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();
		
		System.out.println("Data in the buffer: " + count);
	}
	
}
