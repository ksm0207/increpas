package am;

import java.util.HashMap;
import java.util.Map;

public class Ex3_Map {
	public static void main(String[] args) {
		
		HashMap<Integer, String> data = new HashMap<Integer, String>();
		
		data.put(0, "A10");
		data.put(1, "B7");
		System.out.println("size() : " + data.size());
		
		data.put(0, "B7"); // 똑같은 키가 있기때문에 추가가 아닌
//							  Value를 변경한다
		
//		Map 구조는 키(key) 를 통해 값(value)를 얻는 구조
		String res = data.get(0);
		System.out.println("res ===> " +res);
		
		for(int i=0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
		
		data.remove(0); // 0번째 요소 삭제
		
		res = data.get(0); // 0번째 검색
		System.out.println("res ===> " +res); // null
		
		System.out.println(data.size());
		
	}
}
