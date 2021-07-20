package class_study;

import java.util.Scanner;

public class Person {
	
	String name;
	int age;
	int children;
	boolean isMarried;
	
	public void peopleInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("결혼 여부 : " + isMarried);
		System.out.println("자녀 수 : " + children);
	}
	
	
	public static void main(String[] args) {
//		Q1.다음 객체에 대한 설명에 맞는 클래스를 만들고 값을 출력해 보세요.
//		나이가30살, 이름이 James라는 남자가 있습니다.
//      이 남자는 결혼을 했고 자식이 셋 있습니다.
		
		Person person = new Person();
		Scanner scan = new Scanner(System.in);
		
		String inputName = "";
		String checkMarred = "";
		int inputAge = 0;
		int checkChildren = 0;
		
		System.out.print("이름을 입력해주세요 : ");
		person.name = inputName = scan.next();
		System.out.print("나이를 입력해주세요 : ");
		person.age = inputAge = scan.nextInt();
		System.out.print("결혼 여부 : Y 혹은 N 입력 : ");
		checkMarred = scan.next();
		
		if (checkMarred.equals("Y") || checkMarred.equals("y")) {
			person.isMarried = true;
			if (person.isMarried) {
				System.out.println("자녀는 몇명인가요 ? : " );
				person.children = checkChildren = scan.nextInt();
			}
		}else if (checkMarred.equals("N") || checkMarred.equals("n")) {
			person.isMarried = false;
			person.children = 0;
		}else {
			System.out.println("Null");
		}
		person.peopleInfo();
	}
}
