package am;

public class Ex2_Exception {
	public static void main(String[] args) {
		
		int[] array = new int[3];
	
		try {
			// i<=length
			
			for(int i=0; i<=array.length; i++) {	
				array[i] = (i+1) * 100;
			}	
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		// i<length
		for (int i=0; i<array.length;i ++) {
			System.out.println(array[i]);
		}
		
	}
}
