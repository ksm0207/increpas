package am;

public class Ex1_lotto {
	public static void main(String[] args) {
		
		int [] array = new int [6];
		
		boolean flag = true;
		
		// i ++ 지운이유 : 난수를 발생시켜 저장할 때 같은 값이 있다면
		// 해당 요소에 다시 난수를 발생시켜서 저장하려고.
		// 즉 중복값이 없다는 것이 확인 될 때 따로 증가시키려고 생략한다.
		for (int i = 0 ; i < array.length ;) {
			array[i] = (int)(Math.random()* 45)+1;
			
			flag = true;
			
			for (int j = 0 ; j < i ; j ++) {
				
				if (array[i] == array[j]) {
					System.out.println("중복값 : " + array[i] + " " + array[j]);
					flag = false;
					break;
				}
			} // end of for loop(2)
			
			if (flag) {
				i ++;
			}
		}// end of for loop(1)
		
		for (int i : array) {
		    System.out.print(" "+String.format("%-4d", i));
		}
	}
}
