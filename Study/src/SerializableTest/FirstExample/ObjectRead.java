package SerializableTest.FirstExample;

import java.io.*;

public class ObjectRead {
	
	public static void main(String[] args) throws Exception  {
		
		String path = "C:/Users/user/Desktop/Serializable/test.txt";
		
		/* 역직렬화 과정 */
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		
		Object obj = ois.readObject();
		SerialDTO dto = (SerialDTO) obj;
		
		System.out.println(dto);
		
		ois.close();
		
	}
}
