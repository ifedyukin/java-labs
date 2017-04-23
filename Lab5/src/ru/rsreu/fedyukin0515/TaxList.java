package ru.rsreu.fedyukin0515;

import java.util.Arrays;
import ru.rsreu.fedyukin0515.taxation.Direct;
import ru.rsreu.fedyukin0515.resourcer.Resourcer;

public class TaxList {
	private Tax[] taxation;
	private Exemption exemption;

	public TaxList(Tax[] taxation, Exemption exemption) {
		this.taxation = taxation;
		this.exemption = exemption;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		double totalRefundSum = 0;
		double totalIncomeSum = 0;
		double totalTaxSum = 0;

		for (int i = 0; i < this.taxation.length; i++) {
			double taxSum = this.taxation[i].calculateTaxSum();
			totalRefundSum += this.taxation[i].calculateRefund(taxSum);
			totalIncomeSum += this.taxation[i].getIncomeSum();
			totalTaxSum += taxSum;

			result.append(this.taxation[i].toString());
		}

		result.append("\n").append(Resourcer.getString("message.refund")).append("\n")
			.append("\t").append(Resourcer.getString("message.reason")).append(this.exemption.getDescription())
			.append("\t").append(Resourcer.getString("message.percent")).append(this.exemption.getPercent());
		
		result.append("\n\n").append(Resourcer.getString("message.totalSum")).append("\n")
			.append("\t").append(Resourcer.getString("message.income")).append(totalIncomeSum)
			.append("\t").append(Resourcer.getString("message.tax")).append(totalTaxSum)
			.append("\t").append(Resourcer.getString("message.refund")).append(": ").append(totalRefundSum)
			.append("\n").append(Resourcer.getString("work.line")).append("\n");

		return result.toString();
	}

	public void sortByType() {
		Arrays.sort(this.taxation, Comparators.sortByType);
	}

	public void sortBySum() {
		Arrays.sort(this.taxation, Comparators.sortBySum);
	}

	public String findDirectByIncomeSum(double sum) {
		Direct obj = new Direct(sum, this.exemption);
		int searchIndex = Arrays.binarySearch(this.taxation, obj, Comparators.findBySum);

		if (searchIndex < 0) {
			return Resourcer.getString("work.noResult");
		} else {
			return this.taxation[searchIndex].toString();
		}
	}

	public double getTotalSum() {
		double sum = 0;

		for (int i = 0; i < this.taxation.length; i++) {
			sum += this.taxation[i].calculateTaxSum();
		}

		return sum;
	}
}
