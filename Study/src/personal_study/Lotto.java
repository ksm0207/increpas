package personal_study;

import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("로또 번호 개수 입력 : ");
		int value = scan.nextInt();
		int [] array = new int [value];
		System.out.println("로또 번호 결과 ");
		for (int i = 0 ; i < array.length ; i ++) {
			array[i] = (int)(Math.random()*45)+1;
	
			for (int j = 0 ; j < i ; j ++) {
				
				if (array[i] == array[j]) {
					i --;
					break;
				}
			}
		}
		for (int i = 0 ; i < array.length; i ++) {
			System.out.println(array[i] + "  ");
		}
		
	}
}
