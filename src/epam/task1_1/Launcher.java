package epam.task1_1;

public class Launcher {
	
	private static final int N = 4; // ��������� ��� 4-�� ������
	private static final int AMOUNT_OF_NUMBERS = 6; // ��������� ��� 5-�� ������
	private static final int COUNT_OF_STEPS = 7; // ��������� ��� 6-�� ������
	
	// 1-� ������
	public static void checkNumbers(double a, double b, double c) {
		if(a == b && a == c){
			System.out.println("����� ���������");
		} else if(a == b || a == c || b == c) {
			System.out.println("��� ����� �� ���� ���������");
		} else {
			System.out.println("����� ��������");
		}
	}
	
	// 2-� ������
	public static void transferWeight(double weightKilogram) {
		System.out.println("��� ���������� � ������������ : " + weightKilogram * 1000000 );
		System.out.println("��� ���������� � ������� : " + weightKilogram * 1000 );
		System.out.println("��� ���������� � ������ : " + weightKilogram / 1000 );
	}
	
	// 3-� ������
	public static void findRingSquare(double r1, double r2) {
		
		double square = Math.PI * Math.abs((Math.pow(r1, 2) - Math.pow(r2, 2)));
		System.out.println("������� ������ ����� : " + square + " ���������� ������");
	}
	
	// 4-� ������
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
			System.out.println("����� ��������������� ����� �������� ������������ ������������������");
		} else if(Math.abs(temp) == array.length - 1) {
			System.out.println("����� ��������������� ����� �������� ��������� ������������������");
		} else {
			System.out.println("����� ��������������� ����� �������� �� �������� ������� ������������������");
		}
		
	}
	
	// 5-� ������
	
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
		System.out.println("C������ �������������� ����� : " + average);
		System.out.println("C������ �������������� ����� : " + geometricMean);
	}
	
	// 6-� ������
	
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
		 System.out.print("������������ ����� : " + reversNumber);
	}
	
	// 7-� ������
	
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
			System.out.println("����� ���������");
		}		 
	}
	
	public static void main(String[] args){
		
		// 1-� ������
		double a = 2.01; // ������ �����
		double b = 2.2; // ������ �����
		double c = 2.0; //	������ �����
		
		checkNumbers(a, b, c);
		
		// 2-� ������
		double weightKilogram = 50.5; // ��� ��������� � �����������
		
		transferWeight(weightKilogram);
		
		// 3-� ������
		double r1 = 4.5; // ������� ������
		double r2 = 2.2; // ������� ������
		
		findRingSquare(r1, r2);
		
		// 4-� ������
		int forDigitNumber = 1234; // �������������� �����
		
		checkSequenceOfNumbers(forDigitNumber);
		
		// 5-� ������
		int sixDigitNumber = 123456;
		
		calculateMeansOfNumbers(123456);
		
		// 6-� ������
		
		int sevenDigitNumber = 1234567;
		
		reversNumbers(sevenDigitNumber);
		
		// 7-� ������
		int d = 5;
		int e = 6;
		
		swapTwoNumbers(d, e);
	}
	
	
}
