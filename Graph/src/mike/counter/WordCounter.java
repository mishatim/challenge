package mike.counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;

public class WordCounter {

	public static void main(String[] args) {
		
		String file = "src\\mike\\counter\\WordsFile.txt";
		
		
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = br.readLine()) != null) {
		       sb.append(line);
		    }
		    
		    Map<String, Integer> wordMap = new WordCounter().countWords(sb.toString());
			for (String key : wordMap.keySet()) {
				System.out.println(wordMap.get(key) + " " + key);
			}

			br.close();
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public Map<String, Integer> countWords(String text) {
		
		// count words
		String words[] = text.split("[ (),.;:?!_-]");
		
		Map<String, Integer> map = new Hashtable<String, Integer>();
		
		for (String word : words) {
			if (map.containsKey(word)) {
				int val = map.get(word);
				map.put(word, ++val);
			}
			else {
				map.put(word, 1);
			}
		}
		return map;
	}

}