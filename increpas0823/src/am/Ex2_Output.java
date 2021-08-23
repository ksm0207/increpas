package am;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;


public class Ex2_Output  {

	public static void main(String[] args) throws Exception {
		
		Ex2_Data data = new Ex2_Data();
		
		data.setName("Kim");
		data.setAge(27);
		
		
		File file = new File("C:/Users/user/Desktop/0820/obj_test4.txt");
		FileOutputStream fos = new FileOutputStream(file);
		
		
		/* 객체를 사용(쓰기)하기 위한 ObjectOutputStream */
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		StringBuffer sb = new StringBuffer();
		
		oos.writeObject(data);
	
	}
}
