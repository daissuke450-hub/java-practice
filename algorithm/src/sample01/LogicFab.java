package sample01;

public class LogicFab {

	public void ret(double low, double high) {

		double[] levels = { 0.236, 0.382, 0.500, 0.618, 0.786 };

		for (double level : levels) {
			double retracement = high - (high - low) * level;
			System.out.printf("%.1f%%戻し: %.2f円%n", level * 100, retracement);

		}

	}

}
