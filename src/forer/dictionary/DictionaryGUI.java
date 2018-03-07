package forer.dictionary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class DictionaryGUI extends JFrame {

	public DictionaryGUI() throws IOException {
		setTitle("Dictionary");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.YELLOW);
		JTextField word = new JTextField("Enter your word here");
		topPanel.add(word);
		JButton search = new JButton("Search");
		JTextArea centerText = new JTextArea();
		centerText.setSize(400, 200);
		centerText.setLineWrap(true);
		centerText.setWrapStyleWord(true);
		centerText.setEditable(false);
		
		DictionaryListener listener = new DictionaryListener(word, centerText);
		search.addActionListener(listener);
		
		topPanel.add(search);
		mainPanel.add(topPanel);
		JPanel lower = new JPanel();
		lower.setBackground(Color.CYAN);
		lower.add(centerText);
		mainPanel.add(lower);

		add(mainPanel);
	}

	public static void main(String[] args) throws IOException {
		new DictionaryGUI().setVisible(true);
	}

}
