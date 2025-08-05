package sample04;

import java.util.Random;

public class NoiseAdderNumeric {

	public static void main(String[] args) {
		double[] originalData = { 10, 20, 30, 40, 50 };
		double mu = 0.0; // ノイズ平均
		double sigma = 1.0; // ノイズの標準偏差

		double[] noisyData = addGaussianNoise(originalData, mu, sigma);

		System.out.println("元データ\tノイズ付加後");
		for (int i = 0; i < originalData.length; i++) {
			System.out.printf("%.2f\t -> \t%.2f%n", originalData[i], noisyData[i]);
		}
	}

	public static double[] addGaussianNoise(double[] data, double mu, double sigma) {
		Random random = new Random();

		double[] noisy = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			double noise = random.nextGaussian() * sigma + mu;
			noisy[i] = data[i] + noise;
		}
		return noisy;
	}

}
