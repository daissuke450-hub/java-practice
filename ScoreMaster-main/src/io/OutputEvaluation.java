package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import bean.Score;

public class OutputEvaluation {

	/**
	 * 生徒の成績評価をファイルに出力する
	 * 
	 * @param scores 評価済みのScoreオブジェクト一覧
	 * @param filePath 出力ファイルパス
	 */
	public static void writeEvaluationsToFile(List<Score> scores, String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// ヘッダー行
			writer.write("Name,Grade,Class,Subject,Score,FinalEval");
			writer.newLine();

			for (Score score : scores) {
				String line = String.format(
						"%s,%d,%s,%s,%d,%d",
						score.getStudent().getName(),
						score.getStudent().getGrade(),
						score.getStudent().getClassName(),
						score.getSubject().getSubjectName(),
						score.getScore(),
						score.getEvaluationFinal());
				writer.write(line);
				writer.newLine();
			}

			System.out.println("成績ファイルの出力が完了しました: " + filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
