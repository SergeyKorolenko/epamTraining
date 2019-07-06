package epam.task2;

import java.util.Random;
import java.util.Scanner;

public class FriendlyNumbers {
	
	private static Random RANDOM = new Random();
	private static final int START = 200;
	private static final int END = 10000;
	
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
	
	public static int calculateSum(int number) {
		int sumDividers = 0;
		for(int i = 1; i <= number / 2; i++) {
			if(number % i == 0 ) {
				sumDividers += i;
			}
			
		}
		return sumDividers;
	}
	
	public static void findNumbers(int start, int end) {
		boolean is = false;
		for(int i = start; i <= end; i++) {
			for(int j = i + 1; j <= end && i != j; j++) {
				if(calculateSum(i) == j && calculateSum(j) == i ){
					printResult(i, j, is);
					is = true;
				}
			}
		}
	}
	
	public static void printResult(int first, int second, boolean is) {
		if(is) {
			System.out.println("The numbers " + first + " and " + second + " are friendly.");
		}
		System.out.println("There are not friendly numbers.");
	}
	
	public static boolean isNatural(int number) {
		return number >= 1 ? true : false;
	}
	
	public static void main(String[] args) {
		
		int start = enterNumber();
		int end = enterNumber();
		if(isNatural(start) && isNatural(end) && start < end) {
			findNumbers(start, end);
		} else {
			System.out.println("Incorrect data.");
		}
	}
}
