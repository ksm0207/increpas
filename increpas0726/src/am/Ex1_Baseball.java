package am;

import java.util.Scanner;

public class Ex1_Baseball {
	
	int[] com = new int[3];
	int[] user = new int[3];
	int s_cnt ; // 초기화를 하지 않았지만 속성에 정의되는 변수들은
	            // 기본값으로 초기화 됩니다.
	
	//-------------------------------------------------
	
	// 컴퓨터의 값 이 초기화 되는 동작
	
	public void init() {
		
		for (int i = 0 ; i < com.length; i ++) {
			com[i] = (int)(Math.random()* 9 + 1);
			
			boolean chk = false;
			
			for (int j = 0 ; j < i ; j ++) {
				if(com[j] == com[i]) {
					// com[i]에 중복된 값을 받은 경ㅇ
					chk = true;
					break;
				}
			}
			// 중복된 값이 있어서 break로 왔는지 ?
			// 혹은 중복된 값이 없어서 for문을 벗어났는지? 체크!
			if(!chk)
				i++; // 중복된 값이 없을때 i ++
		}
	}
	
	// 사용자의 값 이 초기화 되는 동작
	
	public void setUser() {
		
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<user.length; i++) {
            switch(i) {
               case 0:
                  System.out.println("첫번째 값:");
                  break;//switch문 탈출
               case 1:
                  System.out.println("두번째 값:");
                  break;//switch문 탈출
               case 2:
                  System.out.println("세번째 값:");
                  break;//switch문 탈출
            }
            user[i] = scan.nextInt();
         }
	}
	
	// 스트라이크 의 수를 확인하는 동작
	
	// 볼의 수를 확인하는 동작

	public static void main(String[] args) {
		
	}
}
