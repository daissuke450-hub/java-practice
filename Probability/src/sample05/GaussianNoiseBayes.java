package sample05;

import java.util.Random;

public class GaussianNoiseBayes {

	public static void main(String[] args) {
		Random random = new Random();

		// 元の数列
		int length = 10;
		double[] original = new double[length];
		for (int i = 0; i < original.length; i++) {
			original[i] = i;

		}

		double sigma = 1.0; // ノイズの標準偏差

		// ノイズ付加
		double[] noisy = new double[length];
		for (int i = 0; i < length; i++) {
			double noise = sigma * random.nextGaussian();
			noisy[i] = original[1] + noise;
		}

		// ノイズ除去
		double[] estimated = new double[length];
		for (int i = 0; i < length; i++) {
			estimated[i] = noisy[i];
		}

		for (int i = 0; i < length; i++) {
			double x = original[i];
			double y = estimated[i];

			double likelihood = gaussianPdf(y, x, sigma);
			double prior = 1.0 / length; // 均一分布の事前確率

			double posterior = likelihood * prior;

			System.out.printf("元の値=%.2f, 推定値=%.2f, 事後確率(非正規化)=%.5f\n", x, y, posterior);
		}

	}

	public static double gaussianPdf(double x, double mean, double sigma) {
		double a = 1.0 / (sigma * Math.sqrt(2 * Math.PI));
		double exp = Math.exp(-Math.pow(x - mean, 2) / (2 * sigma * sigma));
		return a * exp;
	}

}
