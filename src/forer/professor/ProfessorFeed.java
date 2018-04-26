package forer.professor;

import java.util.List;

public class ProfessorFeed {
	private List<Professor> items;

	public List<Professor> getFeatures() {
		return items;
	}

	public boolean contains(String name) {
		boolean contains = false;
		for (Professor prof : items) {
			if (prof.getFullName().trim().equalsIgnoreCase(name)) {
				contains = true;
			}
		}
		return contains;

	}

	public Professor getProfessor(String name) {
		Professor professor = null;
		for (Professor prof : items) {
			if (prof.getFullName().equalsIgnoreCase(name.trim())) {
				professor = prof;
			}
		}
		return professor;
	}
}
