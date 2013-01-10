/**
 * 2013-1-10
 * Writer.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

/**
 * @author kenvi
 * 
 */
public class Writer implements Runnable {
	private PriceInfo priceInfo;

	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Attempting to modify the price");
			priceInfo.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.println("Writer: prices have been modified");
			try {
				Thread.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
