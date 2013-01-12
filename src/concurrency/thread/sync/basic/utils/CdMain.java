/**
 * 2013-1-12
 * CdMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

/**
 * @author kenvi
 * 
 */
public class CdMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();

		for (int i = 0; i < 10; i++) {
			Participant p = new Participant(conference, "Participant:" + i);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
