package epam.task1_1;

public class Launcher {
	
	private static final int N = 4; // константа для 4-ой задачи
	private static final int AMOUNT_OF_NUMBERS = 6; // константа для 5-ой задачи
	private static final int COUNT_OF_STEPS = 7; // константа для 6-ой задачи
	
	// 1-я задача
	public static void checkNumbers(double a, double b, double c) {
		if(a == b && a == c){
			System.out.println("Числа одинаковы");
		} else if(a == b || a == c || b == c) {
			System.out.println("Два числа из трех одинаковы");
		} else {
			System.out.println("Числа различны");
		}
	}
	
	// 2-я задача
	public static void transferWeight(double weightKilogram) {
		System.out.println("Вес динозавтра в миллиграммах : " + weightKilogram * 1000000 );
		System.out.println("Вес динозавтра в граммах : " + weightKilogram * 1000 );
		System.out.println("Вес динозавтра в тоннах : " + weightKilogram / 1000 );
	}
	
	// 3-я задача
	public static void findRingSquare(double r1, double r2) {
		
		double square = Math.PI * Math.abs((Math.pow(r1, 2) - Math.pow(r2, 2)));
		System.out.println("Площадь кольца равна : " + square + " квадратных единиц");
	}
	
	// 4-я задача
	public static void checkSequenceOfNumbers(int fourDigitNumber) {	
		int []array = new int[N];
		for(int i = array.length - 1; i >= 0; i--) {
			array[i] = fourDigitNumber % 10;
			fourDigitNumber /= 10;
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
			System.out.println("Цифры четырехзначного числа образуют возрастающую последовательность");
		} else if(Math.abs(temp) == array.length - 1) {
			System.out.println("Цифры четырехзначного числа образуют убывающую последовательность");
		} else {
			System.out.println("Цифры четырехзначного числа образуют не образуют никакой последовательности");
		}
		
	}
	
	// 5-я задача
	
	public static void calculateMeansOfNumbers(int number) {
		int []array = new int[AMOUNT_OF_NUMBERS];
		int step = 10;
		for(int i = 0; i < array.length; i++) {
			array[i] = number % step;
			number /= step;
		}
		double geometricMean = 1;
		double average = 0;
		for(int i = 0; i < array.length; i++) {
			geometricMean *= array[i];
			average += array[i];
		}
		geometricMean = Math.pow(geometricMean, 1.0/AMOUNT_OF_NUMBERS);
		average /= AMOUNT_OF_NUMBERS;
		System.out.println("Cреднее арифметическое равно : " + average);
		System.out.println("Cреднее геометрическое равно : " + geometricMean);
	}
	
	// 6-я задача
	
	public static void reversNumbers(int number){
		int reversNumber = 0;
		int step = 10;
		int i = 0;
		int factor = 1000000;
		while(i < COUNT_OF_STEPS){
			reversNumber += (number % step) * factor;
			number /= step;
			factor /= 10;
			i++;
		}
		 System.out.print("Перевернутое число : " + reversNumber);
	}
	
	// 7-я задача
	
	public static void swapTwoNumbers(int a, int b) {
		if(a > b) {
			a -= b;
			b += a;
			a = b - a;
		} else if(a < b) {
			b -= a;
			a += b;
			b = a - b;
		} else {
			System.out.println("Числа одинаковы");
		}		 
	}
	
	public static void main(String[] args){
		
		// 1-я задача
		double a = 2.01; // Первое число
		double b = 2.2; // Второе число
		double c = 2.0; //	Третье число
		
		checkNumbers(a, b, c);
		
		// 2-я задача
		double weightKilogram = 50.5; // Вес динозавра в килограммах
		
		transferWeight(weightKilogram);
		
		// 3-я задача
		double r1 = 4.5; // Больший радиус
		double r2 = 2.2; // Меньший радиус
		
		findRingSquare(r1, r2);
		
		// 4-я задача
		int forDigitNumber = 1234; // Четырехзначное число
		
		checkSequenceOfNumbers(forDigitNumber);
		
		// 5-я задача
		int sixDigitNumber = 123456;
		
		calculateMeansOfNumbers(123456);
		
		// 6-я задача
		
		int sevenDigitNumber = 1234567;
		
		reversNumbers(sevenDigitNumber);
		
		// 7-я задача
		int d = 5;
		int e = 6;
		
		swapTwoNumbers(d, e);
	}
	
	
}
