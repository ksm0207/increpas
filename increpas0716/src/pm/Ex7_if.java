package pm;

import java.util.Scanner;

public class Ex7_if {
	public static void main(String[] args) {
		
		// 1.키보드로 부터 나이를 입력 받는다.
		// 조건 : 10대 20대 30대 구별하는 프로그램을 만드세요
		
		Scanner scan = new Scanner(System.in);
		
		String res = "";
		
		int value = scan.nextInt();
		
		if (value >= 10 && value <= 19) {
			res = "10";			
		}else if (value >= 20 && value <= 29) {
			res = "20";
		}else if (value >= 30 && value <= 39) {
			res = "30";
		}else if(value >= 40 && value <= 49) {
			res = "40";
		}
		// "" != "" => false
		if(res == "") { 
			System.out.println("Exit...");
		}else{
			System.out.println(res + " 대 입니다");
		}
	}
}
