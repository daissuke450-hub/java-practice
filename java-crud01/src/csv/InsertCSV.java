package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class InsertCSV {

	public List<User> csvList(String filePath) {

		List<User> list = new ArrayList<User>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			String line;

			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(",");

				if (parts.length != 2) {
					System.out.println("不正フォーマット：" + line);
					continue;
				}

				String name = parts[0].trim();
				String email = parts[1].trim();

				User user = new User();
				user.setName(name);
				user.setEmail(email);

				list.add(user);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
