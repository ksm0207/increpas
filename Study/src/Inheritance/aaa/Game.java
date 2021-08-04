package Inheritance.aaa;

public class Game {

	public static void main(String[] args) {
		
		Hunter hunter = new Hunter("500", "2000", "750", "용사님","전설의 나뭇가지");
		
		System.out.println("이름 : " + hunter.getName());
		System.out.println("무기 : " + hunter.getWeapons());		
		System.out.println("공격력 : " + hunter.getAttack());
		System.out.println("체력 : " + hunter.getPhysical());
		System.out.println("마력 : " + hunter.getMana());
		
	}
}
