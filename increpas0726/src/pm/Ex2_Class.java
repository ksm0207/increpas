package pm;

import java.util.Scanner;

public class Ex2_Class {
	// 하나의 문자열을 입력받아서 모두 숫자이면 true
	// 1 자 라도 문자열이 있으면 false
	public boolean checkNum(String res) {
		
		boolean flag = true;

		for (int i = 0 ; i < res.length() ; i ++) {
			
			char ch = res.charAt(i);
			
			if (ch < '0' || ch > '9') {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println("문자열에 모든 숫자가 포함 되었습니다");
		}else {
			System.out.println("문자열에 다른 문자가 포함 되었습니다");
		}
		
		return flag;
	}
	
	
	public static void main(String[] args) {
		Ex2_Class ex2 = new Ex2_Class();
		Scanner scan = new Scanner(System.in);
		
		String value = scan.next();
		
		boolean a = ex2.checkNum(value);
		
		System.out.println(a);
		
	}
	
}
