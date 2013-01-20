/**
 * 2013-1-20
 * UserValidator.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.threadexecutor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author kenvi
 * 
 */
public class UserValidator {

	private String name;

	public UserValidator(String name) {
		this.name = name;
	}

	boolean validate(String name, String password) {
		Random random = new Random();
		try {
			long duration = (long) Math.random() * 10;
			System.out.println("validating user:" + this.name + " using "
					+ duration + "seconds");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			return false;
		}
		return random.nextBoolean();
	}

	public String getName() {
		return this.name;
	}
}
