package main;

import java.sql.SQLException;
import java.util.List;

import bean.User;
import csv.InsertCSV;
import dao.UserDao;

public class CSVInsert {

	public static void main(String[] args) throws SQLException {
		InsertCSV csv = new InsertCSV();

		UserDao dao = new UserDao();

		List<User> list = csv.csvList("users.csv");

		int i = 0;

		for (User user : list) {

			i++;

			dao.insert(user);

			System.out.println(i + "件登録しました");

		}
	}

}
