package class_study;

class Animal {
	int age;
	String name;
	String animalType;
	
	boolean live;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age > 2) {
			
			System.out.println("나이가 많습니다");
		}else {
			System.out.println("나이가 적습니다");
		}
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}

public class AnimalMain {
	
	
	public static void main(String[] args) {
		Animal animal1 = new Animal();
		
		animal1.setName("사슴");
		animal1.setAge(3);
		animal1.setLive(true);
		
		System.out.println("이름 : "+animal1.getName());
		System.out.println("나이 : "+animal1.getAge());
		System.out.println("생존 여부 : "+animal1.isLive());
		
	}
	
}



