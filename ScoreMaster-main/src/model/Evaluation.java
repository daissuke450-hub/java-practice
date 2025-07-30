package model;

public class Evaluation {

	/**
	 * 絶対評価
	 * 90点以上 -> 5
	 * 80～89点 -> 4
	 * 70～79点 -> 3
	 * 60～69点 -> 2
	 * 60点未満 -> 1
	 */
	public static int evaluateAbsolute(int score) {
		if (score >= 90)
			return 5;
		else if (score >= 80)
			return 4;
		else if (score >= 70)
			return 3;
		else if (score >= 60)
			return 2;
		else
			return 1;
	}

	/**
	 * 平均点との差分から相対評価を算出
	 * 差がプラス15点以上 -> 5
	 * 10～14点 -> 4
	 * 5～9点 -> 3
	 * 0～4点 -> 2
	 * マイナスの場合 -> 1
	 */
	public static int evaluateRelative(int score, double average) {
		double diff = score - average;
		if (diff >= 15)
			return 5;
		else if (diff >= 10)
			return 4;
		else if (diff >= 5)
			return 3;
		else if (diff >= 0)
			return 2;
		else
			return 1;
	}

	/**
	 * 最終評価を決定
	 * @param score 個別点数
	 * @param average 平均点
	 * @return 1～5の評価値
	 */
	public static int evaluateFinal(int score, double average) {
		int absEval = evaluateAbsolute(score);
		int relEval = evaluateRelative(score, average);
		return Math.max(absEval, relEval);
	}
}
