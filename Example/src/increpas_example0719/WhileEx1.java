package increpas_example0719;

public class WhileEx1 {
	public static void main(String[] args) {
		
		// 1. 1부터 100까지의 합 구하기 + While
		
		int sum = 0;
		int value = 1;
		// 1. 0 <= 100 조건식 부여
		while(value <= 100) {
			
			// 2. 합 구하기
			sum += value;
			value ++;
			// 3. 연산진행 출력
			System.out.println("sum : " +sum + " " + "value : " + value + " "); 
		}
		System.out.println("1 ~ 100 까지의 합 : " + sum);
	}
}
