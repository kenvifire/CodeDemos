/**
 * 2013-1-10
 * Reader.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

/**
 * @author kenvi
 * 
 */
public class Reader implements Runnable {
	private PriceInfo priceInfo;

	public Reader(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":price 1"
				+ priceInfo.getPrice1());
		System.out.println(Thread.currentThread().getName() + ":price 2"
				+ priceInfo.getPrice2());
	}

}
