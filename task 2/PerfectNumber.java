package epam.task2;

public class PerfectNumber {
	
	private static final int DIVIDER = 2;
	private static int NUMBER = 496;
	
	public static boolean isNatural(int number) {
		return number >= 1;
	}

	public static boolean isFerfectNumber(int number) {
		int sumDividers = 0;
		for(int i = 1; i <= number / DIVIDER; i++) {
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
		
		int number = NUMBER;
		if(isNatural(number)) {
			boolean result = isFerfectNumber(number);
			printResult(number, result);
		} else {
			System.out.println("Incorrect data.");
		}

	}

}
