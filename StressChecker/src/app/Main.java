package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bean.Question;
import bean.Result;
import dao.ResultInsertDao;
import io.InputQuestion;
import logic.ResultInsert;
import logic.ScoreCalculator;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {

		// ファイル読み込み(phq9の質問)
		InputQuestion inputQuestion = new InputQuestion();
		List<Question> questions = inputQuestion.read("phq9_questions.csv");

		// 質問開始
		int questionNumber = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("（0:全くない 1:いくらかある 2:しばしばある 3:ほとんど毎日ある）");

		for (Question q : questions) {

			questionNumber++;

			System.out.println("質問" + questionNumber + "：" + q.getText());

			String line = scanner.nextLine();

			q.setScore(Integer.parseInt(line));

		}

		scanner.close();

		// スコアの合計計算
		int totalScore = ScoreCalculator.calculateTotal(questions);

		String evaluation = ScoreCalculator.evaluate(totalScore);

		System.out.println("診断結果：" + evaluation);

		// Zスコアから診療を考慮
		String zScoreEvaluation = ScoreCalculator.zScore(questions, totalScore);

		System.out.println("診察" + zScoreEvaluation);

		// Resultのbeanに挿入
		ResultInsert resultInsert = new ResultInsert();
		Result result = resultInsert.insertResult(totalScore, evaluation);

		// DBに保存
		ResultInsertDao dao = new ResultInsertDao();
		dao.insert(result);

		System.out.println("結果を保存しました");

	}

}
