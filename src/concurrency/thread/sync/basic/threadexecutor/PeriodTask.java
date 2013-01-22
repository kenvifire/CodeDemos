/**
 * 2013-1-20
 * PeriodTask.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author kenvi
 * 
 */
public class PeriodTask implements Callable<String> {
	private String name;

	public PeriodTask(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		System.out.println(name + " staring at:" + new Date());
		return "Hello world";
	}

}
