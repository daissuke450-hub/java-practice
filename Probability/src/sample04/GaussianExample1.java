package sample04;

import java.util.Random;

public class GaussianExample1 {

	public static void main(String[] args) {
		Random random = new Random();

		// 100000回生成
		int count = 100_000;
		double sum = 0;
		double sumSq = 0;

		for (int i = 0; i < count; i++) {
			double x = random.nextGaussian(); // 平均0かつ標準偏差1	
			sum += x;
			sumSq = x * x;
		}

		double mean = sum / count; // 平均算出
		double variance = (sumSq / count) - (mean * mean); // 分散算出
		double stddev = Math.sqrt(variance); // 標準偏差算出

		System.out.printf("平均：%.5f\n", mean);
		System.out.printf("標準偏差： %.5f\n", stddev);

	}

}
