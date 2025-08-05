package sample03;

import java.util.Arrays;
import java.util.List;

public class ConditionalProbabilityMap {

	/**
	 * csvファイルなどでデータを扱った場合の
	 * 条件付確率
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// データ例：予習したか、合格したか
		List<String[]> data = Arrays.asList(

				new String[] { "yes", "yes" },
				new String[] { "yes", "yes" },
				new String[] { "no", "yes" },
				new String[] { "yes", "no" },
				new String[] { "no", "no" },
				new String[] { "yes", "yes" },
				new String[] { "no", "yes" }

		);

		int total = data.size();
		int passed = 0;
		int studiedAndPassed = 0;

		for (String[] record : data) {
			String studied = record[0];
			String passedStatus = record[1];

			// 合格かどうかでふるいにかける
			if (passedStatus.equals("yes")) {
				passed++; // 合格者をカウント
				if (studied.equals("yes")) {
					studiedAndPassed++; // 合格かつ予習した人をカウント
				}
			}
		}

		double pB = (double) passed / total; // 合格者の確率
		double pAndB = (double) studiedAndPassed / total; // 合格かつ予習した人の確率
		double pAgivenB = pAndB / pB;

		System.out.println("P(studied | passed) = " + pAgivenB);

	}

}
