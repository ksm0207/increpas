package am;

import java.io.*;

public class Ex2_Input {

	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:/Users/user/Desktop/0820/obj_test4.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		
		Object obj = ois.readObject();
		
		if (obj instanceof Ex2_Data) {
			
			Ex2_Data data = (Ex2_Data) obj;
			/* ▲ 위와 같이 형변환을 시켜야 객체 함수를 호출한다.*/
			
			String name = data.getName();
			int age = data.getAge();
			
			System.out.println("name : " + name + "\n" + "age : " + age);
			
		}
	}
}
