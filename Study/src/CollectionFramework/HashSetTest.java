package CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		
		HashSet<String> data = new HashSet<String>();
		
		/* add() 메소드를 통해 요소를 저장 */		 
		data.add("Kim");
		data.add("Nam");
		
		
		/* add() 메소드를 통해 "Kim" 저장 시도 결과 */
		System.out.println(data.add("Kim")); // false 반환
		
		/* add() 메소드를 통해 "Kim2" 저장 시도 결과 */
		System.out.println(data.add("Kim02")); // true 반환
		
		System.out.println("========================");
		
		/* for - each 결과출력 */
		for(String res : data) {
			System.out.println(res);
		/* Result : Kim02 Nam Kim */
		}	
		
		/* add() 메소드를 통해 순서를 바꾼다 */
		data.add("Nam");
		data.add("Kim02");
		data.add("Kim");
		
		System.out.println("========================");
		
		Iterator<String> iter = data.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
