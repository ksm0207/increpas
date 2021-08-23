package pm.ArrayListSerializable;

import java.util.ArrayList;
import java.io.*;
import am.Ex2_Data;

public class Ex2_Output {
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Ex2_Data> list = new ArrayList<Ex2_Data>();
		
		list.add(new Ex2_Data("Kim Sung min",1));
		list.add(new Ex2_Data("Nam Yeon seo",2));
		list.add(new Ex2_Data("Seo Yeon woo",3));
		list.add(new Ex2_Data("Kim Ji soo",4));
		
		File file = new File("C:/Users/user/Desktop/0820/obj_test6.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		oos.writeObject(list);
		oos.close();
		
		System.out.println("저장 완료");
	
		

	}

}
