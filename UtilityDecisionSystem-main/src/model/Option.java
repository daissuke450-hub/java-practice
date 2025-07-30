package model;

public class Option {

	// 案の名前
	private String name;
	// 期待利益
	private double expectedProfit;
	// リスク
	private double riskLevel;
	// リソース量
	private double resourceUsage;
	// 案の優先度
	private double strategicPriority;

	public Option(String name, double expectedProfit, double riskLevel,
			double resourceUsage, double strategicPriority) {

		this.name = name;
		this.expectedProfit = expectedProfit;
		this.riskLevel = riskLevel;
		this.resourceUsage = resourceUsage;
		this.strategicPriority = strategicPriority;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getExpectedProfit() {
		return expectedProfit;
	}

	public void setExpectedProfit(double expectedProfit) {
		this.expectedProfit = expectedProfit;
	}

	public double getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(double riskLevel) {
		this.riskLevel = riskLevel;
	}

	public double getResourceUsage() {
		return resourceUsage;
	}

	public void setResourceUsage(double resourceUsage) {
		this.resourceUsage = resourceUsage;
	}

	public double getStrategicPriority() {
		return strategicPriority;
	}

	public void setStrategicPriority(double strategicPriority) {
		this.strategicPriority = strategicPriority;
	}

}
