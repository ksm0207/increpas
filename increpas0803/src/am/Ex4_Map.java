package am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex4_Map {
	public static void main(String[] args) {
		
		HashMap<String, String> map_data = new HashMap<String, String>();
		
		map_data.put("도서번호1", "도서1");
		map_data.put("도서번호2", "도서2");
		map_data.put("도서번호3", "도서3");
		map_data.put("도서번호4", "도서4");
		
		System.out.println("data.size() : " + map_data.size());

		Set<String> find = map_data.keySet();
		
		System.out.println(find);
		
		
		
		
	}
}
