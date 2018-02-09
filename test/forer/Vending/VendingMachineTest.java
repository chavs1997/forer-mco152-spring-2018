package forer.Vending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

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
		int[] result = vend.pay(5.00, 4.11);

		int numOfQuartersTest = result[0];
		int numOfDimesTest = result[1];
		int numOfNickelsTest = result[2];
		int numOfPenniesTest = result[3];

		assertEquals(3, numOfQuartersTest);
		assertEquals(1, numOfDimesTest);
		assertEquals(0, numOfNickelsTest);
		assertEquals(4, numOfPenniesTest);
	}

	@Test
	public void testPay3() {
		VendingMachine vend = new VendingMachine();
		int[] result = vend.pay(3.00, 4.11);

		int numOfQuartersTest = result[0];
		int numOfDimesTest = result[1];
		int numOfNickelsTest = result[2];
		int numOfPenniesTest = result[3];

		assertEquals(0, numOfQuartersTest);
		assertEquals(0, numOfDimesTest);
		assertEquals(0, numOfNickelsTest);
		assertEquals(0, numOfPenniesTest);
	}
	
	@Test
	public void testDoublePay() {
		VendingMachine vend = new VendingMachine();
		int[] result = vend.pay(1.00, .99);

		int numOfQuartersTest = result[0];
		int numOfDimesTest = result[1];
		int numOfNickelsTest = result[2];
		int numOfPenniesTest = result[3];

		assertEquals(0, numOfQuartersTest);
		assertEquals(0, numOfDimesTest);
		assertEquals(0, numOfNickelsTest);
		assertEquals(1, numOfPenniesTest);
		
		result = vend.pay(1.00, 1.00);
		

		numOfQuartersTest = result[0];
		numOfDimesTest = result[1];
		numOfNickelsTest = result[2];
		numOfPenniesTest = result[3];

		assertEquals(0, numOfQuartersTest);
		assertEquals(0, numOfDimesTest);
		assertEquals(0, numOfNickelsTest);
		assertEquals(0, numOfPenniesTest);
	}

}
