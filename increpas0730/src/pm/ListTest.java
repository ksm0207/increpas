package pm;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		
		// 문자열들을 여러 개 저장하는 구조(객체) - 배열과 비슷한 객체
		ArrayList<String> str = new ArrayList<String>();
		
		str.add("A");
		int size = str.size();
		System.out.println(size);
		
		str.add("B");
		str.add("C");
		str.add("D");
		
		System.out.println(str.size());
		
		str.remove(3);
		
		System.out.println(str.size());
		
		
		
		for (int i = 0 ; i < str.size() ; i ++ ) {
			System.out.println(str.get(i));	
		}
		
		
	}
}
