package ru.rsreu.fedyukin0515.taxation;

import ru.rsreu.fedyukin0515.Tax;
import ru.rsreu.fedyukin0515.resourcer.Resourcer;
import ru.rsreu.fedyukin0515.Exemption;

public class Direct extends Tax {
	public Direct(double incomeSum, Exemption exemption) {
		super(13, incomeSum, exemption);
	}

	@Override
	public double calculateTaxSum() {
		double fullTaxSum = super.calculateTaxSum();
		return fullTaxSum - super.calculateRefund(fullTaxSum);
	}
	
	@Override
	public String getType() {
		return Resourcer.getString("type.direct");
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getType())
			.append("\n\t").append(Resourcer.getString("message.income")).append(super.getIncomeSum())
			.append("\t").append(Resourcer.getString("message.sum")).append(this.calculateTaxSum())
			.append("\t").append(Resourcer.getString("message.percent")).append("13").append("\n");

		return result.toString();
	}

}
