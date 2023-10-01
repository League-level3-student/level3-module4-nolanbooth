package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<String> theStack = new Stack<String>();
		
	for(int i = 0; i < b.length(); i++) {
			String temp = "" + b.charAt(i);
			System.out.println(b);
			if(temp.equalsIgnoreCase("{")) {
				theStack.push("open");
			}else {
				if(theStack.size() ==0) {
					return false;
				}else {
					theStack.pop();
				}
			}
			
		}if(theStack.size()==0) {
			return true;
		}else {
			return false;
		}
	}
}