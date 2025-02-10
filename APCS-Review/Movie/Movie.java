public class Movie {
    /***FIELDS***/
    private String title;
    private int duration;
    private String director;
    private int year;
    private boolean watched;
    
    /***BEHAVIOR***/
    public Movie(String title, int duration, String director, int year){
        if(title == null || title == "" || duration < 0 || 
            director == null || director == "" || year < 1878){
                throw new IllegalArgumentException("Invalid input!!!");
            }
            this.title = title;
            this.duration = duration;
            this.director = director;
            this.year = year;
    }

    /***GETTERS***/
    public String getTitle(){
        return this.title;
    }
    public int getDuration(){
        return this.duration;
    }
    public String getDirector(){
        return this.director;
    }
    public int getYear(){
        return this.year;
    }

    /***SETTERS***/
    public void setTitle(String title){
        if (title == null || title.equalsIgnoreCase("")) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }
    public void setDuration(int duration){
        if (duration < 0) {
            throw new IllegalArgumentException();
        }
        this.duration = duration;
    }
    public void setDirector(String director){
        if (director == null || director.equalsIgnoreCase("")) {
            throw new IllegalArgumentException();
        }
        this.director = director;
    }
    public void setYear(int year){
        if (year < 0) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    /*Helper Methods*/
    //checks if movie has been watch
    public boolean beenWatched(){
        if(watched){
            return true;
        }else{
            return false;
        }
    }
    //changes boolean watched to true
    public void watch(){
        watched = true;
    }
    //checks if two movies are the same
    public boolean isMatch(String title, int duration, String director, int year){
        if(this.title.equalsIgnoreCase(title) && this.duration == duration && 
            this.director.equalsIgnoreCase(director) && this.year == year){
            return true;
        }else{
            return false;
        }
    }
    //toString method
    @Override
    public String toString() {
        return title + " (" + year + ") / " + director + 
                " / " + duration + " minutes";
    }
}
