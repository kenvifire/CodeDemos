/**
 * 2013-1-10
 * PriceInfo.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kenvi
 * 
 */
public class PriceInfo {
	private double price1;
	private double price2;
	private ReadWriteLock rwLock;

	public PriceInfo() {
		price1 = 1.0;
		price2 = 2.0;
		rwLock = new ReentrantReadWriteLock();

	}

	public double getPrice1() {
		rwLock.readLock().lock();
		double value = price1;
		rwLock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		rwLock.readLock().lock();
		double value = price2;
		rwLock.readLock().unlock();
		return value;
	}

	public void setPrices(double price1, double price2) {
		rwLock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		rwLock.writeLock().unlock();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
