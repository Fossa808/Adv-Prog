// Name: Jyotsna Jayasuryan
// Period: 2

// Advanced Programming Topics (2024-2025)

// An exploration of how the Stack data structure works

import java.util.*; // Stacks

public class StackExploration {
	public static void main(String[] args) {
		/* YOUR CODE GOES HERE */
		Stack<Integer> numbers = new Stack<>();
		numbers.push(1);
		numbers.push(2);
		numbers.push(3);
		printStack(numbers);
		numbers.pop();
		printStack(numbers);
		System.out.println(numbers.peek());
		printStack(numbers);

		while (!numbers.isEmpty()) {
			numbers.pop();
		}
		System.out.println(numbers.size());
		numbers.pop();
		
	}
	
	// Prints the contents of the given stack from top to bottom
	// to the console
	private static void printStack(Stack<Integer> stack) {
		if (stack == null) {
			System.out.println("Stack is null.");
		} else if (stack.isEmpty()) {
			System.out.println("|       |");
			System.out.println("---------");
			System.out.println("Empty stack.");
		} else {
			// print the stack, load into back up
			System.out.println("top");
			
			Stack<Integer> backUp = new Stack<>();
			while (!stack.isEmpty()) {
				int value = stack.pop();
				System.out.println("|   " + value + "   |");
				backUp.push(value);
			}
			
			System.out.println("---------");
			System.out.println("bottom");
			
			// load back up into stack to restore
			while (!backUp.isEmpty()) {
				stack.push(backUp.pop());
			}
		}
	}
}