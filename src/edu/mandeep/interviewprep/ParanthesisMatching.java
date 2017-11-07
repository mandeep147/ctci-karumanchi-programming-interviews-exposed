/**
 * Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.
 */
package edu.mandeep.interviewprep;

/**
 * @author mandeep
 *
 */
public class ParanthesisMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		int openIndex = 28;
		System.out.println(countEndingParanthesis(input, openIndex));
	}

	/**
	 * @param input
	 * @param openIndex
	 * @return
	 */
	private static int countEndingParanthesis(String input, int openIndex) {
		int openNestedParathesis = 0;
		for(int i = openIndex + 1; i < input.length(); i++){
			char ch = input.charAt(i);
			
			if(ch == '(')
				openNestedParathesis++;
			else if (ch == ')'){
				if(openNestedParathesis == 0)
					return i;
				else
					openNestedParathesis--;
			}
		}
		throw new IllegalArgumentException("No closing paranthesis");
	}

}