package InterFace.student3;

import java.util.Scanner;

public class Main {
	
	public void getConversionResult(ScoreConversion score) {
		score.conversion();
	}
	
	public void getStart() {
		
		ScoreInputA scoreA = new ScoreInputA();
		ScoreInputB scoreB = new ScoreInputB();
		ScoreInputC scoreC = new ScoreInputC();
		Main main = new Main();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.next();
		
		System.out.print("과목을 입력하세요 : ");
		String subject = scan.next();
		
		System.out.print("점수를 입력하세요 : ");
		int score = scan.nextInt();
	
		System.out.println("어떤 방법으로 출력할까요?");
		
		System.out.println("등급으로 확인 A");
		System.out.println("학점으로 확인 B");
		System.out.println("합격여부 확인 C ");
		
		System.out.print("입력 : ");
		String selectCode = scan.next();
		
		if (selectCode.equals("A")) {
			
			System.out.println(selectCode + " 방법을 선택하였습니다.");
			System.out.println("결과 출력");
	
			scoreA.name = name;
			scoreA.subject = subject;
			scoreA.score = score;
			
			main.getConversionResult(scoreA);
			
		}else if (selectCode.equals("B")) {
			
			System.out.println(selectCode + " 방법을 선택하였습니다.");
			System.out.println("결과 출력");
	
			scoreB.name = name;
			scoreB.subject = subject;
			scoreB.score = score;
			
			main.getConversionResult(scoreB);
			
		}else if (selectCode.equals("C")) {
			
			System.out.println(selectCode + " 방법을 선택하였습니다.");
			System.out.println("결과 출력");
	
			scoreC.name = name;
			scoreC.subject = subject;
			scoreC.score = score;
			
			main.getConversionResult(scoreC);
		}
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.getStart();
	}
}
