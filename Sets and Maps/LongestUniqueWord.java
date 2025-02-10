//Longest word with no duplicates is ambidextrously.
//EXTENSION:
//Longest word with the most duplicates is floccinaucinihilipilification.
import java.util.*;
import java.io.*;

//Finds the longest word in the dictionary that does not repeat any letters
//and the longest word with the most duplicate letters.
public class LongestUniqueWord {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dict = new Scanner(new File("dictionary.txt"));
        String uniqueWord = "";
        String dupeWord = "";
        int letterDiff = 0;

        //Runs while there are still words in the dictionary
        while (dict.hasNextLine()) {
            String temp = dict.nextLine();
            Set<Character> letters = new HashSet<>();

            for(int i = 0; i < temp.length(); i++){
                letters.add(temp.charAt(i));
            }
            
            //Check for longest word with no duplicates
            uniqueWord = findLongestUniqueWord(temp, letters, uniqueWord);

            //Checks for longest words with the most duplicates
            dupeWord = findLongestDupeWord(temp, letters, letterDiff, dupeWord);
            
        }

        dict.close();
        System.out.println("Longest word with no duplicates: " + uniqueWord);
        System.out.println("Longest word with most duplicates: " + dupeWord);
    }

    //Checks if word is the longest without duplicates
    public static String findLongestUniqueWord(String temp,
                Set<Character> letters, String longUniqWord){
            if (letters.size() == temp.length() && 
                temp.length() > longUniqWord.length()) {
                longUniqWord = temp;
            }
            return longUniqWord;
            }

    //Checks if word is the longest words with the most duplicates
    public static String findLongestDupeWord(String temp,
             Set<Character> letters, int letterDiff, String longDupWord){
        int wordLengthDiff = temp.length() - letters.size();

        if (wordLengthDiff > letterDiff && 
            temp.length() > longDupWord.length()) {
            letterDiff = wordLengthDiff;
            longDupWord = temp;  
        }
        return longDupWord;
    }
}
