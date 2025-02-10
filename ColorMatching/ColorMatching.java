// Name: Jyotsna Jayasuryan
// Period: 2
// Date: 10/14/2024

// This class implements a method called countSame which compares two
// Stacks of Crayons that returns true if both stacks contain the same
// number of Crayons and all the Crayons have matching hex colors in the
// same order. Otherwise, the method returns false.
// The stacks are unchanged after the method is called.

import java.util.*;

public class ColorMatching {
	public static void main(String[] args) {
		// Test two identical stacks
		if (testAllSame() == true) {
			System.out.println("Test all same: PASSED");
		} else {
			System.out.println("Test all same: FAILED");
		}

		// Test two completely different stacks
		if (testAllDifferent() == false) {
			System.out.println("Test all different: PASSED");
		} else {
			System.out.println("Test all different: FAILED");
		}

		// Test two stacks of the different size
		if (testDifferentSize() == false) {
			System.out.println("Test different size: PASSED");
		} else {
			System.out.println("Test different size: FAILED");
		}

		// Test two stacks of the different name
		if (testDifferentName() == false) {
			System.out.println("Test different name: PASSED");
		} else {
			System.out.println("Test different name: FAILED");
		}

		// Test two empty stacks
		if (testEmptyStack() == true) {
			System.out.println("Test empty stacks: PASSED");
		} else {
			System.out.println("Test empty stacks: FAILED");
		}

		// Test two stack where one is null
		testNullStack();
	}

	/** countSame METHOD GOES HERE **/

	//compares two stacks to check if they are the same
	public static boolean countSame(Stack<Crayon> s1, Stack<Crayon> s2){
		if(s1 == null || s2 == null){
			throw new IllegalArgumentException("CANNOT COMPARE NULL STACK!!!");
		}
		int s1Size = s1.size();
		int s2Size = s2.size();
		if (s1Size!= s2Size) {
			return false;			
		}
		Stack<Crayon> temp = new Stack<>();
		for(int i = 0; i < s1Size; i++){
			if (s1.peek().getName() != s2.peek().getName()) {
				pushStackFalse(s1, s2, temp);
				return false;
			}
			else if (s1.peek().getHexColor() != s2.peek().getHexColor()) {
				pushStackFalse(s1, s2, temp);
				return false;
			}else{
				temp.push(s1.pop());
				s2.pop();
			}
		}
		while(!temp.isEmpty()){
			s1.push(temp.peek());
			s2.push(temp.pop());
		}
		return true;
	}

	//If two stacks aren't the same, push stack values back into original
	public static void pushStackFalse(Stack<Crayon> s1, Stack<Crayon> s2, Stack<Crayon> temp){
		int tempSize = temp.size();
		for (int j = 0; j < tempSize; j++) {
			s1.push(temp.peek());
			s2.push(temp.pop());
		}
	}

	// Prints a String representation of a stack, clarifying where
	// the top and bottom are
	// e.g.) "bottom [3, 2, 1] top"
	public static void printStack(Stack<Crayon> s) {
		System.out.print("bottom ");
		System.out.print(s);
		System.out.println(" top");
	}

	// Returns whether or not a call to countSame with two Stacks with identical
	// Crayon objects returns true (Should be TRUE)
	public static boolean testAllSame() {
		Crayon inchworm = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s1 = new Stack<>();
		s1.push(inchworm);
		s1.push(flamingo);
		s1.push(sunglow);
		// printStack(s1);

		Crayon inchworm2 = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo2 = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow2 = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s2 = new Stack<>();
		s2.push(inchworm2);
		s2.push(flamingo2);
		s2.push(sunglow2);
		// printStack(s2);

		return countSame(s1, s2);
	}

	// Returns whether or not a call to countSame with two Stacks with all different
	// Crayon objects returns true (Should be FALSE)
	public static boolean testAllDifferent() {
		Crayon inchworm = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s1 = new Stack<>();
		s1.push(inchworm);
		s1.push(flamingo);
		s1.push(sunglow);
		// printStack(s1);

		Crayon banana = new Crayon("banana mania", "#FAE7B5");
		Crayon razzmatazz = new Crayon("razzmatazz", "#E3256B");
		Crayon tumbleweed = new Crayon("tumbleweed", "#DEAA88");
		
		Stack<Crayon> s2 = new Stack<>();
		s2.push(banana);
		s2.push(razzmatazz);
		s2.push(tumbleweed);
		// printStack(s2);

		return countSame(s1, s2);
	}

	// Returns whether or not a call to countSame with two Stacks
	// of different sizesCrayon objects returns true (Should be FALSE)
	public static boolean testDifferentSize(){
		Crayon inchworm = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow = new Crayon("sunglow", "#FFCF48");
		Crayon redpink = new Crayon("redpink", "#f50298");
		
		Stack<Crayon> s1 = new Stack<>();
		s1.push(inchworm);
		s1.push(flamingo);
		s1.push(sunglow);
		s1.push(redpink);
		// printStack(s1);

		Crayon inchworm2 = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo2 = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow2 = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s2 = new Stack<>();
		s2.push(inchworm2);
		s2.push(flamingo2);
		s2.push(sunglow2);
		// printStack(s2);

		return countSame(s1, s2);
	}

	// Returns whether or not a call to countSame with two null Stacks without
	// Crayon objects returns true (Should be FALSE)
	public static boolean testNullStack() {
		Stack<Crayon> s1 = null;

		Crayon inchworm = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s2 = new Stack<>();
		s2.push(inchworm);
		s2.push(flamingo);
		s2.push(sunglow);
		// printStack(s2);

		return countSame(s1, s2);
	}

	// Returns whether or not a call to countSame with two Stacks with same
	// Crayon objects, but different name returns true (Should be FALSE)
	public static boolean testDifferentName(){
		Crayon inchworm = new Crayon("inchworm", "#B2EC5D");
		Crayon flamingo = new Crayon("pink flamingo", "#FC74FD");
		Crayon sunglow = new Crayon("sunglow", "#FFCF48");
		
		Stack<Crayon> s1 = new Stack<>();
		s1.push(inchworm);
		s1.push(flamingo);
		s1.push(sunglow);
		// printStack(s1);

		Crayon inchworm2 = new Crayon("inchworm2", "#B2EC5D");
		Crayon flamingo2 = new Crayon("pink flamingo2", "#FC74FD");
		Crayon sunglow2 = new Crayon("sunglow2", "#FFCF48");
		
		Stack<Crayon> s2 = new Stack<>();
		s2.push(inchworm2);
		s2.push(flamingo2);
		s2.push(sunglow2);
		// printStack(s2);

		return countSame(s1, s2);
	}

	public static boolean testEmptyStack() {
		Stack<Crayon> s1 = new Stack<>();
		
		Stack<Crayon> s2 = new Stack<>();
		// printStack(s2);

		return countSame(s1, s2);
	}
}