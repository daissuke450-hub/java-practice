package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Score;
import bean.Student;
import bean.Subject;

public class InputScore {

	public static List<Score> readScoresFromCSV(String filePath) {
		List<Score> scoreList = new ArrayList<Score>();
		Map<String, Student> studentMap = new HashMap<>();
		Map<String, Subject> subjectMap = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			String line;
			reader.readLine();

			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split(",", -1);

				String name = tokens[0];
				int grade = Integer.parseInt(tokens[1]);
				String className = tokens[2];
				String subjectName = tokens[3];
				int score = Integer.parseInt(tokens[4]);

				Student student = studentMap.computeIfAbsent(
						name, k -> new Student(name, grade, className));

				Subject subject = subjectMap.computeIfAbsent(
						subjectName, k -> new Subject(subjectName));

				scoreList.add(new Score(student, subject, score));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return scoreList;

	}

}
