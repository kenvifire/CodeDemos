/**
 * 2013-1-11
 * Job.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

/**
 * @author kenvi
 * 
 */
public class Job implements Runnable {
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ ":starting to print.");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName() + ":ended.");
	}

}
