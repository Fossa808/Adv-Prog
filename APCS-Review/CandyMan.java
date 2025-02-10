import java.util.*;
public class CandyMan {
    public static void main(String[] args) {
        ArrayList<String> candies = new ArrayList<>();
        
        Scanner console = new Scanner(System.in);

        System.out.print("Enter candy: ");
        String response = console.nextLine();

        while(!response.equalsIgnoreCase("quit")){
            candies.add(response);

            System.out.print ("Enter candy: ");
            response = console.nextLine();
        }
    }
}
