package Inheritance.Game;

public class Unit {
	
	public String attack;   // 공격력
	public String physical; // 체력
	public String mana;     // 마력
	
	public Unit(String attack, String physical , String mana ) {
		
		this.attack = attack;
		this.physical = physical;
		this.mana = mana;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getPhysical() {
		return physical;
	}

	public void setPhysical(String physical) {
		this.physical = physical;
	}

	public String getMana() {
		return mana;
	}

	public void setMana(String mana) {
		this.mana = mana;
	}
}
