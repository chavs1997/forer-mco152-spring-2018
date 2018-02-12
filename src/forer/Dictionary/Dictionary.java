package forer.Dictionary;

import java.io.*;
import java.util.Scanner;

public class Dictionary {

	File dictionary;

	public Dictionary() throws IOException {
		File dictionary = new File(
				"C:\\Users\\chavs\\Documents\\Eclipse Projects\\VendingMachine\\src\\forer\\Dictionary\\dictionary.txt");
		this.dictionary = dictionary;
	}

	public boolean contains(String word) throws IOException {
		BufferedReader dictionary = new BufferedReader(new FileReader(this.dictionary));
		boolean contain = false;
		String line;
		while ((line = dictionary.readLine()) != null) {
			if (line.substring(0, word.length()).equalsIgnoreCase(word)) {
				contain = true;
			}

		}
		dictionary.close();
		return contain;
	}

	public String getDefinition(String word) throws IOException {
		String definition = null;
		Scanner sc = new Scanner(this.dictionary);
		String line;
		if (this.contains(word)) {
			while (sc.hasNextLine() && definition == null) {
				line = sc.nextLine();

				if (line.substring(0, word.length()).equalsIgnoreCase(word)) {
					definition = line.substring(word.length() + 1);

					while ((definition.charAt(definition.length() - 1)) != ']') {
						definition += sc.nextLine();
					}
				}
			}
		}
		sc.close();
		return definition;
	}
}
