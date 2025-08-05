package sample04;

import java.util.Arrays;
import java.util.Random;

public class NoiseRestoreSimulation {

	public static void main(String[] args) {
		double[] originalData = { 10, 20, 30, 40, 50 };
		double mu = 0.0;
		double sigma = 2.0;
		int trials = 100; // 試行回数を増やせば平均に近づく

		double[] noisySamples = new double[originalData.length * trials];
		Random random = new Random();

		// ノイズを付加してサンプルを作る
		for (int t = 0; t < trials; t++) {
			for (int i = 0; i < originalData.length; i++) {
				double noisy = originalData[i] + random.nextGaussian() * sigma + mu;
				noisySamples[t * originalData.length + i] = noisy;
			}
		}

		// noisySamples の平均を計算し、元の値を推定
		double estimatedMean = Arrays.stream(noisySamples).average().orElse(Double.NaN);

		System.out.printf("元データの平均: %.3f%n", Arrays.stream(originalData).average().orElse(Double.NaN));
		System.out.printf("ノイズ付加後の平均（復元の目安）: %.3f%n", estimatedMean);
	}
}
