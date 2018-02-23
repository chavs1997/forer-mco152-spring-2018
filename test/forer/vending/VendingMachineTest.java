package forer.vending;

import static org.junit.Assert.*;

import org.junit.Test;

import forer.vending.Change;
import forer.vending.VendingMachine;

public class VendingMachineTest {

	@Test
	public void testPay1() {
		VendingMachine vend = new VendingMachine();
		Change result = new Change();
		result = vend.pay(3.00, 2.34);

		assertEquals(2, result.getNumOfQuarters());
		assertEquals(1, result.getNumOfDimes());
		assertEquals(1, result.getNumOfNickels());
		assertEquals(1, result.getNumOfPennies());
	}

	@Test
	public void testPay2() {
		VendingMachine vend = new VendingMachine();
		Change result = vend.pay(5.00, 4.11);

		assertEquals(3, result.getNumOfQuarters());
		assertEquals(1, result.getNumOfDimes());
		assertEquals(0, result.getNumOfNickels());
		assertEquals(4, result.getNumOfPennies());
	}

	@Test
	public void testPay3() {
		VendingMachine vend = new VendingMachine();
		Change result = vend.pay(3.00, 4.11);

		assertEquals(0, result.getNumOfQuarters());
		assertEquals(0, result.getNumOfDimes());
		assertEquals(0, result.getNumOfNickels());
		assertEquals(0, result.getNumOfPennies());

	}

	@Test
	public void testDoublePay() {
		VendingMachine vend = new VendingMachine();
		Change result = vend.pay(1.00, .99);

		assertEquals(0, result.getNumOfQuarters());
		assertEquals(0, result.getNumOfDimes());
		assertEquals(0, result.getNumOfNickels());
		assertEquals(1, result.getNumOfPennies());

		result = vend.pay(1.00, 1.00);

		assertEquals(0, result.getNumOfQuarters());
		assertEquals(0, result.getNumOfDimes());
		assertEquals(0, result.getNumOfNickels());
		assertEquals(0, result.getNumOfPennies());
	}

}
