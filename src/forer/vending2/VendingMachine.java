package forer.vending2;

public class VendingMachine {

	public Change pay(double _totalPaid, double _totalPurchase) {

		Change chan = new Change();
		int totalPurchase;
		int totalPaid;

		totalPurchase = (int) (_totalPurchase * 100);
		totalPaid = (int) (_totalPaid * 100);
		int amountLeft = 0;
		if ((totalPaid - totalPurchase) > 0) {
			amountLeft = totalPaid - totalPurchase;
		}

		if (amountLeft >= chan.getQuarter()) {
			chan.setNumOfQuarters(amountLeft / chan.getQuarter());
			amountLeft = amountLeft - (chan.getNumOfQuarters() * chan.getQuarter());
		}
		if (amountLeft >= chan.getDime()) {
			chan.setNumOfDimes(amountLeft / chan.getDime());
			amountLeft = amountLeft - (chan.getNumOfDimes() * chan.getDime());
		}
		if (amountLeft >= chan.getNickel()) {
			chan.setNumOfNickels(amountLeft / chan.getNickel());
			amountLeft = amountLeft - (chan.getNumOfNickels() * chan.getNickel());
		}
		if (amountLeft >= chan.getPenny()) {
			chan.setNumOfPennies(amountLeft / chan.getPenny());
			amountLeft = amountLeft - (chan.getNumOfPennies() * chan.getPenny());
		}

		return chan;
	}

}
