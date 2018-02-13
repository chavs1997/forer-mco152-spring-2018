package forer.dictionary;

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
		while ((line = dictionary.readLine()) != null && contain == false) {
			if (line.substring(0, word.length()).equalsIgnoreCase(word)
					&& line.substring(word.length(), word.length() + 1).equalsIgnoreCase(" ")) {
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
		while (sc.hasNextLine() && definition == null) {
			line = sc.nextLine();

			if (line.substring(0, word.length()).equalsIgnoreCase(word)
					&& line.substring(word.length()).isEmpty() == false) {
				definition = line.substring(word.length() + 1);
			}
		}
		if (definition != null) {
			if (definition.isEmpty() || definition == " ") {
				definition = null;
			}
		}
		sc.close();
		return definition;
	}
}
