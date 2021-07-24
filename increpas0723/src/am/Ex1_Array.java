package am;

public class Ex1_Array {
	public static void main(String[] args) {
		
		int [] array = new int [4];
		
		for (int i = 0 ; i < array.length ; i ++) {
			
			array[i] = (i + 1) * 100;
			
			System.out.printf("%-4d" , array[i]);
		}
		
		System.out.println("-------------------------");
		
		// 객체형 배열 만들기
		String [] str_array = new String [3];
		
		for(int i = 0 ; i < str_array.length ;  i ++) {
			System.out.println(str_array[i]);
		}
		
		StringBuffer [] ar3 = new StringBuffer[4];
		// StringBuffer 4개를 저장할 수 있는 배열을 만들어서
		// 주소를 변수 ar3 이 기억한다 ?
		// 주의) 4개 만들어진 것이 아니고 , 4개를 기억할수 있는
		// 공간이 마련된 것이다 즉 StringBuffer는 4개가 아니다
		
		// 만약 만들려면 다음과 같이 만들어야 한다
		// ar3[0] = new StringBuffer();
		
		// 객체 자료형 배열은 초기값이 null 값이다
		// 저장되는 값은 해당 객체의 주소값이다
		
		// 기본자료형 : 해당 자료형의 값이 저장된다
		

		System.out.println(ar3.hashCode());
		
	}
}
