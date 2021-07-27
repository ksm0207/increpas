package pm;

public class Ex3_Main {
	public static void main(String[] args) {
		
		Ex3_Test ex3 = new Ex3_Test();
		
		int[] ar = new int[3];
		
		for (int i = 0 ; i < ar.length; i ++) {
			ar[i] = i+1;
			System.out.println(ar[i]);
		}
		
		ex3.ex(ar);
		
		for (int i=0 ; i<ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

}
