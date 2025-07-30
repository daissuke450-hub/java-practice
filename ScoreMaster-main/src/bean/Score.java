package bean;

public class Score {

	private int scoreId;
	private Student student;
	private Subject subject;
	private int score;

	private int evaluationAbsolute;
	private int evaluationRelative;
	private int evaluationFinal;

	public Score(Student student, Subject subject, int score) {
		this.student = student;
		this.subject = subject;
		this.score = score;
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEvaluationAbsolute() {
		return evaluationAbsolute;
	}

	public void setEvaluationAbsolute(int evaluationAbsolute) {
		this.evaluationAbsolute = evaluationAbsolute;
	}

	public int getEvaluationRelative() {
		return evaluationRelative;
	}

	public void setEvaluationRelative(int evaluationRelative) {
		this.evaluationRelative = evaluationRelative;
	}

	public int getEvaluationFinal() {
		return evaluationFinal;
	}

	public void setEvaluationFinal(int evaluationFinal) {
		this.evaluationFinal = evaluationFinal;
	}
}
