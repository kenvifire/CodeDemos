/**
 * 2013-1-12
 * Videoconference.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author kenvi
 * 
 */
public class Videoconference implements Runnable {
	private final CountDownLatch controller;

	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}

	public void arrive(String name) {
		System.out.println(name + " has arrived");
		controller.countDown();
		System.out.println("VideoConference :Waiting for "
				+ controller.getCount() + " participants");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			controller.await();
			System.out
					.println("VideoCOnference:All the participants have come");
			System.out.println("VideoConference : Let's start...");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
