package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.Question;

public class InputQuestion {

	public List<Question> read(String filePath) throws IOException {

		List<Question> questions = new ArrayList<Question>();

		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		reader.readLine();

		String line;

		while ((line = reader.readLine()) != null) {

			//			System.out.println("読み込み成功");

			String[] parts = line.split(",");

			questions.add(new Question(Integer.parseInt(parts[0]), parts[1]));

		}

		reader.close();

		return questions;

	}

}
