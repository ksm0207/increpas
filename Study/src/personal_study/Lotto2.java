package personal_study;

public class Lotto2 {
	public static void main(String[] args) {

		int [] array = new int [6];
		
		boolean flag = false;
		
		for (int i = 0 ; i < array.length;) {
			array[i] = (int)(Math.random()* 45+1);
			
			flag = true;
			for (int j = 0 ; j < i ; j ++ ) {
				
				if (array[i] == array[j]) {
					flag = false;
					System.out.printf("%-3d",i);
					System.out.printf("%-3d",j);
					System.out.println(true);
					break;
				}
			}
			if(flag) {
				i++;
			}
			
		}// end of for loop(1)
		//출력
		for (int i : array) {
			System.out.printf("%-3d",i);
		}
		
		
		
	}
}
