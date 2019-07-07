package epam.task2;

import java.util.Random;

public class Game {
	
	private static Random RANDOM = new Random();
	private static int START = 100;
	private static int END = 1000;
	
	public static void countHeadsTails() {
		int headsAmount = 0;
		int tailsAmount = 0;
		int shotsAmount = RANDOM.nextInt(END) + START;
		for(int i = 0; i < shotsAmount; i++) {
			if(RANDOM.nextBoolean()) {
				headsAmount++;
			} else {
				tailsAmount++;
			}
		}
		printResult(shotsAmount, headsAmount, tailsAmount);
	}
	
	public static void printResult(int shotsAmount, int headsAmount, int tailsAmount) {
		System.out.println("Amount of shots are " + shotsAmount);
		System.out.println("Amount of heads are " + headsAmount);
		System.out.println("Amount of tails are " + tailsAmount);
	}
	
	public static void main(String[] args) {
		
		countHeadsTails();
		
	}

}
