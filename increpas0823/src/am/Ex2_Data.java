package am;

import java.io.Serializable;

public class Ex2_Data implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	String name;
	int age;
	
	public Ex2_Data() {
		
	}
	
	
	public Ex2_Data(String string, int i) {
		this.name = string;
		this.age = i;
	}

	

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return "Result : " + "Name = " + name + "\n" + "Age = " + age;
		
	}

}
