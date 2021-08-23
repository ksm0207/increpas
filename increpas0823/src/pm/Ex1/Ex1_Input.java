package pm.Ex1;

import java.io.*;

import am.Ex2_Data;

public class Ex1_Input {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:/Users/user/Desktop/0820/obj_test5.txt");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		Object obj = ois.readObject();
		
		Ex1_Object ex = (Ex1_Object) obj;
		Ex2_Data data = ex.getData();
		
		System.out.println(data.getName() + " " + data.getAge());
		System.out.println(ex.getValue());
		
		
		
	}

}
