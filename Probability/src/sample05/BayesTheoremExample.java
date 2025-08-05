package sample05;

public class BayesTheoremExample {

	public static void main(String[] args) {
		// 事前確率
		double pDisease = 0.01; // 病気である確率
		double pNoDisease = 1 - pDisease; // 病気でない確率

		// 条件付確率
		double pPosGivenDisease = 0.99; // 病気の人が陽性
		double pPosGivenNoDisease = 0.05; // 健康な人が誤って陽性

		// 陽性になる全体の確率(正規化)
		double pPositive = (pPosGivenDisease * pDisease) +
				(pPosGivenNoDisease * pNoDisease);

		// ベイズの定理で逆方向の条件付確率
		double pDiseaseGivenPositive = (pPosGivenDisease * pDisease) / pPositive;

		System.out.printf("検査で陽性だったとき、実際に病気である確率：%.2f%%\n", pDiseaseGivenPositive * 100);

	}

}
