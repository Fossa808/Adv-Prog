//importing libraries from java
import java.util.*;

//Tools for temperature
public class TempTools {
    private ArrayList<Double> temps;
    private char scale;

    //Constructors
    public TempTools(ArrayList<Double> temps, char scale){
        this.scale = scale;
        this.temps = temps;
    }
    //Constructor without provided temperatures
    public TempTools(char scale){
        this(new ArrayList<Double>(), scale);
    }

    //Getters
    //get Temperatures
    public ArrayList<Double> getTemps() {
        return temps;
    }
    //get Scale
    public char getScale() {
        return scale;
    }
    //get Lowest
    public double getLowest(){
        double min = temps.get(0);
        for (int i = 0; i < temps.size(); i++) {
            if (min > temps.get(i)) {
                min = temps.get(i);
            }
        }
        return min;
    }
    //get Highest
    public double getHighest(){
        double max = temps.get(0);
        for (int i = 0; i < temps.size(); i++) {
            if (max < temps.get(i)) {
                max = temps.get(i);
            }
        }
        return max;
    }
    //get Average
    public double getAverage(){
        double sum = 0;
        for (int i = 0; i < temps.size(); i++) {
            sum += temps.get(i);
        }
        double avg = sum / temps.size();
        return avg;
    }

    //Helper Methods
    //add temperatures
    public void addTemp(double temp){
        temps.add(temp);
    }
    //remove temperatures
    public void removeTemp(double temp){
        for(int i = temps.size() - 1; i >= 0 ; i--){
            if (temp == temps.get(i)) {
                temps.remove(i);
            }
        }
    }

    //Setters - set scale and convert temperatures
    public void setScale(char scale) {
        //checks if scale is different from this.scale
        if (scale != this.scale) {
            this.scale = scale;
            //checks if scale is set to Fahrenheit
            if (scale == 'F'){
                for (int i = 0; i < temps.size(); i++) {
                    temps.set(i, (temps.get(i) * (9.0/5)) + 32);
                }
            }else if(scale == 'C'){//checks if scale is set to Celsius
                for (int i = 0; i < temps.size(); i++) {
                    temps.set(i, (temps.get(i) - 32) * (5.0/9));
                }
            }
        }
    }

    //toString
    @Override
    public String toString(){
        String out = temps.get(0) + "";
        for (int i = 1; i < temps.size(); i++) {
            out += ", " + temps.get(i);
        }
        out += " " + scale;
        return out;
    }
}
