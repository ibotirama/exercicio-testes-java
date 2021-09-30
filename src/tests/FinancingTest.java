package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;

class FinancingTest {

	@Test
	void shouldCreateTheObjectWhenDataIsValid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		assertNotNull(financing);
		assertEquals(100000.0, financing.getTotalAmount());
		assertEquals(3500.0, financing.getIncome());
		assertEquals(48, financing.getMonths());
	}

	@Test
	void shouldThrowAnExceptionWhenDataIsInvalid() {
		org.junit.jupiter.api.function.Executable executable = () -> {
			new Financing(100000.0, 2000.0, 20);
		};
		
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@Test
	void setTotalAmountShouldUpdateDataWhenItIsValid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		double newValue = 101000.0;
		financing.setTotalAmount(newValue);
				
		assertEquals(newValue, financing.getTotalAmount());
	}

	@Test
	void setTotalAmountShouldThrowAnExceptionWhenDataIsInvalid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		double newValue = 200000.0;
		org.junit.jupiter.api.function.Executable executable = () -> {
			financing.setTotalAmount(newValue);
		};
		
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@Test
	void setIncomeShouldUpdateDataWhenItIsValid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		double newValue = 4000.0;
		financing.setIncome(newValue);
				
		assertEquals(newValue, financing.getIncome());
	}

	@Test
	void setIncomeShouldThrowAnExceptionWhenDataIsInvalid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		double newValue = 2000.0;
		org.junit.jupiter.api.function.Executable executable = () -> {
			financing.setIncome(newValue);
		};
		
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@Test
	void setMonthsUpdateDataWhenItIsValid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		int newValue = 50;
		financing.setMonths(newValue);
				
		assertEquals(newValue, financing.getMonths());
	}

	@Test
	void setMonthsShouldThrowAnExceptionWhenDataIsInvalid() {
		Financing financing = new Financing(100000.0, 3500.0, 48);
		int newValue = 20;
		org.junit.jupiter.api.function.Executable executable = () -> {
			financing.setMonths(newValue);
		};
		
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@Test
	void entryShouldCalculateTheUpFrontPaymentValue() {
		double totalAmount = 100000.0;
		double twentyPercent = totalAmount * 0.20;
		Financing financing = new Financing(totalAmount, 3500.0, 48);
		
		assertEquals(twentyPercent, financing.entry());
	}

	@Test
	void quotaShouldCalculateTheMontlyPaymentValue() {
		double totalAmount = 100000.0;
		Financing financing = new Financing(totalAmount, 5000.0, 40);
		
		assertEquals(2000.0, financing.quota());
	}

	
}
