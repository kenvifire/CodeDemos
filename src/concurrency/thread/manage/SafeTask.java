package concurrency.thread.manage;

import java.util.Date;

public class SafeTask implements Runnable {
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
