/**
 * 
 */
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class SynchronizedString {
	List<String> list = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void addString(String str) {
		synchronized (this) {
			list.add(str);
		}
	}

	public List<String> getStrings() {
		synchronized (this) {
			return list;
		}
	}
}
