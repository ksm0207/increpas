package am;

import java.util.Scanner;

public class Main {
	
	StudentVO [] person;
	
	// 배열을 초기화 동작 (전공 : 컴퓨터공학 , 물리학과 , 실용음악)
	public void initStudentVO() {
		person = new StudentVO[1];
	
		for (int i=0; i<person.length; i++) {
			person[i] = new StudentVO();
			// StudentVO 내부에 있는 mvo에 저장해줄
			// MajorVO객체의 주소를 준비한다
			MajorVO mvo = new MajorVO();
			person[i].setMvo(mvo);
			
			switch (i) {
			case 0:
				person[i].setNumber("21");
				person[i].setName("Kim");
				person[i].getMvo().setTitle("컴퓨터전공");
				person[i].getMvo().setTitle("컴퓨터");
				person[i].getMvo().setManager("알수없음");
				break;
			}
		}
	}// end of initStudentVO()
	
	// 이름으로 검색하여 학생정보를 화면에 출력하는동작 만들기
	
	public String getSearch(String name) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<person.length; i++) {
			
			StudentVO search = new StudentVO();
			search = person[i];
		
			if (search.getName().contains(name)) {
				sb.append("이름 : ");
				sb.append(search.getName());
				sb.append("\n");
				sb.append("학번 : ");
				sb.append(search.getNumber());
				sb.append("\n");
				sb.append("전공 : ");
				sb.append(search.getMvo().getTitle());
				sb.append("\n");
				sb.append("학과장 : ");
				sb.append(search.getMvo().getManager());
			}
			// end of if-else
		}// end of for loop(1)
		return sb.toString();
	} 
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.initStudentVO();
		Scanner scan = new Scanner(System.in);
		String find = scan.next();
		
		String res = main.getSearch(find);
		
		System.out.println(res);
		
	}

}
