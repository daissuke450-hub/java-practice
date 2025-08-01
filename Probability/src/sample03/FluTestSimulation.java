package sample03;

public class FluTestSimulation {

	/**
	 * 条件付確率基本
	 * 
	 * 風と検査陽性 P(風邪あり∣陽性)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// データ状況(1000人)

		// 陽性かつ風邪
		int fluAndPositive = 80;
		// 陰性かつ風邪
		int fluAndNegative = 20;
		// 陽性かつ風邪なし
		int noFulAndPositive = 90;
		// 陰性かつ風邪なし
		int noFulAndNegative = 810;

		// 陽性の合計人数
		int totalPositive = fluAndPositive + noFulAndPositive;

		// 検査が陽性だった人のうち、実際に風邪を引いている確率
		double pFluGivenPositive = (double) fluAndPositive / totalPositive;

		System.out.println("P(風邪あり∣陽性) =" + pFluGivenPositive);
	}

}
