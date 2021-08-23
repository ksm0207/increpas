package SerializableTest.ArrayListExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberSave {
	
	public static void main(String[] args) throws Exception {
		
		/* 직렬화 */
		ArrayList<Member> list = new ArrayList<Member>();
		
		String path = "C:/Users/user/Desktop/Serializable/test2.txt";
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		list.add(new Member("K","xxx01@naver.com",27));
		list.add(new Member("S","ooo02@daum.com",25));
		list.add(new Member("M","ppp03@naver.com",24));
		list.add(new Member("S","ccc@04@gmail.com",29));
		list.add(new Member("U","aaa@05@naver.com",30));
		
		
		/* 저장 할 데이터 명시 */
		if (!list.isEmpty()) {
			oos.writeObject(list);
			System.out.println("Save Data !");
		}
		
	}

}
