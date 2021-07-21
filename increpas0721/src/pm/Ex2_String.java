package pm;

import java.util.Scanner;

public class Ex2_String {
	public static void main(String[] args) {
		
		// 1. 키보드로 부터 한줄의 문자열을 입력받는다
		// 2. 문자열 안에 숫자 이외의 값이 입력될 때는
		// 3. "숫자외 다른 값을 입력하시면 안됩니다."
		// 4. 숫자들로만 이루어졌다면 "정확한 입력값이 맞습니다 출력"
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		int len = str.length();
		boolean chk = false;
		
		for (int i = 0 ; i < len ; i ++) {
			
			char ch = str.charAt(i);
			
			// 숫자가 아닌 것을 가려낸다.
			if (ch < '0' || ch > '9') {
				// 숫자가 아닌 경우를 만났으니
				// 더이상 반복문을 수행할 필요가 없다
				chk = true;
				break;
				// 반복문을 최소화 시킨 방법
			}
		}
		if (chk) {
			System.out.println("잘못된 값 입니다");
		}else {
			System.out.println("정확한 입력입니다");
		}
	}
		
}
	
	

