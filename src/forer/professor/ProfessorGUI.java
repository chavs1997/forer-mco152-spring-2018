package forer.professor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import com.google.gson.Gson;

public class ProfessorGUI extends JFrame {

	public ProfessorGUI() throws IOException {

		Gson gson = new Gson();
		BufferedReader in = new BufferedReader(new FileReader(new File("src/forer/professor/professors.json")));
		ProfessorFeed feed = gson.fromJson(in, ProfessorFeed.class);

		setTitle("Professors");
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		JPanel addPanel = new JPanel();

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

		addPanel.add(new JLabel("Add New Professor:"));
		searchPanel.add(new JLabel("Search for Existing Professor: "));
		JPanel searchGrid = new JPanel();
		searchGrid.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.fill = GridBagConstraints.BOTH;

		searchGrid.add(new JLabel("Full Name:   "), constraint);
		constraint.gridy = 2;
		searchGrid.add(new JLabel("Difficulty:   "), constraint);
		constraint.gridy = 3;
		searchGrid.add(new JLabel("Quizzes:   "), constraint);
		constraint.gridy = 4;
		searchGrid.add(new JLabel("Papers:   "), constraint);
		constraint.gridy = 5;
		searchGrid.add(new JLabel("Projects:   "), constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		JTextField searchName = new JTextField("Enter full name");
		searchGrid.add(searchName, constraint);
		constraint.gridy = 1;
		JButton checkButton = new JButton("Find Professor");
		searchGrid.add(checkButton, constraint);
		constraint.gridy = 2;
		JTextField difficulty = new JTextField();
		searchGrid.add(difficulty, constraint);
		JTextField quizzes = new JTextField();
		constraint.gridy = 3;
		searchGrid.add(quizzes, constraint);
		constraint.gridy = 4;
		JTextField papers = new JTextField();
		searchGrid.add(papers, constraint);
		constraint.gridy = 5;
		JTextField projects = new JTextField();
		searchGrid.add(projects, constraint);

		searchPanel.add(searchGrid);
		JLabel specialMessage = new JLabel();
		searchPanel.add(specialMessage);

		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean contains = feed.contains(searchName.getText().trim());
				Professor prof = feed.getProfessor(searchName.getText().trim());

				if (contains == true) {

					difficulty.setText(Integer.toString(prof.getDifficulty()));
					quizzes.setText(Boolean.toString(prof.isQuizzes()));
					papers.setText(Boolean.toString(prof.isPapers()));
					projects.setText(Boolean.toString(prof.isProjects()));
				} else {
					specialMessage.setText(
							"This professor is not in the list. Ensure proper selling, then add the professor.");
				}
			}
		});

		JPanel addGrid = new JPanel();
		addGrid.setLayout(new GridBagLayout());
		constraint.gridx = 0;
		constraint.gridy = 0;
		addGrid.add(new JLabel("Full Name: "), constraint);
		constraint.gridy = 1;
		addGrid.add(new JLabel("Difficulty: "), constraint);
		constraint.gridy = 2;
		addGrid.add(new JLabel("Quizzes"), constraint);
		constraint.gridy = 3;
		addGrid.add(new JLabel("Papers: "), constraint);
		constraint.gridy = 4;
		addGrid.add(new JLabel("Projects: "), constraint);
		constraint.gridy = 0;
		constraint.gridx = 1;
		JTextField enterName = new JTextField("Enter full name");
		addGrid.add(enterName, constraint);
		constraint.gridy = 1;
		JTextField enterDif = new JTextField("enter 1-10 scale difficulty");
		addGrid.add(enterDif, constraint);
		constraint.gridy = 2;
		JTextField enterQuiz = new JTextField("enter yes or no for quizzes");
		addGrid.add(enterQuiz, constraint);
		constraint.gridy = 3;
		JTextField enterPaper = new JTextField("enter yes or no for papers");
		addGrid.add(enterPaper, constraint);
		constraint.gridy = 4;
		JTextField enterProj = new JTextField("enter yes or no for projects");
		addGrid.add(enterProj, constraint);
		constraint.gridy = 5;
		JButton addButton = new JButton("Add Professor");
		addGrid.add(addButton, constraint);
		JLabel addMessage = new JLabel();

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (feed.contains(enterName.getText().trim())) {
					addMessage.setText(
							"This professor already exists. Please, search on the right to see their information.");
				} else if (enterName.getText().isEmpty() || enterDif.getText().isEmpty()
						|| enterQuiz.getText().isEmpty() || enterPaper.getText().isEmpty()
						|| enterProj.getText().isEmpty()) {
					addMessage.setText("All fields must be filled in to add a professor.");
				} else {
					Professor prof = new Professor();
					prof.setIndex(String.valueOf(feed.getFeatures().size()));
					prof.setFullname(enterName.getText().trim());
					prof.setDifficulty(Integer.parseInt(enterDif.getText()));
					if (enterQuiz.getText().equalsIgnoreCase("yes")) {
						prof.setQuizzes(true);
					} else {
						prof.setQuizzes(false);
					}
					if (enterPaper.getText().equalsIgnoreCase("yes")) {
						prof.setPapers(true);
					} else {
						prof.setPapers(false);
					}
					if (enterProj.getText().equalsIgnoreCase("yes")) {
						prof.setProjects(true);
					} else {
						prof.setProjects(false);
					}

					feed.getFeatures().add(prof);
					try(FileWriter fw = new FileWriter("src/forer/professor/professors.json");
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
						    out.println(gson.toJson(feed));
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					addMessage.setText("Professor added successfully.");
				}

			}

		});

		addPanel.add(addGrid);
		addPanel.add(addMessage);

		mainPanel.add(searchPanel);
		mainPanel.add(addPanel);

		add(mainPanel);

	}

	public static void main(String[] args) throws IOException {
		new ProfessorGUI().setVisible(true);
	}

}
