package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import bean.Result;
import util.DBUtil;

public class ResultInsertDao {

	public void insert(Result result) throws SQLException {

		try (Connection connection = DBUtil.getConnection()) {
			QueryRunner queryRunner = new QueryRunner();
			String sql = "INSERT INTO  phq9_results (assessment_date, total_score,  evaluation) VALUES (?,?,?)";

			queryRunner.update(connection, sql, result.getAssessmentDate(), result.getTotalScore(),
					result.getEvaluation());

		}
	}

}
