package epam.task2;

public class Algorithms {
	
	private static final int DIVIDER = 10;
	private static final int FIRST_NATURAL_NUMBER = 1;
	private static final int AMOUNT_DIVIDERS_FOR_SIMPLE_NUMBER = 2;
	private static final int MULTY = 2;
	
	public static boolean isNatural(int number) {
		return number >= 1;
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
	public static int numberSize(int number) {
		int size = 0;
		while(number > 0) {
			size++;
			number /= DIVIDER;
		}
		return size;
	}
	
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
		int reversNumber = reversNumber(number);
		if(number == reversNumber) {
			return true;
		}
		return false;
	}
	
	// task 2.3
	public static boolean isSimple(int number) {
		if(number == FIRST_NATURAL_NUMBER) {
			return false;
		}
		int temp = AMOUNT_DIVIDERS_FOR_SIMPLE_NUMBER;
		for(int i = temp; i < number / MULTY; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void findSimpleDividers(int number){
		for(int i = 1; i < number / MULTY; i++) {
			if(isSimple(i)) {
				if(number % i == 0) {
					System.out.println("Simple divider is " + i);
				}
			}
		}
	}

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
	
	public static int findNumerals(int number) {
		int count = 0;
		boolean zero = true;
		boolean one = true;
		boolean two = true;
		boolean three = true;
		boolean four = true;
		boolean fife = true;
		boolean six = true;
		boolean seven = true;
		boolean eight = true;
		boolean nine = true;
		while(number > 0) {
			int last = number % DIVIDER;
			switch(last) {
				case 0:
					if(zero) {
						zero = false;
						count++;
					}
					break;
				case 1:
					if(one) {
						one = false;
						count++;
					}
					break;
				case 2:
					if(two) {
						two = false;
						count++;
					}
					break;
				case 3:
					if(three) {
						three = false;
						count++;
					}
					break;
				case 4:
					if(four) {
						four = false;
						count++;
					}
					break;
				case 5:
					if(fife) {
						fife = false;
						count++;
					}
					break;
				case 6:
					if(six) {
						six = false;
						count++;
					}
					break;
				case 7:
					if(seven) {
						seven = false;
						count++;
					}
					break;
				case 8:
					if(eight) {
						eight = false;
						count++;
					}
					break;
				case 9:
					if(nine) {
						nine = false;
						count++;
					}
					break;
			}
			number /= DIVIDER;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int numberOne = 1234;
		int numberTwo = 55;
		if(isNatural(numberOne) && isNatural(numberTwo)) {
			System.out.println("The biggest numeral of " + numberOne + " is " + findBigNumeral(numberOne));
			System.out.println("Is " + numberOne + " simple? - " + isSimple(numberOne));	
			System.out.println("Is " + numberOne + " palindrome? - " + isPalindrome(numberOne));
			findSimpleDividers(numberOne);
			System.out.println("HOK " + numberOne + " and " + numberTwo + " is - " + findHOK(numberOne, numberTwo));
			System.out.println("HOK " + numberOne + " and " + numberTwo + " is - " + findHOD(numberOne, numberTwo));
			System.out.println("Amount of different numerals of" + numberOne + " is - " + findNumerals(numberOne));
		} else {
			System.out.println("Incorrect data.");
		}
		
	}

}
