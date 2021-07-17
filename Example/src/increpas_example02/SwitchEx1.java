package increpas_example02;

import java.util.Scanner;

public class SwitchEx1 {

	public String check_month(int val) {
		String res = "";
		switch (val) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
				res = "31";
				break;
		case 4:
		case 6:
		case 9:
		case 11:
				res = "30";
				break;
		case 2:
			res ="29";
			break;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SwitchEx1 sw1 = new SwitchEx1();
		
		int input = scan.nextInt();
		String res = sw1.check_month(input);
		
		if (input >= 13) {
			System.out.println("유효하지 못한 값.");
		}else {
			System.out.println(input + " 월은 " + res + "일 까지 입니다." );
		}
	}
}
