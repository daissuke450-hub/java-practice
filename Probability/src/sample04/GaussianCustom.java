package sample04;

import java.util.Random;

public class GaussianCustom {

	/**
	 * 任意の平均μ・標準偏差σの正規分布に変換
	 * 
	 * X∼N(μ,σ)⇒X=μ+σ⋅Z
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Random random = new Random();

		double mu = 10.0; // 任意の平均
		double sigma = 2.0; // 任意の標準偏差

		for (int i = 0; i < 10; i++) {

			double z = random.nextGaussian();
			double x = mu + sigma * z;

			System.out.printf("%.3f%n", x);

		}

	}

}
