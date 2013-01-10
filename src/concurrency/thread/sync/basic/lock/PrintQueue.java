/**
 * 2013-1-10
 * PrintQueue.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kenvi
 * 
 */
public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();

	public void printJob(Object document) {
		queueLock.lock();
		try {
			long duration = (long) (Math.random() * 1000);
			System.out.println(Thread.currentThread().getName() + "PrintQueue:"
					+ (duration / 1000));
			Thread.sleep(duration);
			System.out
					.println(Thread.currentThread().getName() + " print done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}
}
