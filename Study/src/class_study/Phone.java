package class_study;

public class Phone {
	
	// 멤버 필드 정의
	String color;
	int volume;
	
	public void setColor(String col) {
		color = col;
		System.out.println("색상 : "+color);
	}
	
	public void volumeUp(int up) {
		volume += up;
		System.out.println("볼륨 업 : "+volume);
	}
	public void volumeDown(int down) {
		volume -= down;
		System.out.println("볼륨 다운 : "+volume);
	}
	
	public static void main(String[] args) {
		Phone phone = new Phone();
		
		
		
		phone.setColor("Yellow");
		phone.volumeUp(100);
		phone.volumeDown(43);
	}
}
