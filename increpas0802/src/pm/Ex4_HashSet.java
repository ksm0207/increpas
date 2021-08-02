package pm;

import java.util.HashSet;
import java.util.Iterator;

public class Ex4_HashSet {
	public static void main(String[] args) {
		
		HashSet<Integer> getInt = new HashSet<Integer>();
		
		if (getInt.isEmpty()) {
			System.out.println("getInt.isEmpty() : " + true);
		}else {
			System.out.println("getInt.isEmpty() : " + false);			
		}
		
		getInt.add(100);
		getInt.add(200);
		getInt.add(200); // Set : 중복을 허용하지않음
		getInt.add(300);
		
		if(getInt.add(200)) {
			System.out.println("추가 완료.");
		}else {
			System.out.println("추가 실패");
		}
		
		System.out.println(getInt.size());
		
		if(getInt.remove(300))
			System.out.println(true);
		else {
			System.out.println(false);
		}
		
		System.out.println(getInt.size());
		
// 		set구조는 Index가 없기 때문에 반복자인 Iterator로
//		반복 처리해야 한다.
		
		// set구조로부터 반복자 객체를 얻어내기
		Iterator<Integer> iter = getInt.iterator();
		
		System.out.println(iter.hashCode());
		System.out.println(getInt.hashCode());
		
		
		
//		hasNext() : 반복의 다음 요소를 반환합니다
//					값이 있으면 true | false
		
		while(iter.hasNext()) {
			int n = iter.next(); // 해당 요소를 반환한다
			System.out.printf("%-4d", n);
		}
		// 속도측면에서 봤을때 iterator 가 더 우수하다.
		// get(i) 로 N번지를 순서대로 찾는다고 가정하면
		
		// hasNext() 메소드로 값이 있는지 체크 한다음
		// 바로 커서가 이동하여 요소를 반환할 수 있다
		

	}
}
