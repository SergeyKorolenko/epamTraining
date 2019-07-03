package epam.task1_2;

public class Main {
	
	private static final int FIRST_AMOUNT_OF_HEADS = 3;
	private static final int AMOUNT_OF_EYES_ON_ONE_HEAD = 2;
	private static final int AMOUNT_OF_HEADS_BEFORE_200 = 3;
	private static final int AMOUNT_OF_HEADS_FROM_201_TO_300 = 2;
	private static final int AMOUNT_OF_HEADS_ATER_301 = 1;
	private static final double ACCURACY = 0.00001;
	
	// The first task
	
	public static boolean[] isTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		boolean []is = new boolean[2];
		if(x1 == x2 && x1 == x3){
			return is;
		}
		if(y1 == y2 && y1 == y2){
			return is;
		}
		is[0] = true;
		is[1] = isRightTriangle(x1, y1, x2, y2, x3, y3);
		return is;
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
		for(int i = 0; i < age; i++){
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
		char []arrayVowelLetter = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		for(int i = 0; i < arrayVowelLetter.length; i++) {
			if(letter == arrayVowelLetter[i]) {
				return true;
			}
		}
		return false;
	}
	
	// The fourth task
	public static int[] findNextDate(int day, int month, int year){
		int []newDate = new int[3];
		int tempCountOfDays = 0;
		if(day > 0 && day <= 31 && month > 0 && month <=12) {
			if(year % 4 == 0 && year % 100 != 0){
				tempCountOfDays = checkMonth(month, true);
				newDate = calculateNewDate(day, month, tempCountOfDays, year);
			}else if(year % 4 == 0 && year % 100 == 0){
				tempCountOfDays = checkMonth(month, false);
				newDate = calculateNewDate(day, month, tempCountOfDays, year);
			}else if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0){
				tempCountOfDays = checkMonth(month, true);
				newDate = calculateNewDate(day, month, tempCountOfDays, year);
			} else {
				tempCountOfDays = checkMonth(month, false);
				newDate = calculateNewDate(day, month, tempCountOfDays, year);
			}
		}
		return newDate;
	}
	
	private static int checkMonth(int month, boolean year) {
		int amountOfDays = 1;
		switch(month){
			case 1:
				amountOfDays = 31;
				break;
			case 2:
				if(year) {
					amountOfDays = 29;
				} else {
					amountOfDays = 28;
				}
				break;
			case 3:
				amountOfDays = 31;
				break;
			case 4:
				amountOfDays = 30;
				break;
			case 5:
				amountOfDays = 31;
				break;
			case 6:
				amountOfDays = 30;
				break;
			case 7:
				amountOfDays = 31;
				break;
			case 8:
				amountOfDays = 31;
				break;
			case 9:
				amountOfDays = 30;
				break;
			case 10:
				amountOfDays = 31;
				break;
			case 11:
				amountOfDays = 30;
				break;
			case 12:
				amountOfDays = 31;
				break;
		}
		return amountOfDays;
	}
	
	private static int[] calculateNewDate(int day, int month, int amountOfDays, int year) {
		int []finalDate = new int[3];
		if(day > amountOfDays){
			return finalDate;
		}
		if(day == amountOfDays) {
			if(month == 12){
				finalDate[0] = 1;
				finalDate[1] = 1;
				finalDate[2] = year + 1;
			} else {
				finalDate[0] = 1;
				finalDate[1] = month + 1;
				finalDate[2] = year + 1;
			}
		} else {
			finalDate[0] = day + 1;
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
		boolean []is = isTriangle(x1, y1, x2, y2, x3, y3);
		for(boolean isBool: is){
			System.out.println(isBool);
		}
		
		// The second task
		int age = 500;
		int amountOfHeads = amountOfHeads(age);
		System.out.println("Amount of heads are : " + amountOfHeads + "heads.");
		System.out.println("Amount of eyes are : " + amountOfEyes(amountOfHeads) + "eyes.");
		
		// The third task
		
		char letter = 'a';
		System.out.println("Is the letter vowel? - " + isVowelOptionOne(letter));
		
		// The fourth task
		
		int day = 31;
		int month = 12;
		int year = 2017;
		int []nextDate = findNextDate(day, month, year);
		System.out.println(nextDate[0] + "." + nextDate[1] + "." + nextDate[2]);
		
	}
}
