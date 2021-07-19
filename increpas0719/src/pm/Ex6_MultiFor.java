package pm;

public class Ex6_MultiFor {
	public static void main(String[] args) {
		
		char c = 65;
		
		for (int i = 1 ; i <= 3 ; i ++) {
			for (int j= 1; j <= 5 ; j++) {
				System.out.printf("%-2c",c ++);
			}
			System.out.println();
		}
	}
}
