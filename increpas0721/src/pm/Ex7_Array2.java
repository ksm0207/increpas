package pm;

public class Ex7_Array2 {
	public static void main(String[] args) {
		
		int [] ar = new int [3];
		// 1 ~ 9 중 난수 발생하여 배열의 각 요소에 저장하는 반복문
		for (int i = 0 ; i < ar.length ;) {
			
			// 난수 발생과 배열에 대입
			ar[i] = (int)(Math.random()*9 + 1);
		
			boolean chk = false;
			
			// 중복된 값이 있는지 판단하는 반복문
			for (int j = 0 ; j < i ; j ++) {
				
				// 현재 배열의 i번째 요소와 그 이전의 요소들을 비교하여
				// 같은 값이 있는지 찾아준다
				
				if (ar[i] == ar[j]) { // ar[i] == ar[0]
					chk = true;
					System.out.println("중복값 발생 : " + ar[i] + " " + ar[j]);
					break;
				}
			}
			if(!chk) { // 같은 값이 있다는 것을 판단(chk true 일때)
			 i++;      // 즉 같은 값이 있을 때는 i 값이 증가하면 안된다    
			}          // chk 가 false를 유지할 때만 i값 증가해야한다.
			           // chk 가 flase 이면 반대값인 true 로 인식한다
		}
		
		for (int i = 0 ; i < ar.length ; i ++) {
			System.out.println(ar[i]);
		}
		
		
	}
}
