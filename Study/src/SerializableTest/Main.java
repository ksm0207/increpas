package SerializableTest;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Main {
	
	public static void main(String[] args) {
		
		Member member = new Member("Kim", "ksm03071@naver.com", 27);
		
		byte[] serializedMember;
		
		try {
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(member);
			
			serializedMember = baos.toByteArray();
			
			System.out.println(Base64.getEncoder().encodeToString(serializedMember));
			
		}catch (Exception e) {
			
		}
	}

}
