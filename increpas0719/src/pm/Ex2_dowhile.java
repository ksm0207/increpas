package pm;

public class Ex2_dowhile {
	public static void main(String[] args) {
		
		int i = 0;
		int sum = 0;
		do {
			i ++;
			sum = sum + i;
			System.out.println("sum = " + sum + " " + "i = " + i);
			
		} while (i < 100);
		System.out.println("1부터 100까지의 합은 : " +sum);	
	}
}
