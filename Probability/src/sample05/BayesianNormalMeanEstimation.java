package sample05;

public class BayesianNormalMeanEstimation {

	// ベイズ推定に基づく平均と分散を計算する
	public static double[] estimatePosterior(double[] data, double mu0, double tau2, double sigma2) {
		int n = data.length;

		double sum = 0.0;

		for (double x : data) {
			sum += x;
		}

		double xBar = sum / n;

		// 事後分散
		double tauN2 = 1.0 / (n / sigma2 + 1.0 / tau2);

		// 事後平均
		double muN = tauN2 * (n * xBar / sigma2 + mu0 / tau2);

		return new double[] { muN, tauN2 };

	}

	public static void main(String[] args) {
		// 観測データ(例)
		double[] data = { 9.8, 10.1, 10.5, 9.7, 10.2 };

		// 事前平均と分散
		double mu0 = 10.0; // 事前の平均(仮)
		double tau2 = 1.0; // 事前分布の分散(どれだけ信じるか)

		// 観測でデータの既知の分散
		double sigma2 = 0.25; // σ² = 0.5²

		double[] result = estimatePosterior(data, mu0, tau2, sigma2);

		System.out.printf("事後平均 μ_n: %.4f\n", result[0]);
		System.out.printf("事後分散 τ_n^2: %.4f\n", result[1]);
		System.out.printf("事後標準偏差 τ_n: %.4f\n", Math.sqrt(result[1]));

	}

}
