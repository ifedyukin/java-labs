package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.resourcer.Resourcer;

public class Runner {
	private static final double SEARCH_SUM = 19000;
	
	public Runner() {
	}

	public static void main(String[] args) {
		TaxList taxList = Initializer.getTaxList();

		StringBuilder result = new StringBuilder();
		
		taxList.sortBySum();
		result.append(Resourcer.getString("message.sortedBySum")).append("\n").append(taxList.toString());

		taxList.sortByType();
		result.append(Resourcer.getString("message.sortedByType")).append("\n").append(taxList.toString());
		
		taxList.findDirectByIncomeSum(SEARCH_SUM);
		result.append(Resourcer.getString("message.searchResult")).append("\n").append(taxList.toString());
		
		System.out.println(result.toString());
		
	}
}