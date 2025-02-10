import java.util.*;
import java.io.*;
public class AirQualityReport {
	// AQI max values for each category
	public static final int GOOD_MAX = 50;
	public static final int MODERATE_MAX = 100;
	public static final int SENSITIVE_MAX = 150;
	public static final int UNHEALTHY_MAX = 200;
	public static final int VERY_UNHEALTHY_MAX = 250;
	public static final int HAZARDOUS_MAX = 500;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//print the Intro using helper method
		printIntro();
		
		//open console scanner and aske user which city they want info about
		Scanner console = new Scanner(System.in);
		System.out.print("Which city would you like to see? ");
		String city = console.nextLine();
		console.close();
		
		// stats to track
		int good = 0;
		int moderate = 0;
		int sensitive = 0;
		int unhealthy = 0;
		int veryUnhealthy = 0;
		int hazardous = 0;
		
		// Print output
		System.out.println();
		System.out.println("Here is the data for " + city + ":");
		
		// Scans the file airquality2023.txt
		Scanner cities = new Scanner(new File("airquality2023.txt"));
		boolean foundCity = false;
		//Check if cities Scanner, basically the file has text after the cursor
		while(cities.hasNext()) {

			//traverses through the file to find the chosen city
			String infoOfCity = cities.nextLine();
			String cityName = infoOfCity.substring(0, infoOfCity.indexOf(":"));
			infoOfCity = infoOfCity.substring(infoOfCity.indexOf(":") + 1);
			// gets the numberData of the city after saving the city name in another variable
			Scanner numbers = new Scanner(infoOfCity);

			//traverses through the numbers if the city is equal to the chosen city
			if(cityName.equalsIgnoreCase(city)) {
				ArrayList<Integer> airnum = new ArrayList<Integer>();
				foundCity = true;
				//checks if there is another Integer after the cursor
				while(numbers.hasNextInt()){
					airnum.add(numbers.nextInt());
				}
				//compares the number to the maximum of each air quality
				// level and puts it in its level accordingly
				for(int i = 0; i < airnum.size(); i++){
					if (airnum.get(i) < GOOD_MAX){
						good++;
					}else if (airnum.get(i) < MODERATE_MAX){
						moderate++;
					}
					else if (airnum.get(i) < SENSITIVE_MAX){
						sensitive++;
					}
					else if (airnum.get(i) < UNHEALTHY_MAX){
						unhealthy++;
					}
					else if (airnum.get(i) < VERY_UNHEALTHY_MAX){
						veryUnhealthy++;
					}
					else if (airnum.get(i) < HAZARDOUS_MAX){
						hazardous++;
					}
				}
				//closes scanners and exits loop
				cities.close();
				numbers.close();
				break;
			}
			numbers.close();
		}

		//If city is in the list print details, else print city not found
		if(foundCity){
			printResults(good, moderate, sensitive, unhealthy, veryUnhealthy, hazardous);
		}else{
			System.out.println("City not found.");
		}
	}
	
	// Prints an intro message to the console, showing available cities
	public static void printIntro() {
		System.out.println("Welcome to the Air Quality Index Report 2023!");
		System.out.println("Available cities: Auburn, Bremerton, Lake Forest Park, Marysville,");
		System.out.println("\t\t  Seattle 10th & Weller, Seattle Duwamish, Seattle South Park,");
		System.out.println("\t\t  Tacoma South L, Tacoma Tideflats, Tukwila");
		System.out.println();
	}
	
	// Prints the total number of days that maxed out in each of the given AQI categories
	public static void printResults(int good, int moderate, int sensitive,
			                        int unhealthy, int veryUnhealthy, int hazardous) {
		System.out.println("Good: " + good);
		System.out.println("Moderate: " + moderate);
		System.out.println("Unhealthy for Sensitive Groups: " + sensitive);
		System.out.println("Unhealthy: " + unhealthy);
		System.out.println("Very Unhealthy: " + veryUnhealthy);
		System.out.println("Hazardous: " + hazardous);
	}
}


