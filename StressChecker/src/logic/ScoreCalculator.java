package logic;

import java.util.List;

import bean.Question;

public class ScoreCalculator {

	// スコアの合計
	public static int calculateTotal(List<Question> questions) {
		return questions.stream().mapToInt(Question::getScore).sum();
	}

	/**
	 * うつ計算(カットオフ10)
	 * 
	 * @param totalScore
	 * @return
	 */
	public static String evaluate(int totalScore) {

		if (totalScore <= 4) {
			return "正常";
		} else if (totalScore <= 9) {
			return "軽度うつ";
		} else if (totalScore <= 14) {
			System.out.println("通院推奨");
			return "中程度のうつ";
		} else if (totalScore <= 19) {
			System.out.println("通院推奨");
			return "中から重度のうつ";
		} else {
			System.out.println("通院推奨");
			return "重度のうつ";
		}
	}

	// スコアの平均
	public static double calculateAverage(List<Question> questions) {
		return questions.stream().mapToInt(Question::getScore).average()
				.orElse(0.0);
	}

	// スコアの標準偏差
	public static double calculateStandardDeviation(List<Question> questions) {
		double avg = calculateAverage(questions);
		double variance = questions.stream().mapToDouble(question -> Math.pow(question.getScore() - avg, 2))
				.average().orElse(0.0);

		return Math.sqrt(variance);

	}

	// Zスコア
	public static String zScore(List<Question> questions, int totalScore) {
		double variance = calculateStandardDeviation(questions);
		double avg = calculateAverage(questions);

		double zScore = (totalScore - avg) / variance;

		if (zScore >= 2) {
			return "考慮あり";
		} else {
			return "考慮なし";
		}

	}

}
