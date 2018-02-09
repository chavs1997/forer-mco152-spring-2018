package forer.Vending;

public class Change {
	private int quarter = 25;
	private int dime = 10;
	private int nickel = 5;
	private int penny = 1;

	private int numOfQuarters;
	private int numOfDimes;
	private int numOfNickels;
	private int numOfPennies;
	
	
	
	public int getNumOfQuarters() {
		return numOfQuarters;
	}

	public void setNumOfQuarters(int numOfQuarters) {
		this.numOfQuarters = numOfQuarters;
	}

	public int getNumOfDimes() {
		return numOfDimes;
	}

	public void setNumOfDimes(int numOfDimes) {
		this.numOfDimes = numOfDimes;
	}

	public int getNumOfNickels() {
		return numOfNickels;
	}

	public void setNumOfNickels(int numOfNickels) {
		this.numOfNickels = numOfNickels;
	}

	public int getNumOfPennies() {
		return numOfPennies;
	}

	public void setNumOfPennies(int numOfPennies) {
		this.numOfPennies = numOfPennies;
	}

	public int getQuarter() {
		return quarter;
	}

	public int getDime() {
		return dime;
	}

	public int getNickel() {
		return nickel;
	}

	public int getPenny() {
		return penny;
	}

}
