package SerializableTest.Base64;

import java.io.Serializable;

public class Member implements Serializable{
	
	private String name;
	private String email;
	private int age;
	
	
	public Member(String name, String email , int age) {
		
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return String.format("Member : ", name , email , age);
	}

}
