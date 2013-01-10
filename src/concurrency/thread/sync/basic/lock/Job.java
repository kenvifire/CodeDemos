/**
 * 2013-1-10
 * Job.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.lock;

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
		printQueue.printJob(new Object());
	}

}
