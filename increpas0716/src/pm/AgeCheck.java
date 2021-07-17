package pm;

import java.util.Scanner;

public class AgeCheck {
	
	public String check(int age) {
		String res = "";
		
		if (age >= 10 && age <= 19) {
			res = "10";			
		}else if (age >= 20 && age <= 29) {
			res = "20";
		}else if (age >= 30 && age <= 39) {
			res = "30";
		}else if(age >= 40 && age <= 49) {
			res = "40";
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		// 1.키보드로 부터 나이를 입력 받는다.
		// 조건 : 10대 20대 30대 구별하는 프로그램을 만드세요
		Scanner scan = new Scanner(System.in);
		AgeCheck ac = new AgeCheck();
		
		int value = scan.nextInt();
		String res = ac.check(value);
		
		if(res == "") { 
			System.out.println("Exit...");
		}else{
			System.out.println(res + "대");
		}
		
	}
}
