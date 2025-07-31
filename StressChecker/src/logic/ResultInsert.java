package logic;

import bean.Result;

public class ResultInsert {

	public Result insertResult(int totalScore, String evaluation) {
		Result result = new Result();

		result.setAssessmentDate(new java.sql.Date(System.currentTimeMillis()));
		result.setTotalScore(totalScore);
		result.setEvaluation(evaluation);

		return result;

	}

}
