// A simple test class meant to check the basic state/behavior of
// the Movie class.

public class MovieTestClient {
	public static void main(String[] args) {
		Movie nemo = new Movie("Finding Nemo", 100, "Andrew Stanton", 2003);

		// Getters
		System.out.println("***BEGIN TESTS***");


		System.out.println("---TESTING GETTERS---");
		System.out.println(nemo);
		System.out.println("Title: " + nemo.getTitle());
		System.out.println("Duration: " + nemo.getDuration());
		System.out.println("Director: " + nemo.getDirector());
		System.out.println("Year: " + nemo.getYear());
		System.out.println("Watched? " + nemo.beenWatched());
		System.out.println();

		boolean isMatch = nemo.isMatch("Finding Dory", 97, "Andrew Stanton", 2016);
		System.out.println("Nemo = Dory? " + isMatch);
		System.out.println();
		System.out.println();

		// Setters
		System.out.println("---TESTING SETTERS---");
		nemo.setTitle("Finding Dory");
		System.out.println("Title: " + nemo.getTitle());
		nemo.setDuration(97);
		System.out.println("Duration: " + nemo.getDuration());
		System.out.println("Director: " + nemo.getDirector());
		nemo.setYear(2016);
		System.out.println("Year: " + nemo.getYear());
		System.out.println();

		nemo.watch();
		System.out.println("Watched? " + nemo.beenWatched());
		System.out.println();

		isMatch = nemo.isMatch("Finding Dory", 97, "Andrew Stanton", 2016);
		System.out.println("Dory = Dory? " + isMatch);

		System.out.println("***END OF TESTS***");
	}
}