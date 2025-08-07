package sample05;

public class BayesianUpdate {

	public static double[] update(double muPrior, double varPrior, double muLik, double varLik) {

		double varPost = (varPrior * varLik) / (varPrior + varLik);
		double muPost = (varLik * muPrior + varPrior * muLik) / (varPrior + varLik);
		return new double[] { muPost, varPost };
	}

	public static void main(String[] args) {

		// 事前分布の平均と分散
		double muPrior = 0.0;
		double varPrior = 1.0;

		// 尤度分布の平均と分散
		double muLik = 1.2;
		double varLik = 2.0;

		double[] post = update(muPrior, varPrior, muLik, varLik);

		System.out.printf("事後分布の平均: %.4f%n", post[0]);
		System.out.printf("事後分布の分散: %.4f%n", post[1]);

	}

}
