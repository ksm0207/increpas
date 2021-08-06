package InterFace.Student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		Student stu = new Student();
		
		stu = new Student();
		Scanner scan = new Scanner(System.in);
		
		String name = "";
		System.out.print("이름 : ");
		name = scan.next();
		stu.setName(name);
		
		System.out.print("국어 점수 :");
		int kor = scan.nextInt();
		stu.kor = kor;
		
		System.out.print("수학 점수 :");
		int math = scan.nextInt();
		stu.math = math;
		
		System.out.print("영어 점수 :");
		int eng = scan.nextInt();
		stu.eng = eng;
		
		System.out.print("과학 점수 :");
		int science = scan.nextInt();
		stu.science = science;
		
		System.out.println("===========================");
		
		System.out.println("결과");
		System.out.println("이름 : "+stu.getName());
		
		main.getStudentScore(stu);
		main.getStudentAvg(stu);

	}
	

	
	public void getStudentScore(Score score) {
		System.out.println("총점 : "+score.score());
	}
	public void getStudentAvg(Score score) {
		
		System.out.println("평균 : " + score.avg());
	}

}
