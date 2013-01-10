package concurrency.thread.sync.basic.condition;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
	private int maxSize;
	private LinkedList<Date> storage;

	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();

	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		storage.offer(new Date());
		System.out.printf("Set: %d", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Get:" + storage.size() + "," + storage.poll());
		notifyAll();
	}

}
