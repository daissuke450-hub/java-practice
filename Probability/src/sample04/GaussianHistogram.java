package sample04;

import java.util.Random;

public class GaussianHistogram {

	public static void main(String[] args) {
		Random random = new Random();
		int count = 100_000;

		int[] histogram = new int[21];

		for (int i = 0; i < count; i++) {

			double x = random.nextGaussian();

			int index = (int) Math.round(x) + 10;

			if (index >= 0 && index < histogram.length) {
				histogram[index]++;
			}

		}

		// 出力(簡易ヒストグラム)
		for (int i = 0; i < histogram.length; i++) {
			int value = histogram[i];
			int label = i - 10;
			String bar = "*".repeat(value / 200); // スケーリング調整
			System.out.printf("%3d : %s (%d)\n", label, bar, value);
		}

	}

}
