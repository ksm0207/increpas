package pm;

import java.util.Scanner;

public class Ex5_HomeWork {

   public static void main(String[] args) {
      // 프로그램 시작 - 숫자야구게임

      //1) 난수 발생 (1~9까지의 값을) 3개 저장해야 한다.
      int[] com = new int[3];
      
      // 난수 발생하여 배열요소에 저장하는 반복문
      for(int i=0; i<com.length; ) {
         com[i] = (int)(Math.random()*9+1);
         
         //위에서 저장된 난수가 이미 앞 칸에 저장된 값이라면
         // 다시 난수를 발생시켜 저장해야 한다.
         boolean chk = false; //중복된 값이 들어왔다면 true로 변경됨!
         
         //중복값을 체크하는 반복문(지금 막 받은 난수: 13번행의 코드,
         // 이전에 같은 값이 있는지를 확인하는 반복문)
         for(int j=0; j<i; j++) {
            if(com[i] == com[j]) {
               //여기에 들어왔다면 중복된 값을 받았다는 뜻이므로
               //chk값을 true로 변경한 후 반복문 탈출!
               chk = true;
               break;
            }
         }
         
         // chk가 false를 유지하고 있다면 중복된 값이 없다는 뜻이므로
         //이때만 i값을 증가시키자!
         if(!chk)
            i++;
      }//for문의 끝
      
      
      //2) 사용자가 숫자를 하나씩 입력하여 3개를 비교 해야 한다.
      //  ( 같은 위치에 같은 값이 있으면 스트라이크!, 같은 숫자가 다른 위치에
      //    있으면 볼! 프로그램 스트라이크가 3개가 모일 때까지 계속 반복수행!)
      Scanner scan = new Scanner(System.in);
      int[] user = new int[3];
      int s_cnt = 0;
      int count = 0;
      do {
         /*
         System.out.println("첫번째 값:");
         user[0] = scan.nextInt();
         System.out.println("두번째 값:");
         user[1] = scan.nextInt();
         System.out.println("세번째 값:");
         user[2] = scan.nextInt();
         */
         //위의 내용을 반복문으로 수행한다면...
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
         
         // com배열과 user배열의 값들을 비교하여 스트라이크 수를 확인한다.
         s_cnt = 0;
         for(int i=0; i<user.length; i++) {
            if(com[i] == user[i])
               s_cnt++; // s_cnt += 1; // s_cnt = s_cnt+1;
         }
         
         // 볼의 수를 확인하는 반복문
         int b_cnt = 0;
         for(int i=0; i<user.length; i++) {
            // com과 user 배열의 각각 같은 위치의 값을 비교하는 것이 아니라
            // 1칸 뒤와 2칸 뒤의 요소를 비교하여 같은 값일 때 b_cnt를 증가!
            if(com[(i+1)%com.length] == user[i] || 
                  com[(i+2)%com.length] == user[i])
               b_cnt++;
         }
         
         //s_cnt가 3이면 프로그램 종료! 그렇지 않으면 사용자가 값을 다시 입력하여 
         // 계속 반복 수행해야 한다.
         count++;
         System.out.printf("%-2d) %-2d,%-2d,%-2d: %-2d스트라이크,%-2d볼\n",
               count,user[0],user[1],user[2],s_cnt,b_cnt);
      }while(s_cnt < 3);
      
      System.out.println(count+"번 시도로 프로그램 종료!");
   }

}