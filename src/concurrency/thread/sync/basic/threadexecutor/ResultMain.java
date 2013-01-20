/**
 * 2013-1-20
 * ResultMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author kenvi
 * 
 */
public class ResultMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<ResultTask> taskList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			ResultTask task = new ResultTask(i + "");
			taskList.add(task);
		}
		List<Future<Result>> resultList = null;

		try {
			resultList = executor.invokeAll(taskList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		executor.shutdown();
		System.out.println("Main:print the result");

		for (int i = 0; i < resultList.size(); i++) {
			Future<Result> future = resultList.get(i);
			try {
				Result result = future.get();
				System.out.println(result.getName() + ":" + result.getValue());

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
}
