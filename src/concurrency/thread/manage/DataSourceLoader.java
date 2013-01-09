package concurrency.thread.manage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		System.out.println("Beginning data source loading:" + new Date());
		try {
			TimeUnit.SECONDS.sleep(4);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("endning data source loading:" + new Date());

	}
}
