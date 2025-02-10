import java.util.*;
import java.io.*;


// Prints the stats of the Pokemon that the user selects from the stats file.
public class Pokedex {
   public static void main(String[] args) throws FileNotFoundException {
       //Welcome and Introduction
       System.out.println("Welcome to the Pokedex!");
       Scanner console = new Scanner(System.in);
       System.out.print("Which Pokemon stats do you want to see? ");
       String pokemon = console.nextLine();
       console.close();
      
       //Pulls information from the stats file
       File statsFile = new File("pokemon_stats.txt");
       Scanner file = new Scanner(statsFile);
       boolean hasPoke = false;
       //parses through the file to check for the user input
       while (file.hasNextLine()) {
           String pokeName = file.nextLine();
           //Checks of the name of the Pokemon matches the user Input
           //If yes, it's stats are printed
           if (pokeName.equalsIgnoreCase(pokemon)) {
               printPokemon(pokeName, file);
               hasPoke = true;
               break;
           }
           else{//If not, it moves on to the next pokemon in the file
               for (int i = 0; i < 3; i++){
                   file.nextLine();
               }
           }
       }
      
       //sends error message if user input is not in the stats file
       if(!hasPoke){
           System.out.println("Pokemon not found.");
       }


       //Thank you message
       System.out.println("Thank you for using the Pokedex. Goodbye!");
   }


   //Prints the stats of a specific pokemon: name, type, gen, hit points.
   public static void printPokemon(String name, Scanner file){
       System.out.println("Name: " + name);
       System.out.println("Type: " + file.nextLine());
       System.out.println("Gen: " + file.nextLine());
       System.out.println("HP: " + file.nextLine());
   }
}


