package epam.task1_1;

public class Launcher {
	
	private static final int N = 4; // constant for the fourth task
	private static final int AMOUNT_OF_NUMERALS = 6; // constant for the fifth task
	private static final int COUNT_OF_STEPS = 7; // constant for the sixth task
	private static final int MIN_FOUR_DIGIT_NUMBER = 1000;
	private static final int MAX_FOUR_DIGIT_NUMBER = 9999;
	private static final int MIN_SIX_DIGIT_NUMBER = 100000;
	private static final int MAX_SIX_DIGIT_NUMBER = 999999;
	private static final int MIN_SEVEN_DIGIT_NUMBER = 1000000;
	private static final int MAX_SEVEN_DIGIT_NUMBER = 9999999;
	private static final int DIVIDER = 10;
	private static final int FACTOR = 1000000;
	
	// The first task
	public static int checkNumbers(double a, double b, double c) {
		if(a == b && a == c){
			return 0;
		} else if(a == b || a == c || b == c) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static void printResult(int result){
		if(result == 0){
			System.out.println("The numbers are te same.");
		} else if(result == 1) {
			System.out.println("Two numbers are the same.");
		} else {
			System.out.println("The numbers are different.");
		}
	}
	
	// The second task
	public static boolean isPositive(double weightKilogram) {
		return weightKilogram > 0 ? true : false;
	}
	
	public static void transferWeight(double weightKilogram) {
		System.out.println("Dinosaur weight in milligrams is : " + weightKilogram * 1000000 + " milligrams.");
		System.out.println("Dinosaur weight in grams is : " + weightKilogram * 1000 + " grams.");
		System.out.println("Dinosaur weight in tons is : " + weightKilogram / 1000 + " tones.");
	}
	
	// The third task
	public static void findRingSquare(double r1, double r2) {
		double square = Math.PI * Math.abs((Math.pow(r1, 2) - Math.pow(r2, 2)));
		System.out.println("The square of the ring is : " + square + " square units.");
	}
	
	// The fourth task
	private static boolean isFourDigitNumber(int fourDigitNumber){
		return fourDigitNumber >= MIN_FOUR_DIGIT_NUMBER && fourDigitNumber <= MAX_FOUR_DIGIT_NUMBER ? true : false;
	}
	
	public static void checkSequenceOfNumbers(int fourDigitNumber) {	
		int []array = new int[N];
		for(int i = array.length - 1; i >= 0; i--) {
			array[i] = fourDigitNumber % DIVIDER;
			fourDigitNumber /= DIVIDER;
		}
		int temp = 0;
		for(int i = 0; i < array.length - 1 ; i++) {
			if(array[i] < array[i + 1]){
				temp++;
			}
			if(array[i] > array[i + 1]){
				temp--;
			} 
		}
		if(temp == array.length - 1) {
			System.out.println("Numerals of four digit number form an increasing sequence.");
		} else if(Math.abs(temp) == array.length - 1) {
			System.out.println("Numerals of four digit number form a descending sequence.");
		} else {
			System.out.println("Numerals of four digit number do not form a sequence.");
		}
		
	}
	
	// The fifth task
	
	private static boolean isSixDigitNumber(int sixDigitNumber){
		return sixDigitNumber >= MIN_SIX_DIGIT_NUMBER && sixDigitNumber <= MAX_SIX_DIGIT_NUMBER ? true : false;
	}
	
	public static void calculateMeansOfNumbers(int number) {
		int tempNumber = 0;
		double arithmeticMean = 0;
		double geometricMean = 1;
		for(int i = 0; i < AMOUNT_OF_NUMERALS; i++) {
			tempNumber = number % DIVIDER;
			number /= DIVIDER;
			arithmeticMean += tempNumber;
			geometricMean *= tempNumber;
		}
		arithmeticMean /= AMOUNT_OF_NUMERALS;
		geometricMean = Math.pow(geometricMean, 1.0/AMOUNT_OF_NUMERALS);
		System.out.println("Àrithmetic mean is : " + arithmeticMean);
		System.out.println("Geometric mean is : " + geometricMean);
	}
	
	// The sixth task
	
	private static boolean isSevenDigitNumber(int sevenDigitNumber){
		return sevenDigitNumber >= MIN_SEVEN_DIGIT_NUMBER && sevenDigitNumber <= MAX_SEVEN_DIGIT_NUMBER ? true : false;
	}
	
	public static void reversNumbers(int number){
		int reversNumber = 0;
		int i = 0;
		int factor = FACTOR;
		while(i < COUNT_OF_STEPS){
			reversNumber += (number % DIVIDER) * factor;
			number /= DIVIDER;
			factor /= DIVIDER;
			i++;
		}
		 System.out.print("Revers number is : " + reversNumber + ".");
	}
	
	// The seventh task
	
	public static void swapTwoNumbers(int a, int b) {
		a += b;
		b = a - b;
		a -= b;	
	}
	
	public static void main(String[] args){
		
		// The first task
		double a = 2.01; 
		double b = 2.2; 
		double c = 2.0; 
		
		printResult(checkNumbers(a, b, c));
		
		// The second task
		double weightKilogram = 50.5; 
		
		if(isPositive(weightKilogram)) {
			transferWeight(weightKilogram);
		}
		
		// The third task
		double r1 = 4.5;
		double r2 = 2.2; 
		if(isPositive(r1) && isPositive(r2)) {
			findRingSquare(r1, r2);
		}
		
		// The fourth task
		int forDigitNumber = 1234; 
		
		if(isFourDigitNumber(forDigitNumber)) {
			checkSequenceOfNumbers(forDigitNumber);
		}
		
		// The fifth task
		int sixDigitNumber = 123456;
		
		if(isSixDigitNumber(sixDigitNumber)) {
			calculateMeansOfNumbers(sixDigitNumber);
		}
		
		// The sixth task
		int sevenDigitNumber = 1234567;
		
		if(isSevenDigitNumber(sevenDigitNumber)) {
			reversNumbers(sevenDigitNumber);
		}
		
		// The seventh task
		int d = 5;
		int e = 6;
		
		swapTwoNumbers(d, e);
	}
	
	
}
