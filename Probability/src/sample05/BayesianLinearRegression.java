package sample05;

public class BayesianLinearRegression {

	// X: 気温、季節の2次元配列
	// y: 売上
	public static double[] fitLinearModel(double[][] X, double[] y) {
		int n = X.length;

		double sumX1 = 0, sumX2 = 0, sumY = 0;
		double sumX1Y = 0, sumX2Y = 0;
		double sumX1X1 = 0, sumX2X2 = 0;

		for (int i = 0; i < n; i++) {
			double x1 = X[i][0]; // 気温
			double x2 = X[i][1]; // 季節（数値）
			double yi = y[i];

			sumX1 += x1;
			sumX2 += x2;
			sumY += yi;
			sumX1Y += x1 * yi;
			sumX2Y += x2 * yi;
			sumX1X1 += x1 * x1;
			sumX2X2 += x2 * x2;
		}

		// 単純な2変数最小二乗法（正規方程式の簡易版）
		// 係数 β1（気温）, β2（季節）
		double beta1 = (sumX1Y - sumX1 * sumY / n) / (sumX1X1 - sumX1 * sumX1 / n);
		double beta2 = (sumX2Y - sumX2 * sumY / n) / (sumX2X2 - sumX2 * sumX2 / n);
		double beta0 = (sumY - beta1 * sumX1 - beta2 * sumX2) / n;

		return new double[] { beta0, beta1, beta2 };
	}

	public static void main(String[] args) {
		// 気温と季節のデータ（気温, 季節コード：春=1, 夏=2, 秋=3, 冬=4）
		double[][] X = {
				{ 25.0, 2 }, // 夏
				{ 30.0, 2 },
				{ 20.0, 1 }, // 春
				{ 15.0, 4 }, // 冬
				{ 10.0, 4 },
				{ 18.0, 3 }, // 秋
		};

		// 売上（仮の観測値）
		double[] y = { 200, 300, 150, 50, 30, 100 };

		double[] beta = fitLinearModel(X, y);

		System.out.printf("回帰係数 β0（切片）: %.2f\n", beta[0]);
		System.out.printf("回帰係数 β1（気温）: %.2f\n", beta[1]);
		System.out.printf("回帰係数 β2（季節）: %.2f\n", beta[2]);

		// 新しい予測
		double newTemp = 28.0;
		int newSeason = 2; // 夏

		double predicted = beta[0] + beta[1] * newTemp + beta[2] * newSeason;
		System.out.printf("予測売上（%.1f℃ 夏）: %.2f\n", newTemp, predicted);
	}
}
