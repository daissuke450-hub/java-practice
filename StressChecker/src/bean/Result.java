package bean;

import java.sql.Date;

public class Result {
	private int id;
	private Date assessmentDate;
	private int totalScore;
	private String evaluation;

	public Result() {
	}

	public Result(Date assessmentDate, int totalScore, String evaluation) {
		this.assessmentDate = assessmentDate;
		this.totalScore = totalScore;
		this.evaluation = evaluation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

}
