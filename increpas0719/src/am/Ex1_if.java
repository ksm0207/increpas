package am;

import java.util.Scanner;

public class Ex1_if {
	
	public String ageCheck(int age) {
		String res = "";
		
		if (age >= 40) {
			res = "어르신";
		}else if (age >= 30) { // 자연스럽게 30~ 39까지 범위를 저장함
			res = "정말 좋을 때";
		}else if (age >= 20) {
			res = "눈물나게 좋을 때";
		}else {
			res = "미성년";
		}
		return res;
	}
	public static void main(String[] args) {
		
		// 1.나이 입력받기
		// 2. 40 대 -> 어르신
		// 3. 30 대 -> 정말 좋을 때
		// 4. 20 대 -> 눈물나게 좋을 때
		// 5. 10 대 -> 미성년 
		Scanner scan = new Scanner(System.in);
		Ex1_if ex1 = new Ex1_if();
		
		int val = scan.nextInt();
		String res = ex1.ageCheck(val);
		
		if (res != "")
			System.out.println(res +" 입니다");
	}
}
