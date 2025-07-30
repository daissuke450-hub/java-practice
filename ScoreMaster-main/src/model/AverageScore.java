package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Score;

public class AverageScore {

	/**
	 * 教科ごとの平均点を計算する
	 * @param scores Scoreリスト
	 * @return subjectNameごとの平均点Map
	 */
	public static Map<String, Double> calculate(List<Score> scores) {
		Map<String, Integer> totalMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();

		for (Score s : scores) {
			String subject = s.getSubject().getSubjectName();
			totalMap.put(subject, totalMap.getOrDefault(subject, 0) + s.getScore());
			countMap.put(subject, countMap.getOrDefault(subject, 0) + 1);
		}

		Map<String, Double> averageMap = new HashMap<>();
		for (String subject : totalMap.keySet()) {
			double avg = (double) totalMap.get(subject) / countMap.get(subject);
			averageMap.put(subject, avg);
		}

		return averageMap;
	}
}
