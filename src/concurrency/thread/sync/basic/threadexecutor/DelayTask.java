/**
 * 2013-1-20
 * DelayTask.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.Date;

/**
 * @author kenvi
 * 
 */
public class DelayTask implements Runnable {
	private String name;

	public DelayTask(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(name + "staring at :" + new Date());
	}

}
