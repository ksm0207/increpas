package SerializableTest.FirstExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectSave {
	
	public static void main(String[] args) throws Exception {
		
		
		/* 객체를 직렬화 하는 과정 */
		
		SerialDTO dto = new SerialDTO("Serializable" , 1 , 17500 , true);
		
		String path = "C:/Users/user/Desktop/Serializable/test.txt";
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(dto);
		
		System.out.println("Data Save");
		oos.close();
	}

}
