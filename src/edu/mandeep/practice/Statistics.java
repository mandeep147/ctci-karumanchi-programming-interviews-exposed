/**
 * Calculate mean, median, mode, variance and standard deviation of given set of integers
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class Statistics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] arr = {3, 4, 4, 5, 6, 8};
		for(double item: arr)
			System.out.print(item+" ");
		System.out.println("\nMean is: "+ mean(arr));
		System.out.println("Median is: "+ median(arr));
		System.out.println("Mode is: "+mode(arr));
		System.out.println("Variance: "+variance(arr));
		System.out.println("Standard deviation: " + Math.pow(variance(arr), 0.5));
	}

	/**
	 * @param arr
	 * @return
	 */
	private static double variance(double[] arr) {
		double mean = mean(arr);
		double sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += Math.pow((arr[i] - mean), 2);
		}
		return sum/ arr.length;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static double mode(double[] arr) {
		double maxValue = 0, maxCount = 0;
		for(int i = 0; i < arr.length; i++){
			int count = 0;
			for(int j = 0; j < arr.length; j++)
				if(arr[j] == arr[i])
					++count;
			if(count > maxCount){
				maxCount = count;
				maxValue = arr[i];
			}
		}
			
		return maxValue;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static double median(double[] arr) {
		int mid = arr.length / 2;
		
		if(mid % 2 == 1)
			return arr[mid];
		else
			return (arr[mid]+arr[mid - 1]) / 2.0;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static double mean(double[] arr) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		double mean = sum / arr.length;
		return mean;
	}

}