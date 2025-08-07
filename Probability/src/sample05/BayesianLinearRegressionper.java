package sample05;

public class BayesianLinearRegressionper {

	// 事前分布パラメータ（平均と分散）
	private double muPrior;
	private double varPrior;

	// 観測ノイズの分散（既知）
	private final double varNoise;

	public BayesianLinearRegressionper(double muPrior, double varPrior, double varNoise) {
		this.muPrior = muPrior;
		this.varPrior = varPrior;
		this.varNoise = varNoise;
	}

	public void update(double x, double y) {
		// 予測平均
		double muLik = y / x;
		double varLik = varNoise;

		// ベイズ更新
		double varPost = 1.0 / (1.0 / varPrior + 1.0 / varLik);
		double muPost = varPost * (muPrior / varPrior + muLik / varLik);

		muPrior = muPost;
		varPrior = varPost;
	}

	public double predict(double x) {
		return muPrior * x;
	}

	public static void main(String[] args) {
		// 初期事前分布（平均0, 分散1）
		BayesianLinearRegressionper model = new BayesianLinearRegressionper(0.0, 1.0, 0.5);

		// トレーニングデータ（x, y）
		double[][] data = {
				{ 1.0, 2.1 },
				{ 2.0, 3.9 },
				{ 3.0, 6.2 },
				{ 4.0, 7.9 }
		};

		for (int i = 0; i < data.length; i++) {
			double x = data[i][0];
			double y = data[i][1];
			model.update(x, y);
			System.out.printf("Step %d: wの平均=%.4f, 分散=%.4f%n", i + 1, model.muPrior, model.varPrior);
		}

		// 予測例
		double testX = 5.0;
		double predY = model.predict(testX);
		System.out.printf("x=%.2f の予測y=%.4f%n", testX, predY);
	}

}