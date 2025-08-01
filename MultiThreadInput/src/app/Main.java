package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.User;
import dao.InsertDao;
import model.MultiInsert;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {

		MultiInsert multi = new MultiInsert();

		List<User> list = multi.multithread("users.csv");

		InsertDao dao = new InsertDao();

		for (User u : list) {

			dao.insert(u);

		}

	}

}
