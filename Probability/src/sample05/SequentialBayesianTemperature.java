package sample05;

public class SequentialBayesianTemperature {

	public static double[] updatePosterior(double muPrior, double varPrior, double obs, double varObs) {
		double varPosterior = 1.0 / (1.0 / varPrior + 1.0 / varObs);
		double muPosterior = varPosterior * (muPrior / varPrior + obs / varObs);
		return new double[] { muPosterior, varPosterior };
	}

	public static void main(String[] args) {
		// 初期の事前分布パラメータ(平均と分散)
		double muPrior = 20.0; // 例えば初期予測20度
		double varPrior = 4.0; // 初期の分散(不確実性)

		// 観測誤差の分散 (気温測定のバラつき)
		double varObs = 1.0;

		// 日々の観測気温データ(例)
		double[] observations = { 19.5, 20.2, 21.0, 20.7, 19.9, 20.1, 21.3 };

		System.out.println("日\t事後平均\t事後標準偏差");
		for (int day = 0; day < observations.length; day++) {
			double obs = observations[day];
			double[] posterior = updatePosterior(muPrior, varPrior, obs, varObs);

			muPrior = posterior[0];
			varPrior = posterior[1];

			System.out.printf("%d\t%.4f\t\t%.4f\n", day + 1, muPrior, Math.sqrt(varPrior));
		}
	}

}
