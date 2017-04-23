package ru.rsreu.fedyukin0515;

import java.util.Comparator;
import ru.rsreu.fedyukin0515.Tax;

public class Comparators {
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
			return (int) (o1.calculateTaxSum() - o2.calculateTaxSum()) / 13 * 100;
		}
	};
}
