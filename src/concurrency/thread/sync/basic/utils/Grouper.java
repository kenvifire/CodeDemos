/**
 * 2013-1-12
 * Grouper.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

/**
 * @author kenvi
 * 
 */
public class Grouper implements Runnable {

	private Results results;

	public Grouper(Results results) {
		this.results = results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper:Processing results...\n");
		int data[] = results.getData();
		for (int number : data) {
			finalResult += number;
		}
		System.out.println("Grouper : Total result:" + finalResult);
	}
}
