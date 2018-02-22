package forer.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	File dictionary;
	Map<String, String> map;

	public Dictionary() throws IOException {
		File dictionary = new File(
				"src\\forer\\Dictionary\\dictionary.txt");
		this.dictionary = dictionary;
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new FileReader(dictionary));
		String line = "";
		while ((line = in.readLine()) != null) {
			String[] parts = line.split(" ", 2);

			if (parts.length < 2) {
				String[] doubleParts = new String[2];
				doubleParts[0] = parts[0];
				doubleParts[1] = null;
				map.put(doubleParts[0], doubleParts[1]);

			} else {

				map.put(parts[0], parts[1]);

			}
		}
		in.close();
		this.map = map;
	}

	public boolean contains(String word) throws IOException {

		return map.containsKey(word.toUpperCase());
	}

	public String getDefinition(String word) throws IOException {
		String definition = null;
		String wordInDic = word.toUpperCase();
		if (map.containsKey(wordInDic)) {

			definition = map.get(wordInDic);

		}
		return definition;
	}
}
