package Thread.example1;

import java.util.Scanner;

public class Multiplication {
	
	Thread thread;
	
	public Multiplication() {
		
		Scanner scan =new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = scan.nextInt();
		
		thread = new Thread() {
			@Override
			public void run() {
				try {
					for (int i=1; i<=9; i++) {
						System.out.println(dan + " * " + i + " = " + dan * i);
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		};
		getResult();
	}
	
	public void getResult() {
		thread.start();
	}
	
	public static void main(String[] args) {
		 new Multiplication();
	}
}
