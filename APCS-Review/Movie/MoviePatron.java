public class MoviePatron {

    // Five chosen movies
    public static final Movie mani = new Movie("Manichitrathazhu", 169 , "Fazil", 1993);
    public static final Movie hiNanna = new Movie("Hi Nanna!", 155, "Shouryuv", 2023);
    public static final Movie oso = new Movie("Om Shanti Oshana", 136, "Jude Anthany Joseph", 2014);
    public static final Movie abcd = new Movie("American Born Confused Desi", 167, "Martin Prakkat", 2013);
    public static final Movie cbi5 = new Movie("CBI 5", 164, "K. Madhu", 2022);
    public static void main(String[] args) {
        //Creating an array of movies
        Movie[] movies = {mani, hiNanna, oso, abcd, cbi5};
        //prints movies
        printMovies(movies);
        //prints latest release dates
        printLatestRelease(movies);

        //prints total binge time of all movies
        int totalTime = binge(movies);
        int totalHours = totalTime / 60;
        int totalMin = totalTime - (totalHours * 60);
        System.out.printf("Duration: %d hours and %d minutes\n",
                totalHours , totalMin);

        //turns favorite movies to watched
        movies[0].watch();
        movies[2].watch();
    }

    //prints movies
    public static void printMovies(Movie movies[]){
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }
    }

    //prints latest movie release dates
    public static void printLatestRelease(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i].getTitle() + " (" +movies[i].getYear() + ")");
        }
    }
    
    //Calculates total binge time
    public static int binge (Movie[] movies){
        int totalMin = 0;
        for (Movie movie : movies) {
            totalMin += movie.getDuration();
        }
        return totalMin;
    }
}
