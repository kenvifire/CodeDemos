/**
 * 2013-1-20
 * ResultTask.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author kenvi
 * 
 */
public class ResultTask implements Callable<Result> {

	private String name;

	public ResultTask(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Result call() throws Exception {
		System.out.println("Staring..." + this.name);
		try {
			long duration = (long) (Math.random() * 10);
			System.out.println("Waiting  " + duration + "for result");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int value = 0;
		for (int i = 0; i < 5; i++) {
			value += (long) (Math.random() * 1000);
		}
		Result result = new Result();
		result.setValue(value);
		result.setName(name);
		return result;

	}
}
