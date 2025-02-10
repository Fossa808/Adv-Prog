import java.util.*;

public class IteratorPractice {
	public static void main(String[] args) {
		Map<String, String> roster = new TreeMap<>();
		roster.put("Aang", "freshman");
		roster.put("Sokka", "senior");
		roster.put("Katara", "junior");
		roster.put("Toph Beifong", "junior");
		roster.put("Zuko", "senior");
		roster.put("Uncle Iroh", "sophomore");
		roster.put("Appa", "freshman");

		ArrayList<String> freshmen = new ArrayList<>();
		freshmen.add("Azula");
		freshmen.add("Suki");
		freshmen.add("Mai");
		freshmen.add("Ty Lee");

		System.out.println("Before: " + roster);
		updateRoster(roster, freshmen);
		System.out.println("After: " + roster);
	}

	/* YOUR METHOD GOES HERE */
	public static void updateRoster(Map<String,String> roster, ArrayList<String> freshmen){
		Iterator<String> temps = roster.keySet().iterator();
		while(temps.hasNext()){
			String name = temps.next();
			if (roster.get(name).equals("freshman")) {
				roster.put(name, "sophomore");
			}else if (roster.get(name).equals("sophomore")) {
				roster.put(name, "junior");
			}else if(roster.get(name).equals("junior")){
				roster.put(name, "senior");
			}else{
				temps.remove();
			}
		}

		int size = freshmen.size();
		for(int i = 0; i < size; i++){
			roster.put(freshmen.get(i), "freshman");
		}
	}

}