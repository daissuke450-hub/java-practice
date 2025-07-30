package sample02;

public class FibonacciEvaluator {

	private double high;
	private double low;

	// フィボナッチ比率
	private static final double[] FIB_LEVELS = { 0.236, 0.382, 0.500, 0.618, 0.786 };

	public FibonacciEvaluator(double high, double low) {
		this.high = high;
		this.low = low;
	}

	public void printFibonacciLevels() {
		System.out.println("【フィボナッチ押し目価格帯】");
		for (double level : FIB_LEVELS) {
			double retracementPrice = high - (high - low) * level;
			System.out.printf("%.1f%%戻し: %.2f%n", level * 100, retracementPrice);
		}
	}

	public String getNearestLevel(double currentPrice) {
		double minDiff = Double.MAX_VALUE;
		double nearestLevel = 0.0;
		double nearestPrice = 0.0;

		for (double level : FIB_LEVELS) {
			double retracementPrice = high - (high - low) * level;
			double diff = Math.abs(currentPrice - retracementPrice);
			if (diff < minDiff) {
				minDiff = diff;
				nearestLevel = level;
				nearestPrice = retracementPrice;
			}

		}
		return String.format("現在価格 %.2f は %.1f%%戻し（%.2f）に最も近いです。",
				currentPrice, nearestLevel * 100, nearestPrice);

	}
}
