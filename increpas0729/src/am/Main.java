package am;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 자판기 객체
		VendingMachine vend = new VendingMachine();
		// 객체 호출
		vend.initItems();

		int userChoise;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력해주세요 :");
		int u_money = scan.nextInt();
		
		boolean check = vend.getPrint(u_money);
		
		if (check) {
			System.out.print("구매 번호 : ");
			userChoise = scan.nextInt() -1;
			u_money = vend.getItems(u_money, userChoise);
		}
		
		
		
		
	}
}
