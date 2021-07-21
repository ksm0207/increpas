package pm;

public class Ex7_Array {
	   
   public static void main(String[] args) {
      // 도전문제
   
      boolean check = true;
      // 정수 3개를 저장할 수 있는 배열을 만든다
      int [] arr = new int [3];
      // 1 ~ 9 까지의 값들 중 난수를 발생한다
      // 중복을 허용하면 안된다
      for (int i = 0 ; i < arr.length ;) {
         arr[i] = (int)(Math.random()*10)+1;
         check = true;
         for (int j = 0 ; j < i ; j ++) {
            // 중복값 체크
            if (arr[i] == arr[j]) {
            	check = false;
            	System.out.println("중복값 확인 : " +arr[i]);
            	break;
            }
         } // end of for loop(2)
         if (check == true) {
            i++;
         }
      }// end of for loop (1)
      
      // 결과 출력
      for (int i = 0 ; i < arr.length ; i ++) {
         System.out.println("arr " + i + " ======= > " + arr[i]);
      }
   }
}