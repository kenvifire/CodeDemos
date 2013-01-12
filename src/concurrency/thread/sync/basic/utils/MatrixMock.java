/**
 * 2013-1-12
 * MatrixMock.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

import java.util.Random;

/**
 * @author kenvi
 * 
 */
public class MatrixMock {
	private int data[][];

	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < length; j++) {
				data[i][j] = random.nextInt(10);
				if (data[i][j] == number) {
					counter++;
				}
			}
		}
		System.out.println("Mock : There are " + counter
				+ " conferences in generaterd data.");

	}

	public int[] getRow(int row) {
		if ((row >= 0) && (row < data.length)) {
			return data[row];
		}
		return null;
	}

}
