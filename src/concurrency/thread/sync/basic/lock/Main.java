/**
 * 2013-1-10
 * Main.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

/**
 * @author kenvi
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Job(printQueue));
		}
		for (Thread t : threads) {
			t.start();
		}
	}

}
