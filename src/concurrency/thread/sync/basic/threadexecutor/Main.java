/**
 * 2013-1-15
 * Main.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

/**
 * @author kenvi
 * 
 */
public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.endTask();
	}
}
