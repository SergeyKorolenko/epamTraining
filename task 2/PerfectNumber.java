package epam.task2;

import java.util.Random;
import java.util.Scanner;

public class PerfectNumber {
	
	private static Random RANDOM = new Random(); 
	private static final int START = 1;
	private static final int END = Integer.MAX_VALUE;
	
	
	public static int enterNumber(){
		Scanner scanner = new Scanner(System.in);
		int number;
		System.out.println("Enter a natural number:");
		try {
			number  = scanner.nextInt();
		} catch(Exception e) {
			System.out.println("Generation of a random natural number...");
			number = RANDOM.nextInt(END) + START;
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return number;
	}
	
	public static boolean isNatural(int number) {
		return number >= 1 ? true : false;
	}

	public static boolean isFerfectNumber(int number) {
		int sumDividers = 0;
		for(int i = 1; i <= number / 2; i++) {
			if(number % i == 0 ) {
				sumDividers += i;
			}
			
		}
		if(number == sumDividers) {
			return true;
		}
		return false;
	}
	
	public static void printResult(int number, boolean result) {
		System.out.println("Is " + number + " ferfect number? - " + result + ".");
	}
	
	public static void main(String[] args) {
		
		int number = enterNumber();
		if(isNatural(number)) {
			boolean result = isFerfectNumber(number);
			printResult(number, result);
		} else {
			System.out.println("Incorrect data.");
		}

	}

}
