package logic;

import java.util.Comparator;
import java.util.List;

import model.DecisionContext;
import model.Option;
import utility.UtilityFunction;

public class DecisionEvaluator {
	private UtilityFunction utility;

	public DecisionEvaluator(UtilityFunction utility) {
		this.utility = utility;
	}

	public Option evaluateBest(List<Option> options, DecisionContext context) {
		return options.stream().max(Comparator.comparingDouble(o -> utility.evaluate(o, context)))
				.orElse(null);

	}

}
