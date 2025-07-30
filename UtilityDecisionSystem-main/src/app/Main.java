package app;

import java.io.IOException;
import java.util.List;

import io.CsvLoader;
import io.ResultWriter;
import logic.DecisionEvaluator;
import model.DecisionContext;
import model.Option;
import utility.SimpleUtilityFunction;
import utility.UtilityFunction;

public class Main {

	public static void main(String[] args) throws IOException {

		CsvLoader loader = new CsvLoader();
		List<Option> options = loader.load("options.csv");

		DecisionContext context = new DecisionContext();

		// リスク回避型
		context.setRiskTolerance(0.8);

		context.setResourceWeight(0.3);

		context.setPriorityWeight(0.8);

		UtilityFunction utility = new SimpleUtilityFunction();
		DecisionEvaluator evaluator = new DecisionEvaluator(utility);
		Option best = evaluator.evaluateBest(options, context);

		System.out.println("一番いい案は：" + best.getName());

		ResultWriter writer = new ResultWriter();
		writer.write(best, "result.txt");

	}

}
