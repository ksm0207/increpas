import java.util.Scanner;

public class Gugudan {
	
	public static void main(String[] args) {
		
		// String
		
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.print("Dan : ");
		String dan = scan.next();
		int parseing = Integer.parseInt(dan);

		for (int i=1; i<=9; i++) {
			sb.append(dan);
			sb.append(" * ");
			sb.append(Integer.toString(i));
			sb.append(" = ");
			sb.append(Integer.toString(parseing * i));
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
