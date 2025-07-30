package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import util.DBUtil;

public class UserDao {

	// insert user
	public void insert(User user) throws SQLException {

		String sql = "INSERT INTO users (name , email) VALUES (?,?)";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());

			pstmt.executeUpdate();

		}

	}

	// user info all reading
	public List<User> findAll() {

		List<User> list = new ArrayList<User>();

		String sql = "SELECT * FROM users";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {

				list.add(new User(

						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email")

				));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// sarch users by id. １一件しかないからList型はつかわない
	public User findById(int id) throws SQLException {
		String sql = "SELECT name, email FROM users WHERE id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				User list = new User(
						id,
						rs.getString("name"),
						rs.getString("email")

				);

				return list;

			} else {

				return null;
			}

		}

	}

	// update by id(name, email)
	public void update(User user) throws SQLException {
		String sql = "UPDATE users SET name = ? , email =? WHERE id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(3, user.getId());

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());

			int count = pstmt.executeUpdate();

			if (count != 1) {
				throw new IllegalArgumentException(count + "件の更新を行うことができません");
			}

		}

	}

}
