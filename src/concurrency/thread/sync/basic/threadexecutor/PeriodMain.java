/**
 * 2013-1-20
 * PeriodMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kenvi
 * 
 */
public class PeriodMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);
		System.out.println("Main:starting at " + new Date());
		DelayTask task = new DelayTask("Task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2,
				TimeUnit.SECONDS);
		for (int i = 0; i < 10; i++) {
			System.out.println("Main:Delay "
					+ result.getDelay(TimeUnit.MICROSECONDS));
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main finished at :%s" + new Date());

	}
}
