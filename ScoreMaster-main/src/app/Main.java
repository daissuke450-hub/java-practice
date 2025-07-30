package app;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Score;
import bean.Student;
import bean.Subject;
import config.MyBatisUtil;
import dao.ScoreInsertDao;
import dao.StudentsDao;
import io.InputScore;
import io.OutputEvaluation;
import model.AverageScore;
import model.Evaluation;

public class Main {

	public static void main(String[] args) throws IOException {
		// CSVから読み込み
		List<Score> scores = InputScore.readScoresFromCSV("StudentsScore.csv");

		// 平均点算出
		Map<String, Double> averageMap = AverageScore.calculate(scores);

		try (SqlSession session = MyBatisUtil.getSqlSession(true)) {
			StudentsDao studentsDao = session.getMapper(StudentsDao.class);
			ScoreInsertDao scoreDao = session.getMapper(ScoreInsertDao.class);

			for (Score score : scores) {
				Student student = score.getStudent();
				Subject subject = score.getSubject();

				// 生徒ID取得・登録
				Integer studentId = studentsDao.getStudentId(student);
				if (studentId == null) {
					studentsDao.insertStudent(student);
					studentId = student.getStudentId();
				} else {
					student.setStudentId(studentId);
				}

				// 教科ID取得・登録
				Integer subjectId = studentsDao.getSubjectId(subject);
				if (subjectId == null) {
					studentsDao.insertSubject(subject);
					subjectId = subject.getSubjectId();
				} else {
					subject.setSubjectId(subjectId);
				}

				// 評価
				double average = averageMap.get(subject.getSubjectName());
				int abs = Evaluation.evaluateAbsolute(score.getScore());
				int rel = Evaluation.evaluateRelative(score.getScore(), average);
				int fin = Evaluation.evaluateFinal(score.getScore(), average);

				score.setEvaluationAbsolute(abs);
				score.setEvaluationRelative(rel);
				score.setEvaluationFinal(fin);

				// Scoreテーブルに登録
				scoreDao.insertScore(score);
				System.out.printf("点数登録: %s - %s - %d\n", student.getName(), subject.getSubjectName(),
						score.getScore());

				// ファイル書き出し
				OutputEvaluation.writeEvaluationsToFile(scores, "StudentsEvaluation.txt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
