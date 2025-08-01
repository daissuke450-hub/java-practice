package sample03;

public class ConditionalProbability {

	/**
	 * 条件付確率基本
	 * 
	 * 男性かつコーヒー好きの人の確率
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 人数の定義
		int maleCoffeeLovers = 40;
		int femaleCoffeeeLovers = 30;
		int totalCoffeeLovers = maleCoffeeLovers + femaleCoffeeeLovers;

		// 条件付確率 P(男性|コーヒー好き)
		double pMaleGivenCoffee = (double) maleCoffeeLovers / totalCoffeeLovers;

		System.out.println("P(男性|コーヒー好き) =" + pMaleGivenCoffee);

	}

}
