package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.resourcer.Resourcer;
import ru.rsreu.fedyukin0515.taxation.Copyright;
import ru.rsreu.fedyukin0515.taxation.Direct;
import ru.rsreu.fedyukin0515.taxation.Transfer;

public class Initializer {
	private static final double REFUND_PERCENT = 10;

	public Initializer() {
	}

	public static TaxList getTaxList() {
		Exemption exemption = new Exemption(REFUND_PERCENT);
		exemption.setDescription(Resourcer.getString("message.exemptionDescription"));

		Tax[] taxation = { 
				new Transfer(5000, exemption, false), 
				new Copyright(20000, exemption, true),
				new Direct(10000, exemption), 
				new Transfer(3000, exemption, true) 
		};

		return new TaxList(taxation, exemption);
	}
}
