package edu.mandeep.practice;

import java.util.Scanner;

public class CubeSolution {
	public static void  main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int a3, b3, c3, d3;
				
		for( int a = 1; a <= n; a++){
			a3 = (int) Math.pow(a, 3);
			if(a3 > n)
				break;
			for(int b = a; b <= n; b++){
				b3 = (int) Math.pow(b, 3);
				if( (a3 + b3) > n)
					break;
				for(int c = a+1; c <= n; c++){
					c3 = (int) Math.pow(c, 3);
					if(c3 > (a3 + b3))
						break;
					for(int d = c; d <= n; d++){
						d3 = (int) Math.pow(d, 3);
						if((d3 + c3) > (a3 + b3))
							break;
						
						if((a3 + b3) == (c3 + d3)){
							System.out.println((a3 + b3) + "=" + a + "^3 + "
									+ b + "^3=" +c+"^3 + " + d+ "^3");							
						}
					}
				}
			}
		}
	}
}
