package StringStudy;

import java.util.Scanner;

public class UserIDCheck {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		System.out.print("아이디 입력 :");
		String user_id = scan.nextLine();
		
		if (user_id.trim().isEmpty() || user_id.contains(" ")) {
			System.out.println("공백 확인2 ");
		}else{
			System.out.println("아이디 : " + user_id);
		}
	}
	public static boolean isCheck(String user_id) {
		
		return user_id == null || user_id.trim().isEmpty();
	}
}
