package personal_study;

public class PersonMain {
	
	public static void main(String[] args) {
		
		PersonInfo info = new PersonInfo();
		
		info.setName("Kim");
		info.setEmail("kkkkkk@gmail.com");
		info.setAge(27);
		
		String name = info.getName();
		System.out.println("name : " + name);
		
		String email = info.getEmail();
		System.out.println("email : " + email);
		
		int age = info.getAge();
		System.out.println("age : " + age);
		
	}
}
