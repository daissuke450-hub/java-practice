package model;

public class DecisionContext {

	// リスク量
	private double riskTolerance;
	// リソースの重さ
	private double resourceWeight;
	// 優先度の重さ
	private double priorityWeight;

	public double getRiskTolerance() {
		return riskTolerance;
	}

	public void setRiskTolerance(double riskTolerance) {
		this.riskTolerance = riskTolerance;
	}

	public double getResourceWeight() {
		return resourceWeight;
	}

	public void setResourceWeight(double resourceWeight) {
		this.resourceWeight = resourceWeight;
	}

	public double getPriorityWeight() {
		return priorityWeight;
	}

	public void setPriorityWeight(double priorityWeight) {
		this.priorityWeight = priorityWeight;
	}

}
