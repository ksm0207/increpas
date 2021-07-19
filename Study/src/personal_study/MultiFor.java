package personal_study;

public class MultiFor {
	public static void main(String[] args) {
		
		char c = 65;
		
		for (int i = 1 ; i <= 5 ; i ++) {
			
			for (int j= 1 ; j <= 7 ; j ++) {
				System.out.printf("%-2c", c ++);
			}
			
			System.out.println();
		}
	}
}
