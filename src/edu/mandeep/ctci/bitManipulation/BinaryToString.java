/**
 * Problem 5.2: Binary to String
 * given real no between 0 and 1, passed as a double, print binary represntation
 * if not possible, print ERROR
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class BinaryToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("============== \n");
		double num = 0.725;
		System.out.println(num);
		System.out.println(toBinary(num));
		System.out.println(printBinary(num));
		System.out.println("============== \n");
		
		num = 0.625;
		System.out.println(num);
		System.out.println(toBinary(num));
		System.out.println(printBinary(num));
		System.out.println("============== \n");
		
		num = 0.72;
		System.out.println(num);
		System.out.println(toBinary(num));
		System.out.println(printBinary(num));
		System.out.println("============== \n");
	}
	//=======================Method-1===============================//
	private static String toBinary(double num){
		if(num >= 1 || num <= 0)
			return "ERROR";
		
		StringBuilder binary = new StringBuilder();
		binary.append("0.");
		
		while(num > 0){
			if(binary.length() >= 32)
				return "ERROR";
			
			double r = num * 2;
			
			if( r >= 1){
				binary.append(1);
				num = r - 1;
			}else{
				binary.append(0);
				num = r;
			}
		}
		
		return binary.toString();
	}
	//=======================Method-1===============================//
	//instead of multiplying by 2 and comparing it by 1, we can compare number by 0.5, 0.25 and so on
	private static String printBinary(double num){
		if(num >= 1 || num <= 0)
			return "ERROR";
		
		StringBuilder binary = new StringBuilder();
		binary.append("0.");
		double r = 0.5;
		while(num > 0){
			if(binary.length() >= 32)
				return "ERROR";
			
			if(num >= r){
				binary.append(1);
				num -= r;
			}else
				binary.append(0);
			
			r /= 2;
		}
		return binary.toString();
	}
}