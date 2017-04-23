package ru.rsreu.fedyukin0515.taxation;

import ru.rsreu.fedyukin0515.Tax;
import ru.rsreu.fedyukin0515.TaxConstants;
import ru.rsreu.fedyukin0515.resourcer.Resourcer;
import ru.rsreu.fedyukin0515.Exemption;

public class Transfer extends Tax {
	private boolean isGift;
	
	public Transfer(double incomeSum, Exemption exemption, boolean isGift) {
		super(TaxConstants.TRANSFER_TAX_PERCENT, incomeSum, exemption);
		this.isGift = isGift;
	}
	
	@Override
	public double calculateTaxSum() {
		if (this.isGift) {
			return 0;
		} else {
			double fullTaxSum = super.calculateTaxSum();
			return fullTaxSum - super.calculateRefund(fullTaxSum);
		}
	}
	
	@Override
	public String getType() {
		return Resourcer.getString("type.transfer");
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getType())
			.append("\n\t").append(Resourcer.getString("message.income")).append(super.getIncomeSum())
			.append("\t").append(Resourcer.getString("message.sum")).append(this.calculateTaxSum())
			.append("\t").append(Resourcer.getString("message.percent"))
				.append(this.isGift ? 0 : TaxConstants.TRANSFER_TAX_PERCENT)
			.append("\n");
		
		return result.toString();
	}
	
}
