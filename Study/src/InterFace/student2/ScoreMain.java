package InterFace.student2;

import java.util.Scanner;

public class ScoreMain {
	
	public static void main(String[] args) {
		/**
		 * 1. 추상클래스를 하나 만든다. 여기에는 학생 이름, 과목, 점수 필드가 있다.
		 * 2. 인터페이스 ScoreConversion는 conversion()이 있고, 인터페이스 ScoreOutput에는 output()이 있다.
		 * 3. 추상클래스와 인터페이스 2개를 상속받는 클래스는 A,B,C가 있다.
		 * 4. A에서는 conversion()에서 점수에따라 20점씩 1등급부터 5등급으로 나뉘고, 그 결과를 output()에서 
		 * "x님의 등급은 k등급입니다."를 출력한다.
		 * 5. B에서는 conversion()에서 점수에따라 20점씩 A등급부터 B,C,D,과락등급으로 나뉘고, 그 결과를 
		 * output()에서 "x님의 학점은 'K'입니다."를 출력한다. (과락일 시, "재수강이 필요합니다" 문구 추가)
		 * 6. C에서는 conversion()에서 60점을 기준으로 합격/불합격으로 나뉘고, 그 결과를 output()에서 
		 * "x님의 시험결과는 K입니다."를 출력한다.
		 * */
		
		/**
		 * 입력 : 이름, 과목명, 점수(100점 기준)
		**/
		Scanner scan = new Scanner(System.in);
		
		ScoreA sA = new ScoreA();
		ScoreB sB = new ScoreB();
		ScoreC sC = new ScoreC();
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
	
		
		System.out.print("과목 입력 : ");
		String subject = scan.next();
		
		
		System.out.print("점수 입력 : ");
		int score = scan.nextInt();
		
		
		System.out.println("================================");
		String select = "";
		System.out.println("어떤 방법으로 출력할까요?");
		System.out.print("A  B  C : ");
		
		select = scan.next();
		if (select.equals("A")) {
			sA.name = name;
			sA.score = score;
			sA.conversion();
		}else if (select.equals("B")) {
			sB.name = name;
			sB.score = score;
			sB.conversion();
		}else if (select.equals("C")) {
			sC.name = name;
			sC.score = score;
			sC.conversion();
		}
	}
}
