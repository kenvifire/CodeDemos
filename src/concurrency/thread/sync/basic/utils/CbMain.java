/**
 * 2013-1-12
 * CbMain.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.concurrent.CyclicBarrier;

/**
 * @author kenvi
 * 
 */
public class CbMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;

		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);

		Results results = new Results(ROWS);

		Grouper grouper = new Grouper(results);

		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

		Searcher[] searchers = new Searcher[PARTICIPANTS];
		for (int i = 0; i < PARTICIPANTS; i++) {
			searchers[i] = new Searcher(i * LINES_PARTICIPANT,
					(i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock, results,
					5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}

		System.out.println("Maint:The main thread has finished.");
	}
}
