package pm;

public class Ex5_Array {
	public static void main(String[] args) {
		
		// 문자 A B C D 를 기억하는 배열을 생성하자
	
		char [] ch2 = new char [4];
	
		char ch = 'A'; // 유니코드 값 이니깐 연산이 가능하지
		
		for (int i = 0 ; i < ch2.length ; i ++) {
			
			// i = 0 1 2 3
			//     A B C D ++ 4
			ch2[i] += ch ++;
			System.out.println(ch2[i]);
		}
		System.out.println(ch);
		
	}
}
