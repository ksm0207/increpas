package StringStudy;

import java.util.Scanner;

public class StringEmpty {
	
	public static void main(String[] args) {
		
		/* isEmpty */
		
		Scanner scan = new Scanner(System.in);
		
		
		String name = "";
		System.out.print("입력 : ");
		name = scan.nextLine();
		
		if (isCheck(name)) 
			System.out.println("Null 혹은 비어있는 공백입니다.");
		else
			System.out.println("문자열 확인 : " +  name);
	}
	
	public static boolean isCheck(String check) {
		
		return check == null || check.isEmpty();
	}

}
