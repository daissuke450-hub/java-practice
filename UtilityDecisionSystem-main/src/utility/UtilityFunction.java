package utility;

import model.DecisionContext;
import model.Option;

public interface UtilityFunction {

	// 効用関数インターフェイス
	double evaluate(Option option, DecisionContext context);

}
