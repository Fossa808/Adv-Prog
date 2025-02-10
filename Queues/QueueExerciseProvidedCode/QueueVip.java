import java.util.*;

//This class tests various cases of prioritization of VIPs 
//in a queue of PartyPersons.
//Using the prioritizeVips method, VIPs are prioritized in the queues
//while maintaining the original order of normal people and VIPs
//The test cases test whether this method works for multiple cases

//EXTRA CREDIT DONE: Prioritizes Owners and then VIPs
public class QueueVip {
	public static void main(String[] args) {
		testBasic();
		System.out.println();
		
		/*** REQUIRED: YOUR TESTS GO HERE ***/
		testBasicEmpty();
		System.out.println();

		testBasicNoVIPS();
		System.out.println();

		testBasicAllVIPS();
		System.out.println();

		// Extra Credit
		testBasicWithOwner();
		System.out.println();
	}
	
    //Prioritizes the VIPs in the Queue, while 
	//keeping the orginal order of people
	public static void prioritizeVips(Queue<PartyPerson> clubList) {
		/*** YOUR CODE GOES HERE ***/
		if (clubList == null) {
			throw new IllegalArgumentException("CANNOT INPUT NULL QUEUE!!!");
		}

		Queue<PartyPerson> normalPeople = new LinkedList<>();
		int clubSize = clubList.size();

		for (int i = 0; i < clubSize; i++){
			if (clubList.peek().getStatus().equals("VIP")) {
				clubList.add(clubList.remove());
			}else{
				normalPeople.add(clubList.remove());
			}
		}

		while (!normalPeople.isEmpty()) {
			clubList.add(normalPeople.remove());
		}
	}
	
	//Prioritizes Owners first, then VIPs and finally other party people
	//while keeping the original order
	//Uses prioritizesVIPs() initially to order the queue
	public static void prioritizeVipsPlus(Queue<PartyPerson> clubList){
		prioritizeVips(clubList);

		int size = clubList.size();
		Queue<PartyPerson> nonOwners = new LinkedList<>();

		for(int i = 0; i < size; i++){
			if (clubList.peek().getStatus().equals("OWNER")) {
				clubList.add(clubList.remove());
			}else{
				nonOwners.add(clubList.remove());
			}
		}

		while (!nonOwners.isEmpty()) {
			clubList.add(nonOwners.remove());
		}

	}
	// "Mario (VIP)", "Koopa Troopa", "Bowser (VIP)", "Goomba", "Captain Toad (VIP)"
	public static void testBasic() {
		// testing your code
		Queue<PartyPerson> people = new LinkedList<>();
		people.add(new PartyPerson("Mario", "VIP"));
		people.add(new PartyPerson("Koopa Troopa"));
		people.add(new PartyPerson("Bowser", "VIP"));
		people.add(new PartyPerson("Goomba"));
		people.add(new PartyPerson("Captain Toad", "VIP"));
		
		// actual answer
		Queue<PartyPerson> peopleExpected = new LinkedList<>();
		peopleExpected.add(new PartyPerson("Mario", "VIP"));
		peopleExpected.add(new PartyPerson("Bowser", "VIP"));
		peopleExpected.add(new PartyPerson("Captain Toad", "VIP"));
		peopleExpected.add(new PartyPerson("Koopa Troopa"));
		peopleExpected.add(new PartyPerson("Goomba"));
		
		prioritizeVips(people);
		
		// check if your code (actual) matches the answer (expected)
		System.out.println("Test Basic");
		System.out.println("  Actual:   " + queueToString(people));
		System.out.println("  Expected: " + queueToString(peopleExpected));
	}

	// Empty Queue: SHOULD PRINT "Empty Queue" 
	public static void testBasicEmpty() {
		// testing your code
		Queue<PartyPerson> people = new LinkedList<>();
		
		// actual answer
		Queue<PartyPerson> peopleExpected = new LinkedList<>();
		
		prioritizeVips(people);
		
		// check if your code (actual) matches the answer (expected)
		System.out.println("Test Basic Empty");
		System.out.println("  Actual:   " + queueToString(people));
		System.out.println("  Expected: " + queueToString(peopleExpected));
	}

	// "Mario", "Koopa Troopa", "Bowser", "Goomba", "Captain Toad"
	public static void testBasicNoVIPS() {
		// testing your code
		Queue<PartyPerson> people = new LinkedList<>();
		people.add(new PartyPerson("Mario"));
		people.add(new PartyPerson("Koopa Troopa"));
		people.add(new PartyPerson("Bowser"));
		people.add(new PartyPerson("Goomba"));
		people.add(new PartyPerson("Captain Toad"));
		
		// actual answer
		Queue<PartyPerson> peopleExpected = new LinkedList<>();
		peopleExpected.add(new PartyPerson("Mario"));
		peopleExpected.add(new PartyPerson("Koopa Troopa"));
		peopleExpected.add(new PartyPerson("Bowser"));
		peopleExpected.add(new PartyPerson("Goomba"));
		peopleExpected.add(new PartyPerson("Captain Toad"));

		prioritizeVips(people);
		
		// check if your code (actual) matches the answer (expected)
		System.out.println("Test Basic");
		System.out.println("  Actual:   " + queueToString(people));
		System.out.println("  Expected: " + queueToString(peopleExpected));
	}

	public static void testBasicAllVIPS() {
		// testing your code
		Queue<PartyPerson> people = new LinkedList<>();
		people.add(new PartyPerson("Mario", "VIP"));
		people.add(new PartyPerson("Koopa Troopa", "VIP"));
		people.add(new PartyPerson("Bowser", "VIP"));
		people.add(new PartyPerson("Goomba", "VIP"));
		people.add(new PartyPerson("Captain Toad", "VIP"));
		
		// actual answer
		Queue<PartyPerson> peopleExpected = new LinkedList<>();
		peopleExpected.add(new PartyPerson("Mario", "VIP"));
		peopleExpected.add(new PartyPerson("Koopa Troopa", "VIP"));
		peopleExpected.add(new PartyPerson("Bowser", "VIP"));
		peopleExpected.add(new PartyPerson("Goomba", "VIP"));
		peopleExpected.add(new PartyPerson("Captain Toad", "VIP"));

		prioritizeVips(people);
		
		// check if your code (actual) matches the answer (expected)
		System.out.println("Test Basic all VIPs");
		System.out.println("  Actual:   " + queueToString(people));
		System.out.println("  Expected: " + queueToString(peopleExpected));
	}
	
	// EXTRA CREDIT ONLY
	// "Mario (VIP)", "Koopa Troopa", "Bowser (VIP)", "Rosalina (Owner)", "Goomba", "Captain Toad (VIP)"
	public static void testBasicWithOwner() {
		// testing your code
		Queue<PartyPerson> people = new LinkedList<>();
		people.add(new PartyPerson("Mario", "VIP"));
		people.add(new PartyPerson("Koopa Troopa"));
		people.add(new PartyPerson("Bowser", "VIP"));
		people.add(new PartyPerson("Rosalina", "OWNER"));
		people.add(new PartyPerson("Goomba"));
		people.add(new PartyPerson("Captain Toad", "VIP"));
		
		// actual answer
		Queue<PartyPerson> peopleExpected = new LinkedList<>();
		peopleExpected.add(new PartyPerson("Rosalina", "OWNER"));
		peopleExpected.add(new PartyPerson("Mario", "VIP"));
		peopleExpected.add(new PartyPerson("Bowser", "VIP"));
		peopleExpected.add(new PartyPerson("Captain Toad", "VIP"));
		peopleExpected.add(new PartyPerson("Koopa Troopa"));
		peopleExpected.add(new PartyPerson("Goomba"));
		
		prioritizeVipsPlus(people);
		
		// check if your code (actual) matches the answer (expected)
		System.out.println("Test Basic with Owner");
		System.out.println("  Expected: " + queueToString(peopleExpected));
		System.out.println("  Actual:   " + queueToString(people));
	}
	
	
	// Returns a String representation of the given queue from front to back
	// e.g.) front <-  "Mario (VIP)", "Bowser (VIP)", "Koopa Troopa", "Goomba" <- back
	public static String queueToString(Queue<PartyPerson> queue) {
		if (queue == null) {
			return "Null queue";
		}else if(queue.isEmpty()){
			return "Empty queue";
		}

		String s = "front <-  ";
		
		// fencepost - print the first item
		PartyPerson first = queue.remove();
		s += "\"" + first + "\"";
		queue.add(first);
		
		// print the remaining items
		for (int i = 1; i < queue.size(); i++) {
			PartyPerson person = queue.remove();
			s += ",  \"" + person + "\"";
			queue.add(person);
		}
		
		s += "  <- back";
		
		return s;
	}
}