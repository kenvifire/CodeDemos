/**
 * 2013-1-12
 * FileSearch.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author kenvi
 * 
 */
public class FileSearch implements Runnable {

	private String initPath;
	private String end;

	private List<String> results;

	private Phaser phaser;

	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<>();
	}

	private void directoryProcess(File file) {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);

				} else {
					fileProcess(list[i]);
				}

			}
		}
	}

	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}

	private void filterResults() {
		List<String> newResult = new ArrayList<>();
		long actualDate = new Date().getTime();

		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			if (actualDate - fileDate < TimeUnit.MICROSECONDS.convert(1,
					TimeUnit.DAYS)) {
				newResult.add(results.get(i));
			}
			results = newResult;
		}
	}

	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.printf("%s:Pahse %d:0 results.\n", Thread
					.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s:Phase %d:End.\n", Thread.currentThread()
					.getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.printf("%s:Phase %d: %d results.\n", Thread
					.currentThread().getName(), phaser.getPhase(), results
					.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}

	private void showInfo() {
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			System.out.printf("%s:%s#n", Thread.currentThread().getName(),
					file.getAbsoluteFile());
		}
		phaser.arriveAndAwaitAdvance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s:Starting ..\n", Thread.currentThread().getName());

		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		}
		if (!checkResults()) {
			return;
		}

		filterResults();

		showInfo();
		phaser.arriveAndDeregister();

		System.out.printf("%s:Work completed.\n", Thread.currentThread()
				.getName());
	}
}
