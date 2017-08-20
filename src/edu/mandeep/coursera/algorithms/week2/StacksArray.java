/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

/**
 * task: implement stack using linkedlist to take a string and pop element whenever "-" is detected
 * input: "to be or not to - be - - that - - - is";
 * output: "to be not that or be"
 * @author mandeep
 *
 */
public class StacksArray {
	
	private String[] strArray;
	private int size = 0;
	
	public static void main(String[] args) {
		StacksArray theStack = new StacksArray();
		
		String str = "to be or not to - be - - that - - - is";
		theStack.strArray = new String[str.length()];
		String[] words = str.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			if (words[i].equals("-")) {
				// System.out.println("stack entry: "+theStack.peek());
				System.out.print(theStack.pop() + " ");
			} else
				theStack.push(words[i]);
		}
	}

	private void push(String string) {
		strArray[size++] = string;
	}

	private String pop() {
		String item = strArray[--size];
		strArray[size] = null;
		return item;
	}
}