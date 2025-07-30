package sample02;

import java.util.List;

public class StockAnalyzer {

	private double highestHigh = Double.MIN_VALUE;
	private double lowestLow = Double.MAX_VALUE;

	public void analyze(List<StockRecord> records) {

		for (StockRecord record : records) {
			if (record.getHigh() > highestHigh) {
				highestHigh = record.getHigh();
			}

			if (record.getLow() < lowestLow) {
				lowestLow = record.getLow();
			}

		}

	}

	public double getHighestHigh() {
		return highestHigh;
	}

	public double getLowestLow() {
		return lowestLow;
	}

}
