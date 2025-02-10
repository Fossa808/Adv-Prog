import java.util.*;
import java.io.*;
public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		File dictionary = new File("dictionary.txt");
		Scanner dict = new Scanner(dictionary);
		ArrayList<String> words = new ArrayList<>();
		
		while(dict.hasNext()) {
			words.add(dict.nextLine());
		}
		
		dict.close();
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.print("Choose the length of the word: ");
		int length = console.nextInt();
		System.out.println("Thinking of a word...");
		ArrayList<String> selectWords = new ArrayList<>();
		
		for (int i = 0; i < words.size(); i++) {
			if(words.get(i).length() == length) {
				selectWords.add(words.get(i));
			}
		}
		
		Random rand = new Random();
		int index = rand.nextInt(selectWords.size());
		String word = selectWords.get(index);
		
		String[] dashes = new String[length];
		
		for(int i = 0; i < length; i++) {
			dashes[i] = "_";
		}
		
		ArrayList<String> wrongGuesses = new ArrayList<>();
		
		String guess = "";
		for(int i = 0; i < length; i++) {
			guess += dashes[i];
		}
		
		while(wrongGuesses.size() <= 6 && !word.equals(guess)) {
			System.out.print("Guess a letter: ");
			String letter = console.next();
			
			if(word.contains(letter)) {
				
				guess = "";
				String temp = word;
				for(int i = 0; i < temp.length(); i++) {
					if(!temp.contains(letter)) {
						break;
					}
					dashes[(length - temp.length()) + temp.indexOf(letter)] = letter;
					temp = temp.substring(temp.indexOf(letter) + 1);
				}
				for(int i = 0; i < length; i++) {
					guess += dashes[i];
				}
				System.out.println(wrongGuesses + "\n" + guess + "\n");
			}else {
				wrongGuesses.add(letter);
				System.out.println(wrongGuesses);
				System.out.println(guess + "\n");
			}
		}
		console.close();
		
		if(wrongGuesses.size() > 6) {
			System.out.println("Ahhhhhhh you lost!");
			System.out.println("The word was " + word);
		}else {
			System.out.println("Yayyyy you won! \nCongratulations!!!");
			System.out.println("The word was " + word);
		}
		
		
		

	}

}
