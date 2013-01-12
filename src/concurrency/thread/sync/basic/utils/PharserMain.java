/**
 * 2013-1-12
 * PharserMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.concurrent.Phaser;

/**
 * @author kenvi *
 */
public class PharserMain {
	/** * @param args */

	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch documents = new FileSearch("D:\\Documents And Settings",
				"log", phaser);
		Thread systemThread = new Thread(system, "System");
		systemThread.start();
		Thread appsThread = new Thread(apps, "Apps");
		appsThread.start();
		Thread documentThread = new Thread(documents, "Document");
		documentThread.start();
		try {
			systemThread.join();
			appsThread.join();
			documentThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Terminated:" + phaser.isTerminated());
	}
}
