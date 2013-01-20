/**
 * 2013-1-20
 * TaskValidator.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.concurrent.Callable;

/**
 * @author kenvi
 * 
 */
public class TaskValidator implements Callable<String> {
	private UserValidator validator;

	private String user;
	private String password;

	public TaskValidator(UserValidator validator, String user, String password) {
		this.validator = validator;
		this.user = user;
		this.password = password;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		if (!validator.validate(user, password)) {
			System.out.println(user + ":the user has not been found!");
			throw new Exception("Error validating user");
		} else {
			System.out.println(user + ":the user has not been found!");
			return validator.getName();
		}
	}

}
