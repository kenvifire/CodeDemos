package concurrency.thread.manage;

public class JoinExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSourceLoader dl = new DataSourceLoader();
		Thread thread1 = new Thread(dl);

		NetSourceLoader nl = new NetSourceLoader();
		Thread thread2 = new Thread(nl);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main done");
	}

}
