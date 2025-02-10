import java.util.*;

//This class is the manager of the Evil Hangman that cheats.
//It chooses the word based on the guesses made by the user
//It categorizes the words of selected length into sets based on the number
//of occurences and position of the guess in the word. It then finds the set
//with the most number of words and updates the set of words considered.
//This way it lengthens the game as much as possible by nearly making most
//if not all of the users guesses incorrect.
//The following public methods are in this class: words(), guessesLeft(),
//guesses(), pattern, record(guess)
//The following private methods are in this class: createMap(words), 
//findLongestSet(words), returnPattern(guess, word), checkOccurences(guess)
public class EvilHangman {
    /****FIELDS****/
    private int guessLeft;
    private String wordPattern = "";
    private Set<Character> lettersGuessed;
    private Set<String> wordsConsidered = new TreeSet<>();

    /****BEHAVIOR****/
    //Constructor
    //initializes all the fields and checks for invalid inputs
    public EvilHangman(Collection<String> dictionary, int length, int max){
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException("INVALID INPUT!!!");            
        }

        guessLeft = max;
        lettersGuessed = new TreeSet<>();

        for(int i = 0; i < length; i++){
            wordPattern += "- ";
        }
        wordPattern = wordPattern.trim();

        Iterator<String> itr = dictionary.iterator();
        while (itr.hasNext()){
            String word = itr.next();
            if(word.length() == length){
                wordsConsidered.add(word);
            }
        }
    }

    //Returns the current set of words considered by the hangman game
    //Takes no parameters and returns a set of strings
    public Set<String> words(){
        return wordsConsidered;
    }

    //Returns the number of guesses left for the user
    //Takes no parameters and returns an integer
    public int guessesLeft(){
        return guessLeft;
    }

    //Returns all the letters that the user had guessed incorrectly.
    //Takes no parameters and returns a set of characters
    public Set<Character> guesses(){
        return lettersGuessed;
    }

    //Returns the current pattern/dashes and correct guesses during the game
    //Format example: "- - - -" or "- o o -"
    //Takes no parameters and returns a String
    public String pattern(){
        if (wordsConsidered.isEmpty()) {
            throw new IllegalStateException();
        }
        return wordPattern;
    }

    //Records the guess made by the user and decides the set of 
    //words(word bank) to be used in the next rounds of guessing in the game.
    //Updates the pattern and returns the number of occurences of the 
    //guess in the new pattern. Updates the number of guesses left if the guess
    //is incorrect.
    //Takes a character for the guess as a parameter and returns an int of
    //occurences of the guess.
    public int record(char guess){
        if (guessLeft < 1 || wordsConsidered.isEmpty()) {
            throw new IllegalStateException();
        }if (lettersGuessed.contains(guess)) {
            throw new IllegalArgumentException();
        }

        lettersGuessed.add(guess);
        Map<String, Set<String>> words = new TreeMap<>();
        words = createMap(words, guess);

        findLongestSet(words);
        int count = checksOccurences(guess);

        if (count == 0){
            guessLeft--;
        }

        return count;
    }

    //creates a Map with the patterns as the keys and the words with 
    //that pattern as a set of values
    //Takes a Map and a character as Parameters and returns the updated map.
    private Map<String, Set<String>> createMap(Map<String, Set<String>> words,
            char guess){
        for (String word : wordsConsidered) {
            String patternOfWord = returnPattern(guess, word);

            if (words.containsKey(patternOfWord)) {
                words.get(patternOfWord).add(word);
            }else{
                words.put(patternOfWord, new TreeSet<>());
                words.get(patternOfWord).add(word);
            }
        }
        return words;
    }

    //Finds the Set in the map with the longest length/size
    //Takes a map as a parameter
    private void findLongestSet(Map<String, Set<String>> words){
        int maxSize = -1;
        Set<String> mostWords = new TreeSet<>();
        String newPattern = "";

        for(String patternOfWord : words.keySet()){
            int sizeOfWordSet = words.get(patternOfWord).size();

            if (maxSize < sizeOfWordSet) {
                maxSize = sizeOfWordSet;
                mostWords.clear();
                mostWords = words.get(patternOfWord); 
                newPattern = patternOfWord;                  
            }
        }

        this.wordsConsidered.clear();
        this.wordsConsidered.addAll(mostWords);
        this.wordPattern = newPattern;
    }

    //Returns the pattern of the word given as a parameter
    //Takes a character and String as a parameter and returns a string 
    private String returnPattern(char guess, String word){
        String patternOfWord = wordPattern;

        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == guess) {
                int index = (i * 2);
                patternOfWord = patternOfWord.substring(0,index) + guess + 
                    patternOfWord.substring(index + 1, patternOfWord.length());
            }
        }
        return patternOfWord;
    }
    
    //Checks the number of occurences of a letter in a pattern
    //Takes a character as a parameter and returns an int
    private int checksOccurences(char guess){
        int count = 0;

        for (int i = 0; i < wordPattern.length(); i++) {
            if (wordPattern.charAt(i) == guess) {
                count++;
            }
        }
        return count;
    }
}
