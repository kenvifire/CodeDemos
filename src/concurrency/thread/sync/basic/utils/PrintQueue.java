/**
 * 2013-1-11
 * PrintQUeue.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kenvi
 * 
 */
public class PrintQueue {
	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;

	public PrintQueue() {
		this.semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long) (Math.random() * 1000);
			System.out.println("====" + Thread.currentThread().getName()
					+ ":Print a job in" + duration / 1000 + "seconds");
			Thread.sleep(duration);
			System.out.println("====" + Thread.currentThread().getName()
					+ "Print done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}

}
