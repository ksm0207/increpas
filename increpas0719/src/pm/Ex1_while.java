package pm;

public class Ex1_while {
	public static void main(String[] args) {
		
		int i = 1;
		while(i <= 10) {
			
			System.out.printf("%-2d", i);
			++ i;
		}
		System.out.println();
		i = 1;
		int sum = 0;
		while (i <= 10) {
			sum = (sum) + (i++);
			System.out.println("Sum = " + sum + " " + "i = " + i);
		}
			
		// printf() 첫번째 들어오는 값은 포맷을 지정함
		System.out.printf("1 ~ 10 까지의 합 : %-3d" , sum);
	}
}
