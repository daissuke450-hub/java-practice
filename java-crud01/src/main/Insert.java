package main;

import java.sql.SQLException;

import bean.User;
import dao.UserDao;

public class Insert {

	public static void main(String[] args) throws SQLException {

		UserDao dao = new UserDao();

		User user = new User();
		user.setName("あ".repeat(1000));
		user.setEmail("hanako@example.com");

		dao.insert(user);

	}

}
