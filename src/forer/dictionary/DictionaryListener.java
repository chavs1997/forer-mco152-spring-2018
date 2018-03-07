package forer.dictionary;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class DictionaryListener implements ActionListener {

	Dictionary dict;
	JTextField word;
	JTextArea definition;

	public DictionaryListener(JTextField word, JTextArea definition) throws IOException {
		this.dict = new Dictionary();
		this.word = word;
		this.definition = definition;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (dict.contains(word.getText().trim())) {
				if (dict.getDefinition(word.getText().trim()) != null) {
					definition.setText(dict.getDefinition(word.getText().trim()));
				} else {
					definition.setText("THIS WORD DOES NOT HAVE A DEFINITION");
				}
			} else {

				definition.setText("THIS WORD DOES NOT EXIST IN THE DICTIONARY");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
