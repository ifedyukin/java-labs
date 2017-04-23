package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.resourcer.Resourcer;

public abstract class Tax {
	private double percent;
	private double incomeSum;
	private Exemption exemption;
	
	public Tax(double percent, double incomeSum, Exemption exemption) {
		if (percent < 100 && percent > 0) {
			this.percent = percent;			
		} else {
			throw new IllegalArgumentException(Resourcer.getString("error.incorrectPercent"));
		}
		
		this.incomeSum = incomeSum;
		this.exemption = exemption;
	}
	
	public double calculateTaxSum() {
		return this.incomeSum * this.percent / 100;
	}
	
	public double calculateRefund(double fullTaxSum) {
		if (fullTaxSum < 0) {
			throw new IllegalArgumentException(Resourcer.getString("error.incorrectTaxSum"));
		}
		
		return fullTaxSum * this.exemption.getPercent() / 100;
	}
	
	public abstract String getType();
	
	public double getIncomeSum() {
		return this.incomeSum;
	}
	
}
