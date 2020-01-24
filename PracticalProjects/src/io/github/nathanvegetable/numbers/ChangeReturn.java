package io.github.nathanvegetable.numbers;

import java.util.Scanner;

/**
 * Change Return Program - The user enters a cost and then the amount of money
 * given. The program will figure out the change and the number of quarters,
 * dimes, nickels, pennies needed for the change.
 * 
 * @author NathanVegetable
 *
 */
public class ChangeReturn {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the initial cost: ");
		double cost = inputScanner.nextDouble();

		System.out.print("Enter the amount of money given: ");
		double given = inputScanner.nextDouble();

		int[] change = getChange(cost, given);
	}

	public static int[] getChange(double cost, double amountGiven) {
		// TODO
		return null;
	}
}
