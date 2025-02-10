import java.awt.*;
import java.io.*;
import java.util.*;

// A classroom exercise meant to get students comfortable with the basics of
// building maps and the differences between keys and values

public class MapExercise {
	public static final String DICTIONARY = "dictionary.txt";
	public static final int WIDTH = 400;
	public static final int TOP_K = 10;
	
	public static void main(String[] args) throws FileNotFoundException {
		/* YOUR CODE GOES HERE */
		Scanner dict = new Scanner(new File(DICTIONARY));
		Map<String, Integer> frequency = new HashMap<>();
		while(dict.hasNext()){
			String word = dict.nextLine();
			for(int i = 0; i < word.length() - 1; i++){
				String letterPair = word.substring(i, i + 2);
				if (frequency.containsKey(letterPair)) {
					frequency.put(letterPair, frequency.get(letterPair) + 1);
				}else{
					frequency.put(letterPair, 1);
				}
			}
		}

		// UNCOMMENT THIS CODE WHEN YOU ARE READY TO TEST
		Graphics g = drawStaticContent();
		display(g, frequency);

		System.out.printf("There are %d distinct letter" +  
			" pairs in the English Language.\n", frequency.size());
		
		System.out.print("These letter pairs occur only once: ");
		for(String pair: frequency.keySet()){
			if (frequency.get(pair) == 1) {
				System.out.print(pair + " ");
			}
		}
	}
	
	// Draws the static content of the bar chart, including horizontal header and
	// footer, blue horizontal lines, and a chart label
	public static Graphics drawStaticContent() {
		DrawingPanel panel = new DrawingPanel(WIDTH, 560);
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();
		
		// top and bottom gray bars
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,   0, WIDTH, 30);
        g.fillRect(0, 530, WIDTH, 30);
        
        // blue horizontal lines
        g.setColor(Color.BLUE);
        for (int i = 0; i <= 10; i++) {
            g.drawLine(0, 30 + i * 50, WIDTH, 30 + i * 50);
        }
        
        // chart label
        g.setColor(Color.BLACK);
        g.drawString("Top Ten Letter Pairs in English", 105, 16);
		
		return g;
	}
	
	// Draws the labels and bars for a chart showing the top ten most frequent
	// letter pairs in the given letter pair -> frequency map
	//
	// If the given map is null or contains fewer than 10 entries, no data
	// is displayed on the chart.
	public static void display(Graphics g, Map<String, Integer> pairs) {
		//get top 10
		TreeMap<Integer, String> topTen = getTopTen(pairs);
		if (topTen == null) {
			System.out.println("Map is null or contains fewer than 10 entries.");
			return;
		}
		
		// draw labels
		g.setFont(new Font("Monospaced", Font.BOLD, 16));
		g.setColor(Color.BLACK);
		
		int pairNum = 0;
		int maxFreq = Integer.MIN_VALUE;
		for (int freq : topTen.descendingKeySet()) {
			String pair = topTen.get(freq);
			System.out.println(pair + " - " + freq);

			g.setColor(Color.BLACK);
            g.drawString(" " + pair, WIDTH * pairNum / 10, 546);
            
            if (pairNum == 0) { // first
            	maxFreq = freq;
            }
            pairNum++;
		}

		// round to next multiple of 1000
		maxFreq = (1 + maxFreq / 1000) * 1000;
		
		// draw bars
		pairNum = 0;
		for (int freq : topTen.descendingKeySet()) {
			int x = WIDTH * pairNum / 10;
			int y = 530 - 500 * freq / maxFreq;
			g.setColor(pairNum % 2 == 0 ? Color.YELLOW : Color.ORANGE);
			g.fillRect(x+2, y, WIDTH / 10 - 4, 530 - y);
			pairNum++;
		}
	}
	
	// Returns a TreeMap of frequencies to letter pairs representing the top ten
	// most frequent letter pairs in the given letter pair -> frequency map
	//
	// Returns null if the given map is null or contains fewer than 10 entries
	public static TreeMap<Integer, String> getTopTen(Map<String, Integer> pairs) {
		if (pairs == null) {
			System.out.println("Map is null");
			return null;
		} else if (pairs.size() < 10) {
			System.out.println("Map size is less than 10.");
			return null;
		}
		
		// create an inverted map from integer -> list of letter pairs
		TreeMap<Integer, ArrayList<String>> invertMap = new TreeMap<>();
		for (String pair : pairs.keySet()) {
			int freq = pairs.get(pair);
			if (!invertMap.containsKey(freq)) {
				invertMap.put(freq, new ArrayList<String>());
			}
			invertMap.get(freq).add(pair);
		}
		
		// print out the top 10 letter pairs by frequency
		TreeMap<Integer, String> topTen = new TreeMap<>();
		int count = 0;
		for (int freq : invertMap.descendingKeySet()) {
			topTen.put(freq, invertMap.get(freq).get(0));
			count++;
			if (count == 10) {
				break;
			}
		}
		
		return topTen;
	}
}
