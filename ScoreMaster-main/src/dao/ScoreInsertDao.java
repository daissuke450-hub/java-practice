package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import bean.Score;

public interface ScoreInsertDao {

	@Insert("""
			INSERT INTO subject_scores (
			    student_id, subject_id, score,
			    evaluation_absolute, evaluation_relative, evaluation_final
			) VALUES (
			    #{student.studentId}, #{subject.subjectId}, #{score},
			    #{evaluationAbsolute}, #{evaluationRelative}, #{evaluationFinal}
			)
			""")
	@Options(useGeneratedKeys = true, keyProperty = "scoreId")
	void insertScore(Score score);
}
