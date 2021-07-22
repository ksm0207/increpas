package increpas_example0721;

public class Gugudan {
	public static void main(String[] args) {
		
		System.out.println("---------- Java Run ----------");
		for (int i = 1 ; i <= 9 ; i ++) {
			
			for (int j = 2 ; j <= 9 ; j ++) {
				
				  System.out.print( j + " * " + i + " = " + String.format("%2d", i * j));
		          System.out.print("    ");
			}
			System.out.println();
		}
		System.out.println("Normal Termination");
		System.out.println("출력 완료");
		
	}
}
