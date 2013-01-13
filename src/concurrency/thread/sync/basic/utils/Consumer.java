/**
 * 2013-1-13
 * Consumer.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author kenvi
 * 
 */
public class Consumer implements Runnable {

	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;

	public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int cycle = 1;
		for (int i = 0; i < 10; i++) {
			System.out.println("Consumer:Cycle " + cycle);
			try {
				buffer = exchanger.exchange(buffer);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Consumer:" + buffer.size());

			for (int j = 0; j < 10; j++) {
				String message = buffer.get(0);
				System.out.println("Consumer:" + message);
				buffer.remove(0);
			}
			cycle++;
		}
	}

}
