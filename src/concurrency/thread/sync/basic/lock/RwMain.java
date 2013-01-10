/**
 * 2013-1-10
 * RwMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

/**
 * @author kenvi
 * 
 */
public class RwMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriceInfo priceInfo = new PriceInfo();
		Reader[] readers = new Reader[5];
		Thread[] threadReader = new Thread[5];
		Writer writer = new Writer(priceInfo);
		Thread threadWriter = new Thread(writer);

		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(priceInfo);
			threadReader[i] = new Thread(readers[i]);
		}
		for (int i = 0; i < 5; i++) {
			threadReader[i].start();
		}
		threadWriter.start();
	}

}
