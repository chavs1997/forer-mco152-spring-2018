package forer.professor;

import java.util.List;

public class ProfessorFeed {
	private List<Professor> items;

	public List<Professor> getFeatures() {
		return items;
	}

	public boolean contains(String name) {
		boolean contains = false;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getFullName().equalsIgnoreCase(name.trim())) {
				contains = true;
			}
		}

		return contains;

	}

	public Professor getProfessor(String name) {
		Professor prof = new Professor();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getFullName().equalsIgnoreCase(name.trim())) {
				prof = items.get(i);
			}
		}
		return prof;
	}
}
