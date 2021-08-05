package pm.Ex1;

import java.util.Scanner;

public class Ex1_Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Ex1_Final ex1 = new Ex1_Final();
		System.out.println("1 ~ 4 입력");
		int cmd = scan.nextInt();
		
		
		// 입력된 값이 1 ~ 4인지 ?
		if(cmd >= 1 && cmd <= 4) {
			ex1.setValue(cmd);
			ex1.exe();
		}else {
			System.out.println("1 ~ 4 수들 중 하나만 입력해야 합니다.");
		}// end of if-else
	}
}
