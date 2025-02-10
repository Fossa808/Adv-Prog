import java.util.*;

//Adv. Prog. version of Rotten Tomatoes
public class RottenPotatoes {
    //5 Movies to rate
    public static final String MOVIE1 = "3 Idiots";
    public static final String MOVIE2 = "Chennai Express";
    public static final String MOVIE3 = "Bahubali";
    public static final String MOVIE4 = "RRR";
    public static final String MOVIE5 = "Premam";

    //Main method
    public static void main(String[] args) {
        //Print welcome statement
        System.out.println("Welcome to Rotten Potatoes! \n Please rate the following: ");

        //get userInput using scanner and save in the 'ratings' array
        int[] ratings = new int[5];
        Scanner console = new Scanner(System.in);
        System.out.print(MOVIE1 + "? ");
        ratings[0] = console.nextInt();
        System.out.print(MOVIE2 + "? ");
        ratings[1] = console.nextInt();
        System.out.print(MOVIE3 + "? ");
        ratings[2] = console.nextInt();
        System.out.print(MOVIE4 + "? ");
        ratings[3] = console.nextInt();
        System.out.print(MOVIE5 + "? ");
        ratings[4] = console.nextInt();
        console.close();

        //check the ratings
        checkRatings(ratings);

        //Print Ratings as an ordered list
        System.out.println();
        printRatings(ratings);

        //Compare the ratings and print according to highest and lowest rating
        System.out.println();
        compareRates(ratings);
        //Print the average rating
        System.out.println("Average rating: " + calcAvg(ratings));
    }

    //Print movies as an ordered list with the ratings
    public static void printRatings(int[] ratings){
        System.out.printf("1. %s: %d\n", MOVIE1, ratings[0]);
        System.out.printf("2. %s: %d\n", MOVIE2, ratings[1]);
        System.out.printf("3. %s: %d\n", MOVIE3, ratings[2]);
        System.out.printf("4. %s: %d\n", MOVIE4, ratings[3]);
        System.out.printf("5. %s: %d\n", MOVIE5, ratings[4]);
    }

    //compare ratings of movies and find the highest and lowest rated Movies
    public static void compareRates(int[] ratings){
        int largenum = 0;
        int smallnum = 10;
        //Finds lowest and highest rated movies
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] > largenum){
                largenum = ratings[i];
            }
            if (ratings[i] < smallnum){
                smallnum = ratings[i];
            }
        }
        //Prints highest rated movies
        System.out.print("Highest-rated Movie(s): ");
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == largenum) {
                findMovie(i);
                System.out.print(" (" + ratings[i] + ") ");
            }
        }
        //Prints lowest rated movies
        System.out.print("\nLowest rated Movie(s): ");
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == smallnum) {
                findMovie(i);
                System.out.print(" (" + ratings[i] + ") ");
            }
        }
        System.out.println();
    }

    // Finds which movie is being called based on the index of the rating array
    public static void findMovie(int rateIndex){
        if (rateIndex == 0){
            System.out.print(MOVIE1);
        }else if (rateIndex == 1) {
            System.out.print(MOVIE2);  
        }else if (rateIndex == 2) {
            System.out.print(MOVIE3);  
        }else if (rateIndex == 3) {
            System.out.print(MOVIE4);  
        }else if (rateIndex == 4) {
            System.out.print(MOVIE5);  
        }
    }

    //calculate the average of the ratings
    public static double calcAvg(int[] ratings){
        double sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += ratings[i];
        }
        double avg = Math.round((sum/ratings.length) * 10) / 10.0;
        return avg;
    }

    //Checks if rating is valid (between 1 and 10)
    public static void checkRatings(int[] ratings){
        for (int i = 0; i < ratings.length; i++) {
            if(ratings[i] > 10 || ratings[i] < 0){
                throw new IllegalArgumentException("Not a valid Input!!!");
            }
        }
    }
}
