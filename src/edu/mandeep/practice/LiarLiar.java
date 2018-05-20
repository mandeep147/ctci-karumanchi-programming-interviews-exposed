/**
 * 
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class LiarLiar {
	static char[][] arr = {{'T','T'}, {'L','L'}};
	static int n = arr.length;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		liars(arr);
	}
	
	public static void liars(char[][] arr){
//		int n = arr.length-1;
		int low = (int)1e9, high = (int)1e9;
		for(int i = 0; i < arr.length; i++){
			if(!ok(i))
				continue;
			int liars = 0;
			for(int j = 0; j < arr.length; j++)
				if(arr[i][j] == 'L')
					liars++;
			low = Math.min(low, liars);
			high = Math.max(high, liars);
		}
		
		for(int i = 0; i < arr.length; i++)
			arr[arr.length-1][i] = 'L';
		if(ok(arr.length-1)){
			low = Math.min(low, arr.length);
			high = Math.max(high, arr.length);
		}
		
		if(low != Integer.MAX_VALUE){
			System.out.println("atleast: "+low+"atmost: "+high);
		}else
			System.out.println("paradoxical");
	}

	/**
	 * @param i
	 * @return
	 */
	private static boolean ok(int i) {
		for(int j = 0; j < n; j++){
			boolean lie = false;
			for(int k = 0; k < n; k++){
				if(arr[j][k] != arr[i][k]){
					lie = true;
					break;
				}
			}
			
			if(arr[i][j] == 'T' && lie)
				return false;
			if(arr[i][j] == 'L' && !lie)
				return false;
		}
		return true;
	}

}
