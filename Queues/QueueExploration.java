// Advanced Programming Topics
// WHS Computer Science - Jackson 2024-2025

// An exploration of how the Queue data structure works

import java.util.*; // Queues

public class QueueExploration {
	public static void main(String[] args) {
		/** YOUR CODE GOES HERE **/
		Queue<Integer> nums = new LinkedList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		printQueue(nums);
		nums.remove();
		printQueue(nums);
		System.out.println("    " + nums.peek());
		printQueue(nums);
		while (!nums.isEmpty()) {
			nums.remove();
		}
		System.out.println(nums.size());

		//nums.remove();

		System.out.println("print first num: " + nums.peek());
	}
	
	// Prints the contents of the given queue from front to back
	// to the console
	private static void printQueue(Queue<Integer> queue) {
		if (queue == null) {
			throw new IllegalArgumentException("Queue must not be null.");
		} else if (queue.isEmpty()) {
			System.out.print("empty queue");
		}
		
		System.out.print("front <-  ");
		
		// fencepost - print the first item
		int first = queue.remove();
		System.out.print(first);
		queue.add(first);
		
		// print the remaining items
		for (int i = 1; i < queue.size(); i++) {
			int value = queue.remove();
			System.out.print(",  " + value);
			queue.add(value);
		}
		
		System.out.print("  <- back");
	}
}
