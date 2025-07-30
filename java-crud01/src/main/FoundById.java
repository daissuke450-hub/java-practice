package main;

import java.sql.SQLException;

import bean.User;
import dao.UserDao;

public class FoundById {

	public static void main(String[] ars) throws SQLException {

		UserDao dao = new UserDao();

		User found = dao.findById(0);

		System.out.println("名前は" + found.getName() + "メールアドレスは：" + found.getEmail());

	}

}
