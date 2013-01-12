/**
 * 2013-1-12
 * Results.java
 * kenvi
 * mrwhite@163.com
 */
package concurrency.thread.sync.basic.utils;

/**
 * @author kenvi
 * 
 */
public class Results {

	private int data[];

	public Results(int size) {
		data = new int[size];
	}

	public void setData(int position, int value) {
		data[position] = value;
	}

	public int[] getData() {
		return data;
	}
}
