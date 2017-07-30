package edu.mandeep.practice;

import java.util.Scanner;

public class PointInTriangle {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int xa = sc.nextInt();
		int ya = sc.nextInt();
		
		int xb = sc.nextInt();
		int yb = sc.nextInt();
		
		int xc = sc.nextInt();
		int yc = sc.nextInt();
		
		int xp = sc.nextInt();
		int yp = sc.nextInt();
		//area(a,b,p1) + area(b,c,p1)+ area(a,c,p1)
		int areaOfPoint = area(xa, ya, xb, yb, xp, yp) + area (xp, yp, xb, yb, xc, yc) 
						+ area(xa, ya, xp, yp, xc, yc);
		//System.out.println(areaOfPoint);
		int areaOfTriangle = area(xa, ya, xb, yb, xc, yc);
		//System.out.println(areaOfTriangle);
		if(areaOfPoint == areaOfTriangle)
			System.out.println("Point lies insiide triangle");
		else System.out.println("Point is outside the triangle");
	}
	
	private static int area(int xa, int ya, int xb, int yb, int xc, int yc){
		//double area = 0;
	/*
		int semiperimeter = (a + b + c)/2;
		area = Math.sqrt(semiperimeter * (semiperimeter-a) * (semiperimeter-b) * (semiperimeter-c));
	*/
		return (int) Math.abs(xa * (yb - yc) + xb * (yc - ya)+ xc * (ya - yb)/2.0);
		//return area;
	}
}