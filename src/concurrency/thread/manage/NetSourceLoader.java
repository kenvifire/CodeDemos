package concurrency.thread.manage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetSourceLoader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Beginning data source loading:" + new Date());
		try {
			TimeUnit.SECONDS.sleep(6);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("endning data source loading:" + new Date());
	}

}
