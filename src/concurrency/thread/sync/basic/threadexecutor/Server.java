/**
 * 2013-1-15
 * Server.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kenvi
 * 
 */
public class Server {
	private ThreadPoolExecutor executor;

	public Server() {
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	public void executeTask(Task task) {
		System.out.println("Server:A new task has arrived.");
		executor.execute(task);
		System.out.println("Server: Pool Size:" + executor.getPoolSize());
		System.out
				.println("Server: Active Count :" + executor.getActiveCount());
		System.out.println("Server: Completed Task: :"
				+ executor.getCompletedTaskCount());

	}

	public void endTask() {
		executor.shutdown();
	}
}
