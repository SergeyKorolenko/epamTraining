package epam.task2;

public class FriendlyNumbers {
	
	private static final int DIVIDER = 2;
	private static int START = 200;
	private static int END = 3000;
	
	public static int calculateSum(int number) {
		int sumDividers = 0;
		for(int i = 1; i <= number / DIVIDER; i++) {
			if(number % i == 0 ) {
				sumDividers += i;
			}	
		}
		return sumDividers;
	}
	
	public static void findNumbers(int start, int end) {
		boolean is;
		for(int i = start; i <= end; i++) {
			is = false;
			for(int j = i + 1; j <= end && i != j; j++) {
				if(calculateSum(i) == j && calculateSum(j) == i ){
					is = true;
					printResult(i, j, is);
				}
			}
		}
	}
	
	public static void printResult(int first, int second, boolean is) {
		if(is) {
			System.out.println("The numbers " + first + " and " + second + " are friendly.");
		} else {
			System.out.println("There are not friendly numbers.");
		}
	}
	
	public static boolean isNatural(int number) {
		return number >= 1;
	}
	
	public static void main(String[] args) {
		
		int start = START;
		int end = END;
		if(isNatural(start) && isNatural(end) && start < end) {
			findNumbers(start, end);
		} else {
			System.out.println("Incorrect data.");
		}
	}
}
