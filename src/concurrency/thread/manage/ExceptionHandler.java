package concurrency.thread.manage;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exception occured:" + e);
		System.out.println("Thread id is:" + t.getId());
	}

}
