package io.github.nathanvegetable.numbers;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * JUnit Test class to ensure every class contained within package
 * io.github.nathanvegetable.numbers returns expected results.
 * 
 * @author NathanVegetable
 */
class TestNumbers {

	@Test
	void piMathShouldMatchHardcodePI15Digit() {
		double hardcodedPI15Digit = 3.141592653589793d;
		assertEquals(hardcodedPI15Digit, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION));
	}

	@Test
	void piMathShouldMatchHardcodePI14Digit() {
		double hardcodedPI14Digit = 3.14159265358979d;
		assertEquals(hardcodedPI14Digit,
				FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION - 1));
	}

	@Test
	void findToNthDigitShouldMatchHardcode() {
		double hardcodedPI3Digit = 3.14d;
		assertEquals(hardcodedPI3Digit, FindEToTheNthDigit.findWithStringFormat(Math.PI, 2));
	}

	@Test
	void fibonacciSequence7thDigitShouldBe8() {
		assertEquals(8, FibonacciSequence.getSequence(7)[6]);
	}

	@Test
	void fibonacciSequence20thDigitShouldBe4181() {
		assertEquals(4181, FibonacciSequence.getSequence(20)[19]);
	}

	@Test
	void primeFactorOf15ShouldBe3And5() {
		ArrayList<Integer> result = PrimeFactorization.findPrimeFactors(15);
		boolean[] found = new boolean[2];
		int[] lookingFor = new int[] { 3, 5 };
		for (int i = 0; i < result.size(); i++)
			for (int j = 0; j < lookingFor.length; j++)
				if (result.get(i) == lookingFor[j])
					found[j] = true;
		assertTrue(found[0] && found[1]);
	}

	@Test
	void nextPrimeNumberAfter1005ShouldBe1009() {
		assertEquals(1009, NextPrimeNumber.findNextPrimeNumber(1005));
		assertEquals(1009, NextPrimeNumber.findNextPrimeNumberWithBigInteger(1005));
	}

	@Test
	void costOf2x2Tiles2EachInFloor4x4ShouldBe8() {
		int tileSize = 2, floorSize = 4, cost = 2, expectedCost = 8;
		assertEquals(expectedCost,
				FindCostOfTileToCoverWxHFloor.findCostOfFloorPlan(cost, tileSize, tileSize, floorSize, floorSize));
	}

	@Test
	void mortgageOf10000At4PercentOver10YearsShouldBe101() {
		double monthlyPayment = MortgageCalculator.getLoanMonthlyPayment(10000d, 4d, 10d);
		monthlyPayment = Math.round(monthlyPayment);
		assertEquals(101, monthlyPayment);
	}

	@Test
	void changeReturnedFor41CentsShouldBe1OfEachCoin() {
		int[] allChange = ChangeReturn.getChange(BigDecimal.valueOf(1.00d), BigDecimal.valueOf(1.41d));
		for (int changeAmount : allChange)
			assertEquals(1, changeAmount);
	}

	@Test
	void binary1011ShouldBe11Decimal() {
		assertEquals(11, BinaryDecimalConverter.binaryToDecimal(1011));
		assertEquals(1011, BinaryDecimalConverter.decimalToBinary(11));
	}

	@Test
	void calculatorShouldDoMathCorrectly() {
		Calculator calculator = new Calculator(false);
		calculator.logic.insertNumber("50");
		calculator.logic.startCalculation("-");
		calculator.logic.insertNumber("40");
		calculator.logic.endCalculation();

		calculator.logic.startCalculation("x");
		calculator.logic.insertNumber("10");
		calculator.logic.endCalculation();

		int calculation = (50 - 40) * 10;
		assertEquals(calculation, Integer.parseInt(calculator.display.getText()));
	}

	@Test
	void dollarConvertedToNickelsShouldBe20() {
		assertEquals(20,
				UnitConverter.getValueOfAlternateUnit(1, UnitConverter.Currency.DOLLAR, UnitConverter.Currency.NICKEL));
	}

	@Test
	void oneMileShouldBe5280Feet() {
		assertEquals(5280,
				UnitConverter.getValueOfAlternateUnit(1, UnitConverter.Length.MILE, UnitConverter.Length.FOOT));
	}

}
