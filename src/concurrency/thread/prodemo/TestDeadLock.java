package concurrency.thread.prodemo;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestDeadLock {
	private Object lockA = new Object();
	private Object lockB = new Object();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final TestDeadLock test = new TestDeadLock();
		new Thread(new Runnable() {

			@Override
			public void run() {
				Thread.currentThread().setName("demo2");
				test.demo1();

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				Thread.currentThread().setName("demo2");
				test.demo2();

			}
		}).start();
		Thread.sleep(500);
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = mxBean.getAllThreadIds();
		ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);

		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println(threadInfo.getThreadName());
			System.out.println(threadInfo.getBlockedCount());
			System.out.println(threadInfo.getBlockedTime());
			System.out.println(threadInfo.getWaitedCount());
			System.out.println(threadInfo.getWaitedTime());
		}
		Thread.currentThread().join();
	}

	public void demo1() {
		synchronized (lockA) {
			System.out.println("lock a acquired.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lockB) {
				System.out.println("lock b acquired.");
			}
		}
	}

	public void demo2() {
		synchronized (lockB) {
			System.out.println("lock b acquired.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lockA) {
				System.out.println("lock a acquired.");
			}
		}
	}

}
