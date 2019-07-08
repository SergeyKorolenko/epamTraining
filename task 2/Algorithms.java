package epam.task2;

public class Algorithms {
	
	private static final int DIVIDER = 10;
	private static final int FIRST_NATURAL_NUMBER = 1;
	private static final int AMOUNT_DIVIDERS_FOR_SIMPLE_NUMBER = 2;
	private static final int MULTY = 2;
	private static final int MAX_NUMERAL = 9;
	private static int FIRST_NUMBER = 121;
	private static int SECOND_NUMBER = 55;
	
	public static boolean isNatural(int number) {
		return number >= 1;
	}
	
	public static int numberSize(int number) {
		int size = 0;
		while(number > 0) {
			size++;
			number /= DIVIDER;
		}
		return size;
	}
	
	// task 2.1
	public static int findBigNumeral(int number) {
		int temp = 0;
		while(number > 0) {
			int numeral = number % DIVIDER;
			if(temp < numeral) {
				temp = numeral;
			}
			number /= DIVIDER;
		}
		return temp;
	}
	
	// task 2.2
	public static int reversNumber(int number) {
		int size = numberSize(number);
		int factor = 1;
		for(int i = 1; i < size; i++) {
			factor *= DIVIDER;
		}
		int result = 0;
		int i = 0;
		while(i < size){
			result += (number % DIVIDER) * factor;
			number /= DIVIDER;
			factor /= DIVIDER;
			i++;
		}
		return result;
	}
	
	public static boolean isPalindrome(int number) {
		return number == reversNumber(number);
	}
	
	// task 2.3
	public static boolean isSimple(int number) {
		if(number == FIRST_NATURAL_NUMBER) {
			return false;
		}
		int temp = AMOUNT_DIVIDERS_FOR_SIMPLE_NUMBER;
		for(int i = temp; i <= number / MULTY; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// task 2.4
	public static void findSimpleDividers(int number){
		for(int i = 1; i <= number / MULTY; i++) {
			if(isSimple(i)) {
				if(number % i == 0) {
					System.out.println("Simple divider is " + i);
				}
			}
		}
	}

	// task 2.5
	public static int findHOK(int first, int second){
		final int HOD = findHOD(first, second);
		return first * second / HOD;
	}
	
	public static int findHOD(int first, int second) {
		while(first != second) {
			if(first > second) {
				first -= second;
			} else {
				second -= first;
			}
		}
		return first;
	}
	
	// task 2.6
	public static int findAmountNumerals(int number) {
		int amount = 0;
		for(int i = 0; i <= MAX_NUMERAL; i++) {
			if(isNumeral(number, i)) {
				amount++;
			}
		}
		return amount;
	}
	
	public static boolean isNumeral(int number, int numeral) {
		int size = numberSize(number);
		for(int i = 0; i < size; i++) {
			int tempNumeral = number % DIVIDER;
			if(tempNumeral == numeral) {
				return true;
			}
			number /= DIVIDER;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int numberOne = FIRST_NUMBER;
		int numberTwo = SECOND_NUMBER;
		if(isNatural(numberOne) && isNatural(numberTwo)) {
			System.out.println("The biggest numeral of " + numberOne + " is " + findBigNumeral(numberOne));
			System.out.println("Is " + numberOne + " simple? - " + isSimple(numberOne));	
			System.out.println("Is " + numberOne + " palindrome? - " + isPalindrome(numberOne));
			findSimpleDividers(numberOne);
			System.out.println("HOK " + numberOne + " and " + numberTwo + " is - " + findHOK(numberOne, numberTwo));
			System.out.println("HOD " + numberOne + " and " + numberTwo + " is - " + findHOD(numberOne, numberTwo));
			System.out.println("Amount of different numerals of " + numberOne + " is - " + findAmountNumerals(numberOne));
		} else {
			System.out.println("Incorrect data.");
		}
		
	}

}
