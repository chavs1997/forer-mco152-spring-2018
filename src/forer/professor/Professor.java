package forer.professor;

public class Professor {
	private String index;
	private int difficulty;
	private String fullname;
	private boolean quizzes;
	private boolean papers;
	private boolean projects;

	public String getIndex() {
		return index;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public String getFullName() {
		return fullname;
	}

	public boolean isQuizzes() {
		return quizzes;
	}

	public boolean isPapers() {
		return papers;
	}

	public boolean isProjects() {
		return projects;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setQuizzes(boolean quizzes) {
		this.quizzes = quizzes;
	}

	public void setPapers(boolean papers) {
		this.papers = papers;
	}

	public void setProjects(boolean projects) {
		this.projects = projects;
	}

}
