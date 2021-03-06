package epam.task1_2;

public class Main {
	
	private static final int FIRST_AMOUNT_OF_HEADS = 3;
	private static final int AMOUNT_OF_EYES_ON_ONE_HEAD = 2;
	private static final int AMOUNT_OF_HEADS_BEFORE_200 = 3;
	private static final int AMOUNT_OF_HEADS_FROM_201_TO_300 = 2;
	private static final int AMOUNT_OF_HEADS_ATER_301 = 1;
	private static final double ACCURACY = 0.00001;
	
	// The first task
	public static boolean isTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		if(x1 == x2 && x1 == x3){
			return false;
		}
		if(y1 == y2 && y1 == y2){
			return false;
		}
		return true;
	}
	
	public static boolean isRightTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
		double side1 = calculateSide(x1, y1, x2, y2);
		double side2 = calculateSide(x1, y1, x3, y3);
		double side3 = calculateSide(x2, y2, x3, y3);
		
		if(side1 > side2 + side3 ) {
			if(Math.pow(side1, 2) - (Math.pow(side2, 2) + Math.pow(side3, 2)) < ACCURACY) {
				return true;
			}
		} else if(side2 > side1 + side3){
			if(Math.pow(side2, 2) - (Math.pow(side1, 2) + Math.pow(side3, 2)) < ACCURACY) {
				return true;
			}
		} else {
			if(Math.pow(side3, 2) - (Math.pow(side1, 2) + Math.pow(side2, 2)) < ACCURACY) {
				return true;
			}
		}
		return false;
	}
	
	public static double calculateSide(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	// The second task
	private static int amountOfHeads(int age) {
		int amountOfHeads = FIRST_AMOUNT_OF_HEADS;
		for(int i = 1; i <= age; i++){
			if(i < 200){
				amountOfHeads += AMOUNT_OF_HEADS_BEFORE_200;
			} else if(i >= 200 && i < 300) {
				amountOfHeads += AMOUNT_OF_HEADS_FROM_201_TO_300;
			}	else {
				amountOfHeads += AMOUNT_OF_HEADS_ATER_301;
			}
		}
		return amountOfHeads;
		
	}
	
	private static int amountOfEyes(int amountOfHeads) {
		return amountOfHeads * AMOUNT_OF_EYES_ON_ONE_HEAD;
	}
	
	//The third task 
	public static boolean isVowelOptionOne(char letter) {
		letter = Character.toLowerCase(letter);
		char []arrayVowelLetter = {'a', 'e', 'i', 'o', 'u'};
		for(int i = 0; i < arrayVowelLetter.length; i++) {
			if(letter == arrayVowelLetter[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isVowelOptionTwo(char letter){
		letter = Character.toLowerCase(letter);
		switch(letter){
			case 'a':
				return true;
			case 'e':
				return true;
			case 'i':
				return true;
			case 'o':
				return true;
			case 'u':
				return true;
		}
		return false;
	}
	
	public static boolean isVowelOptionThree(char letter){
		letter = Character.toLowerCase(letter);
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
			return true;
		}
		return false;
	}
	
	public static boolean isVowelOptionFour(char letter){
		String checkString = "aeiouAEIOU";
		if(checkString.contains(Character.toString(letter))) {
			return true;
		}
		return false;
	}
	
	// The fourth task
	public static boolean isRightNumbersOfDate(int day, int month, int year) {
		return (day > 0 && day <= 31 && month > 0 && month <=12  && year >= 0) ? true : false;
	}
	
	public static boolean isLeapYear(int year) {
		if(year % 4 == 0 && year % 100 != 0) {
			return true;
		} else if(year % 4 == 0 && year % 100 == 0) {
			return false;
		} else if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int[] findNextDate(int day, int month, int year){
		int []newDate = new int[3];
		int countOfDays = 0;
		countOfDays = checkMonth(month, isLeapYear(year));
		if(isRightDayOfMonth(day, countOfDays)) {
			newDate = calculateNewDate(day, month, countOfDays, year);
		} else {
			System.out.println("Incorrect date : date will be reset.");
		}
		return newDate;
	}
	
	public static boolean isRightDayOfMonth(int day, int countOfDays) {
		return day <= countOfDays ? true: false;
	}
	
	private static int checkMonth(int month, boolean year) {
		int amountOfDays = 1;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 
				amountOfDays = 31;
				break;
			case 2:
				if(year) {
					amountOfDays = 29;
				} else {
					amountOfDays = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				amountOfDays = 30;
				break;
		}
		return amountOfDays;
	}
	
	private static int[] calculateNewDate(int day, int month, int amountOfDays, int year) {
		int []finalDate = new int[3];
		if(day == amountOfDays) {
			if(month == 12){
				finalDate[0] = 1;
				finalDate[1] = 1;
				finalDate[2] = ++year;
			} else {
				finalDate[0] = 1;
				finalDate[1] = ++month;
				finalDate[2] = ++year;
			}
		} else {
			finalDate[0] = ++day;
			finalDate[1] = month;
			finalDate[2] = year;
		}
		return finalDate;
	}
	
	public static void main(String[] args) {
		
		// The first task
		double x1 = 1;
		double y1 = 1;
		double x2 = 1;
		double y2 = 3;
		double x3 = 5;
		double y3 = 3;
		boolean isTriangle = isTriangle(x1, y1, x2, y2, x3, y3);
		System.out.println("Is triangle : " + isTriangle);
		if(isTriangle) {
			System.out.println("Is right triangle : " + isRightTriangle(x1, y1, x2, y2, x3, y3));
		}
		
		// The second task
		int age = 200;
		int amountOfHeads = amountOfHeads(age);
		System.out.println("Amount of heads are : " + amountOfHeads + " heads.");
		System.out.println("Amount of eyes are : " + amountOfEyes(amountOfHeads) + " eyes.");
		
		// The third task
		char letter = 'a';
		
		System.out.println("Is the letter vowel (option one)? - " + isVowelOptionOne(letter));
		System.out.println("Is the letter vowel (option two)? - " + isVowelOptionTwo(letter));
		System.out.println("Is the letter vowel (option three)? - " + isVowelOptionThree(letter));
		System.out.println("Is the letter vowel (option four)? - " + isVowelOptionFour(letter));
		
		// The fourth task
		int day = 31;
		int month = 12;
		int year = 2017;
		
		if(isRightNumbersOfDate( day, month, year)) {
			int []nextDate = findNextDate(day, month, year);
			System.out.println("Old date : " + day + "." + month + "." + year);
			System.out.println("New date : " + nextDate[0] + "." + nextDate[1] + "." + nextDate[2]);
		}		
	}
}
