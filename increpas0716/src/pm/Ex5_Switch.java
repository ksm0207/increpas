package pm;

import java.util.Scanner;

public class Ex5_Switch {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String res = "";
		
		int score = scan.nextInt();
		
		
		
		switch (score) {
		case 90: res = "상";
		         System.out.println(res);
		         break;
		case 40: res = "하";
		         System.out.println(res);
		         break;    
		case 60: res = "중";
        		 System.out.println(res);
        		 break;  
		default: res = "Exit";
				 System.out.println(res);
		}
	}
}
