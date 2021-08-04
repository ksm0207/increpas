package Inheritance.aaa;

public class Hunter extends Unit {
	
	String name;     // 이름
	String weapons;  // 무기

	public Hunter(String attack, String physical, String mana , String name , String weapons) {
		super(attack, physical, mana);
		this.name = name;
		this.weapons = weapons;
	}
	
	public String getName() {
		return name;
	}
	
	public String getWeapons() {
		return weapons;
	}

}
