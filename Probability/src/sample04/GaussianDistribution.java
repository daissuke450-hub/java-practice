package sample04;

import java.util.Random;

public class GaussianDistribution {

	public static void main(String[] args) {
		Random random = new Random();

		int trials = 100_000;
		double sum = 0;
		double sumSquares = 0;

		for (int i = 0; i < trials; i++) {
			double value = random.nextGaussian(); // 平均0, 標準偏差1
			sum += value;
			sumSquares += value * value;
		}

		double mean = sum / trials;
		double variance = (sumSquares / trials) - (mean * mean);
		double stddev = Math.sqrt(variance);

		System.out.printf("平均： %.5f\n", mean);
		System.out.printf("標準偏差： %.5f\n", stddev);

	}

}
