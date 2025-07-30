package main;

import java.sql.SQLException;

import bean.User;
import dao.UserDao;

public class UpateById {

	public static void main(String[] args) throws SQLException {
		User update = new User(70, "変更さん", "updated@example.com");

		UserDao dao = new UserDao();

		dao.update(update);

	}

}
