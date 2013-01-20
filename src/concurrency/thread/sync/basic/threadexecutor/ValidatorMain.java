/**
 * 2013-1-20
 * ValidatorMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kenvi
 * 
 */
public class ValidatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String username = "test";
		String password = "test";

		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DB");

		TaskValidator ldapTaskValidator = new TaskValidator(ldapValidator,
				username, password);
		TaskValidator dbTaskValidator = new TaskValidator(dbValidator,
				username, password);
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTaskValidator);
		taskList.add(dbTaskValidator);

		ExecutorService executor = Executors.newCachedThreadPool();
		String result;

		try {
			result = executor.invokeAny(taskList);
			System.out.println("Main:result " + result);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("Main ended");

	}
}
