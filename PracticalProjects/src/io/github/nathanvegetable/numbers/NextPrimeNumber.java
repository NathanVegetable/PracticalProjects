package io.github.nathanvegetable.numbers;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Project: Have the program find prime numbers until the user chooses to stop
 * asking for the next one.
 * 
 * @author NathanVegetable
 *
 */
public class NextPrimeNumber {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter a starting integer: ");
		int number = inputScanner.nextInt();
		while (true) {
			number = findNextPrimeNumber(number);
			System.out.println(number);
			System.out.println("Continue? (y)/n ");
			String input = inputScanner.next();
			if (input != null && input.equals("n"))
				break;
		}
		inputScanner.close();
	}

	/**
	 * @param input
	 *            The starting number to start searching after
	 * @return The next valid prime number after <b>input</b>
	 */
	public static int findNextPrimeNumber(int input) {
		int nextNum = ++input;
		while (!isPrimeNumber(nextNum))
			nextNum++;
		return nextNum;
	}

	/**
	 * Uses {@link BigInteger#nextProbablePrime()} to quickly find the next
	 * 'probable' Prime
	 * 
	 * @param input
	 *            The starting number to start searching after
	 * @return The next valid prime number after <b>input</b>
	 */
	public static int findNextPrimeNumberWithBigInteger(int input) {
		BigInteger bigInt = new BigInteger(String.valueOf(input));
		return Integer.parseInt(bigInt.nextProbablePrime().toString());
	}

	/**
	 * @param input
	 * @return Whether or not <b>input</b> is Prime
	 */
	public static boolean isPrimeNumber(int input) {
		if (input < 2)
			return false;
		for (int i = 2; i < input; i++)
			if (input % i == 0)
				return false;
		return true;
	}
}
