package SerializableTest.ArrayListExample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;


public class MemberList {

	public static void main(String[] args) throws Exception {
		
		/*역직렬화*/
		
		String path = "C:/Users/user/Desktop/Serializable/test2.txt";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		
		Object obj = ois.readObject();
		
		if(obj != null) {
			ArrayList<Member> list = (ArrayList<Member>) obj;
			
//			for (int i=0; i<list.size(); i++) {
//				
//				Member member = list.get(i);
//				
//				System.out.println(member.getName());
//				
//			}
			
			for (Member res : list) {
				
				System.out.println(res);
			}
			
		}
	}
}
