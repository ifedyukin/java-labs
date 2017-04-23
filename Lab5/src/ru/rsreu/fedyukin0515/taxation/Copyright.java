package ru.rsreu.fedyukin0515.taxation;

import ru.rsreu.fedyukin0515.Tax;
import ru.rsreu.fedyukin0515.resourcer.Resourcer;
import ru.rsreu.fedyukin0515.Exemption;
import ru.rsreu.fedyukin0515.TaxConstants;

public class Copyright extends Tax {
	private boolean isResident;
	private double incomeSum;

	public Copyright(double incomeSum, Exemption exemption, boolean isResident) {
		super(TaxConstants.COPYRIGHT_TAX_PERCENT, incomeSum, exemption);

		this.incomeSum = incomeSum;
		this.isResident = isResident;
	}

	@Override
	public double calculateTaxSum() {
		double fullTaxSum = super.calculateTaxSum();

		if (this.isResident) {
			return fullTaxSum - super.calculateRefund(fullTaxSum);
		} else {
			return fullTaxSum + this.incomeSum 
					* (TaxConstants.MAX_COPYRIGHT_TAX_PERCENT - TaxConstants.COPYRIGHT_TAX_PERCENT) 
					/ TaxConstants.ABSOLUTE_MAX_PERCENT;
		}
	}
	
	@Override
	public String getType() {
		return Resourcer.getString("type.copyright");
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getType())
			.append("\n\t").append(Resourcer.getString("message.income")).append(super.getIncomeSum())
			.append("\t").append(Resourcer.getString("message.sum")).append(this.calculateTaxSum())
			.append("\t").append(Resourcer.getString("message.percent"))
				.append(this.isResident ? TaxConstants.COPYRIGHT_TAX_PERCENT : TaxConstants.MAX_COPYRIGHT_TAX_PERCENT)
			.append("\n");
		
		return result.toString();
	}
}
