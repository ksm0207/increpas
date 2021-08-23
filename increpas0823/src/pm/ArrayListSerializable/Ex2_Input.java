package pm.ArrayListSerializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import am.Ex2_Data;
import pm.Ex1.Ex1_Object;

public class Ex2_Input {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:/Users/user/Desktop/0820/obj_test5.txt");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		Object obj = ois.readObject();
		
		ArrayList<Ex2_Data> res = (ArrayList<Ex2_Data>) obj;
		ois.close();
		
		
		for(int i=0; i< res.size(); i++) {
			Ex2_Data data = res.get(i);
			System.out.println(data.getName() + " / " + data.getAge());
		}
	}
}
