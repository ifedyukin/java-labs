package ru.rsreu.fedyukin0515;

import java.util.Comparator;
import ru.rsreu.fedyukin0515.Tax;

public class Comparators {	
	private static final double TAX_PERCENT = 13;
	private static final double MAX_PERCENT = 100;
	
	public Comparators(){
	}
	
	/*
	 * Sorting by type of tax
	 */
	public static Comparator<Tax> sortByType = new Comparator<Tax>() {
		public int compare(Tax o1, Tax o2) {
			return o1.getType().compareTo(o2.getType());
		}
	};

	/*
	 * Sorting by sum of tax
	 */
	public static Comparator<Tax> sortBySum = new Comparator<Tax>() {
		public int compare(Tax o1, Tax o2) {
			return (int) (o2.calculateTaxSum() - o1.calculateTaxSum());
		}
	};

	/*
	 * Find by incoming sum
	 */
	public static Comparator<Tax> findBySum = new Comparator<Tax>() {
		public int compare(Tax o1, Tax o2) {
			return (int) ((int) (o1.calculateTaxSum() - o2.calculateTaxSum()) / TAX_PERCENT * MAX_PERCENT);
		}
	};
}
