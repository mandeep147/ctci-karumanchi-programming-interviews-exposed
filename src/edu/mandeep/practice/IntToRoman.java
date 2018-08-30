/**
 * 
 */
package edu.mandeep.practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mandeep
 *
 */
public class IntToRoman {
	private static String getRomanEquivalentOfInteger(int number) {
		if (number <= 0) {
			return "not defined";
		}

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

		String romanEqui = "";

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			if (number / key != 0) {
				for (int i = 0; i < (number / key); i++) {
					romanEqui = romanEqui + map.get(key);
				}
				number = number % key;
			}
		}
		return romanEqui;
	}

	public static void main(String[] args) {
		System.out.println(getRomanEquivalentOfInteger(399));
		System.out.println("12: " + IntegerToRoman(12));
		System.out.println("999: " + IntegerToRoman(999));
	}

	public static String IntegerToRoman(int n) {
		String roman = "";
		int repeat;

		repeat = n / 1000;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "M";
		}
		n = n % 1000;

		repeat = n / 900;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "CM";
		}
		n = n % 900;

		repeat = n / 500;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "D";
		}
		n = n % 500;

		repeat = n / 400;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "CD";
		}
		n = n % 400;

		repeat = n / 100;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "C";
		}
		n = n % 100;

		repeat = n / 90;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "XC";
		}
		n = n % 90;

		repeat = n / 50;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "L";
		}
		n = n % 50;

		repeat = n / 40;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "XL";
		}
		n = n % 40;

		repeat = n / 10;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "X";
		}
		n = n % 10;

		repeat = n / 9;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "IX";
		}
		n = n % 9;

		repeat = n / 5;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "V";
		}
		n = n % 5;

		repeat = n / 4;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "IV";
		}
		n = n % 4;

		repeat = n / 1; // or simply repeat=n or i<=n in the condition part of
						// the loop
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "I";
		}
		return roman;
	}
}
