/**
 * 
 */
package edu.mandeep.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author mandeep
 *
 */
public class InformationMasking {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while( (line = br.readLine()) != null && !line.equals("exit")){
			String[] input = line.split(":");
			if(input[0].equals("P"))
				maskPhone(input[0], input[1]);
			if(input[0].equals("E"))
				maskEmail(input[0], input[1]);
		}	
	}
	
	private static void maskEmail(String token, String email){
		email = email.trim();
		StringBuilder sb = new StringBuilder();
		sb.append(token);
		String[] str = email.split("@");
		char[] ch = str[0].toCharArray();
		if(str[0].length() > 2){
			sb.append(ch[0]);
			for(int i = 1; i < ch.length - 1; i++)
				sb.append("*");
			
			sb.append(ch[ch.length - 1] + "@" + str[1]);
		}else{
			sb.append(email);
		}
		
		System.out.println(sb.toString());
	}
	
	private static void maskPhone(String token, String phone){
		phone = phone.trim();
		StringBuilder sb = new StringBuilder();
		sb.append(token);
		char[] ch = phone.toCharArray();
		
		for(int i = 0; i < ch.length - 4; i++){
			if(ch[i] == '+' || ch[i] == '-' || ch[i] == '(' || ch[i] == ')')
				sb.append(ch[i]);
			else if(ch[i] == ' ')
				sb.append("");
			else
				sb.append("*");
		}
		for(int i = ch.length - 4 ; i < ch.length; i++)
			sb.append(ch[i]);
		
		System.out.println(sb.toString());
	}
}