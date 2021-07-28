//package pm;
//
//import java.util.Scanner;
//
////자판기 객체를 의미
//public class Ex2_Vend {
//
//	Ex2_Drink[] ar = new Ex2_Drink[4];
//	
//	//음료수배열을 초기화하는 동작(Ex2_Drink객체를 4개 만들어서 배열에 저장)
//	public void setAr() {
//		//배열의 요소 4개를 하나씩 초기화 해야 하므로 반복문이 필요하다.
//		for(int i=0; i<ar.length; i++) {
//			ar[i] = new Ex2_Drink();
//			switch(i) {
//				case 0:
//					ar[i].setName("레츠비");
//					ar[i].setPrice(600);
//					break;//switch문 탈출!
//				case 1:
//					ar[i].setName("사이다");
//					ar[i].setPrice(700);
//					break;//switch문 탈출!
//				case 2:
//					ar[i].setName("콜라");
//					ar[i].setPrice(700);
//					break;//switch문 탈출!
//				case 3:
//					ar[i].setName("게토레이");
//					ar[i].setPrice(900);
//					break;//switch문 탈출!
//				
//			}
//		}
//	}
//	
//	//인자로 금액을 받아 받은 금액보다 음료수 가격이 작거나 같은 음료들을
//	// 출력하는 동작
//	public void printDrink(int money) {
//		//받은 금액으로 선택가능한 음료의 이름을 출력하는 반복문
//		for(int i=0; i<ar.length; i++) {
//			//금액 비교
//			if(money >= ar[i].getPrice())
//				System.out.printf("%2d. %s:%d ",
//						i+1, ar[i].getName(), ar[i].getPrice());
//		}
//		System.out.println();//줄바꿈!
//	}
//	
//	// 잔액을 알려주는 동작
//	
//	
//	public static void main(String[] args) {
//		// 프로그램 시작
//		Ex2_Vend vend = new Ex2_Vend();
//		vend.setAr(); // 준비된 배열 초기화!! (레츠비, 사이다, 콜라, 게토레이)
//		
//		//사용자가 입력하는 금액을 받아야 하므로 Scanner준비!!!
//		Scanner scan = new Scanner(System.in);
//		System.out.println("돈을 입력하세요 :");
//		int money = scan.nextInt();
//		
//		//받은 금액을 인자로 보내서 선택가능한 음료를 출력하는 함수 호출!!
//		vend.printDrink(money);
//		
//		//출력된 음료들중 하나를 선택하도록 유도한다.
//		System.out.println("선택:");
//		int num = scan.nextInt();
//		
//		// num은 배열의 index값보다 1씩 더 크다. 사용자가 1을 선택했다면
//		// 배열의 index값으로 사용하기 위해 -1을 해야 한다.
//		// num을 전달하여 선택된 음료가 무엇이고 잔액이 얼마인지를 출력하는 함수 호출!
//		
//	}
//
//}
