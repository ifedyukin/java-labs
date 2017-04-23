package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.resourcer.Resourcer;

public abstract class Tax {
	private double percent;
	private double incomeSum;
	private Exemption exemption;
	
	private static final double MAX_PERCENT = 100;
	private static final double MIN_PERCENT = 0;
	
	public Tax(double percent, double incomeSum, Exemption exemption) {
		if (percent < MAX_PERCENT && percent > MIN_PERCENT) {
			this.percent = percent;			
		} else {
			throw new IllegalArgumentException(Resourcer.getString("error.incorrectPercent"));
		}
		
		this.incomeSum = incomeSum;
		this.exemption = exemption;
	}
	
	public double calculateTaxSum() {
		return this.incomeSum * this.percent / MAX_PERCENT;
	}
	
	public double calculateRefund(double fullTaxSum) {
		if (fullTaxSum < 0) {
			throw new IllegalArgumentException(Resourcer.getString("error.incorrectTaxSum"));
		}
		
		return fullTaxSum * this.exemption.getPercent() / MAX_PERCENT;
	}
	
	public abstract String getType();
	
	public double getIncomeSum() {
		return this.incomeSum;
	}
	
}
