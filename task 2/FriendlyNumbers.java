package epam.task2;

public class FriendlyNumbers {
	
	private static final int DIVIDER = 2;
	
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
		return number >= 1;
	}
	
	public static void main(String[] args) {
		
		int start = 100;
		int end = 1000;
		if(isNatural(start) && isNatural(end) && start < end) {
			findNumbers(start, end);
		} else {
			System.out.println("Incorrect data.");
		}
	}
}
