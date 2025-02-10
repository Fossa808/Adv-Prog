// A simple client class to test the TempTools assignment.

public class WeatherTracker {
	public static void main(String[] args) {
		TempTools temps = new TempTools('F');
		temps.addTemp(77.5);
		temps.addTemp(75.2);
		temps.addTemp(75.2);
		temps.addTemp(66.7);
		temps.addTemp(64.5);
		temps.addTemp(67.3);
		temps.addTemp(63.1);
		
		System.out.println(temps);
		
		System.out.println("Num Temps: " + temps.getTemps().size());
		System.out.println("Scale: " + temps.getScale());
		System.out.println("Low: " + temps.getLowest());
		System.out.println("High: " + temps.getHighest());
		System.out.println("Average: " + temps.getAverage());
		System.out.println();
		
		temps.removeTemp(75.2);
		System.out.println("Removed 75.2");
		System.out.println("Num Temps: " + temps.getTemps().size());
		System.out.println();
		
		temps.setScale('F');
		System.out.println("Set scale to F");
		System.out.println(temps);
		System.out.println();
		
		temps.setScale('C');
		System.out.println("Set scale to C");
		System.out.println(temps);
		System.out.println("Average: " + temps.getAverage());
	}
}
