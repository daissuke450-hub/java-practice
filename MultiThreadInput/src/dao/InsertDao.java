package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import util.DBUtil;

public class InsertDao {

	LogDao logDao = new LogDao();

	public void insert(User user) {

		String sql = "INSERT INTO users (id,name, email) VALUES (?,?, ?)";
		

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, user.getId());

			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logDao.log("insert", "ERROR", e.getMessage());
		
		}

	}
}
