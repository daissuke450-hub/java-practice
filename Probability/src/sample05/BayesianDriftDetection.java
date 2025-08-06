package sample05;

public class BayesianDriftDetection {

	// ベイズ推定の事後平均と事後分散を計算
	public static double[] estimatePosterior(double[] data, double mu0, double tau2, double sigma2) {
		int n = data.length;
		double sum = 0.0;
		for (double x : data) {
			sum += x;
		}

		double xBar = sum / n;

		double tauN2 = 1.0 / (n / sigma2 + 1.0 / tau2);
		double muN = tauN2 * (n * xBar / sigma2 + mu0 / tau2);

		return new double[] { muN, tauN2 };
	}

	// 乖離判定(事後平均と事前平均の差が閾値以上なら乖離あり)
	public static boolean isDrift(double mu0, double muN, double threshold) {
		double diff = Math.abs(muN - mu0);
		return diff > threshold;

	}

	public static void main(String[] args) {
		// 事前平均・事前分散
		double mu0 = 10.0;
		double tau2 = 1.0;

		// 観測データの分散(誤差の大きさ)
		double sigma2 = 0.25;

		// 観測データ例 正常バージョン
		double[] dataNormal = { 9.8, 10.1, 10.0, 9.9, 10.2 };

		// 観測データ例 乖離パターン
		double[] dataDrift = { 11.5, 11.7, 11.2, 11.4, 11.6 };

		// 閾値(この差以上なら異常)
		double threshold = 0.5;

		// 正常データの判定
		double[] posteriorNormal = estimatePosterior(dataNormal, mu0, tau2, sigma2);
		boolean driftNormal = isDrift(mu0, posteriorNormal[0], threshold);

		System.out.printf("正常データ 事後平均 μ_n: %.4f\n", posteriorNormal[0]);
		System.out.println("正常データ 乖離検知: " + (driftNormal ? "あり" : "なし"));

		// 乖離データの判定
		double[] posteriorDrift = estimatePosterior(dataDrift, mu0, tau2, sigma2);
		boolean driftDrift = isDrift(mu0, posteriorDrift[0], threshold);

		System.out.printf("乖離データ 事後平均 μ_n: %.4f\n", posteriorDrift[0]);
		System.out.println("乖離データ 乖離検知: " + (driftDrift ? "あり" : "なし"));
	}

}
