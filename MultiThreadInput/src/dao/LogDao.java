package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.DBUtil;

public class LogDao {

	private static final Logger logger = LogManager.getLogger(LogDao.class);

	public void log(String threadName, String level, String message) {
		String sql = "INSERT INTO process_logs (thread_name, log_level, message) VALUES (?, ?, ?)";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, threadName);
			pstmt.setString(2, level);
			pstmt.setString(3, message);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			logger.error("DBログ保存で例外発生", e);
		}
	}
}
