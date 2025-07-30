package utility;

import model.DecisionContext;
import model.Option;

public class SimpleUtilityFunction implements UtilityFunction {

	// 効用関数のモデル定義

	/** 効用 = 利益 - λ×リスク^2 - β×資源使用量 + γ×戦略優先度 */
	@Override
	public double evaluate(Option option, DecisionContext context) {
		return option.getExpectedProfit()
				- context.getRiskTolerance() * Math.pow(option.getRiskLevel(), 2)
				- context.getResourceWeight() * option.getResourceUsage()
				+ context.getPriorityWeight() * option.getStrategicPriority();
	}

}
