/**
 * 2013-1-11
 * Main.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

/**
 * @author kenvi
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		PrintQueue printQueue = new PrintQueue();

		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Job(printQueue));
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}
	}

}
