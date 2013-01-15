/**
 * 2013-1-15
 * Task.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author kenvi
 * 
 */
public class Task implements Runnable {
	private Date initDate;
	private String name;

	public Task(String name) {
		this.name = name;
		this.initDate = new Date();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Task:" + name
				+ " Create on :" + initDate);
		System.out.println(Thread.currentThread().getName() + " Task:" + name
				+ " Start on :" + new Date());
		try {
			long duration = (long) Math.random() * 10;

			System.out.println(Thread.currentThread().getName() + " Task:"
					+ name + " during  :" + duration / 1000 + " seconds");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " Task:" + name
				+ " finished :" + new Date());
	}
}
