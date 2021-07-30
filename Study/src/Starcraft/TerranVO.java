package Starcraft;

public class TerranVO {
	
	String name;
	int minerals;
	int gas;
	int people_count;
	
	public TerranVO(String name , int minerals , int gas , int people_count) {
		this.name = name;
		this.minerals = minerals;
		this.gas = gas;
		this.people_count = people_count;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinerals() {
		return minerals;
	}
	public void setMinerals(int minerals) {
		this.minerals = minerals;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public int getPeople_count() {
		return people_count;
	}
	public void setPeople_count(int people_count) {
		this.people_count = people_count;
	}
	
	@Override
	public String toString() {
		
		return  name + " | "+ " 미네랄 : " + minerals + " | " + " 가스 : " + gas + " | "+ " 인구수 : " +  " | " + people_count;
	}
}
