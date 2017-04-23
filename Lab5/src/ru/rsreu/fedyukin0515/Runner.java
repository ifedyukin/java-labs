package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.taxation.*;
import ru.rsreu.fedyukin0515.resourcer.Resourcer;

public class Runner {
	private final static double SEARCH_SUM = 19000;

	public static void main(String[] args) {

		Exemption exemption = new Exemption(10);
		exemption.setDescription("Privileges");
		
		/*
		 * Array initialize
		 */
		Tax[] taxation = { new Transfer(5000, exemption, false), new Copyright(20000, exemption, true),
				new Direct(10000, exemption), new Transfer(3000, exemption, true) };

		TaxList taxList = new TaxList(taxation, exemption);

		/*
		 * Work
		 */
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