package sample02;

import java.util.Random;

public class DiceSimulation {

	/**
	 * サイコロを10,000回振ったときの、それぞれの目の確率
	 * 
	 * 理論値：0.1667
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int sides = 6; // サイコロの目の数
		int trials = 10000; // 試行回数
		int[] counts = new int[sides]; // 各目が出た回数

		Random random = new Random();

		for (int i = 0; i < trials; i++) {
			int roll = random.nextInt(sides); // 0～5の乱数
			counts[roll]++;
		}

		// 結果表示
		for (int i = 0; i < sides; i++) {
			double probability = (double) counts[i] / trials;
			System.out.printf("目 %d: 出現回数 = %d, 確率 = %.4f\n", i + 1, counts[i], probability);
		}

	}

}
