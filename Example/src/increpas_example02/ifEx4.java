package increpas_example02;

import java.util.Scanner;

public class ifEx4 {
	
	public String fruit(String f) {
		
		String res = "";
	
		
		if (f.equals("grape") || f.equals("포도")) {
			res = "달다";
		}else if (f.equals("watermelon") || f.equals("수박")) {
			res = "시원하다";
		}else if (f.equals("strawberry") || f.equals("딸기")) {
			res = "맛있다";
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		ifEx4 i4 = new ifEx4();
		Scanner scan = new Scanner(System.in);
		
		String c = scan.next();
		String input = i4.fruit(c);
		
		if (input != "") {
			System.out.println(c + "은(는)" + input );
		}
		else {
			input = "기타";
			System.out.println(input);
		}
	}
}
