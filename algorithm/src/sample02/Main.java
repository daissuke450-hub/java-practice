package sample02;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		CsvLoader loader = new CsvLoader();

		try {
			List<StockRecord> records = loader.load("stock_data.csv");

			//			// 株価出力 (確認)
			//			for (StockRecord r : records) {
			//				System.out.println(r);
			//
			//			}

			// 分析開始(期間内の最大、最小)
			StockAnalyzer analyzer = new StockAnalyzer();
			analyzer.analyze(records);

			double high = analyzer.getHighestHigh();
			double low = analyzer.getLowestLow();

			System.out.println("\n【分析結果】");
			System.out.println("期間中の最高値" + high);
			System.out.println("期間中の最安地" + low);

			FibonacciEvaluator evaluator = new FibonacciEvaluator(high, low);
			evaluator.printFibonacciLevels();

			Scanner scanner = new Scanner(System.in);

			System.out.println("現在の価格を入力してください");

			double currentPrice = scanner.nextDouble();

			String result = evaluator.getNearestLevel(currentPrice);

			System.out.println(result);

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
