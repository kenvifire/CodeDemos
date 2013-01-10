package concurrency.thread.manage;

public class ExceptionHandlerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread task = new Thread(new Task());
		task.setUncaughtExceptionHandler(new ExceptionHandler());
		task.start();
	}

}
