package pm.Ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import am.Ex2_Data;

public class Ex1_Output {

	public static void main(String[] args) throws Exception {
		
		Ex1_Object obj = new Ex1_Object(new Ex2_Data("Kim",27), "Test Data");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/user/Desktop/0820/obj_test5.txt"));
		
		oos.writeObject(obj);
		oos.close();
	}
}
