package ru.rsreu.fedyukin0515;

import ru.rsreu.fedyukin0515.resourcer.Resourcer;
import ru.rsreu.fedyukin0515.taxation.*;

public class Initializer {

	private Initializer() {
	}

	public static TaxList getTaxList() {
		Exemption exemption = new Exemption(TaxConstants.REFUND_PERCENT);
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
