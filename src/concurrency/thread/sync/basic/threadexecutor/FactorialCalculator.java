/**
 * 2013-1-17
 * FactorialCalculator.java
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
public class FactorialCalculator implements Callable<Integer> {
	private Integer num;

	public FactorialCalculator(Integer num) {
		this.num = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if (num == 0 || num == 1) {
			result = 1;
		} else {
			for (int i = 2; i <= num; i++) {
				result *= i;
				TimeUnit.MICROSECONDS.sleep(20);
			}
		}
		System.out.println(Thread.currentThread().getName() + " result:"
				+ result);
		return result;
	}

}
