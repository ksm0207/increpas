package am;

public class Ex1_Main {
	
	public static void main(String[] args) {
		
		Ex1_House house = new Ex1_House();
		
		house.setFloor(2);
		house.setRoom(8);
		house.setRestroom(4);
		house.setBalcony(3);
		house.setDirection("동향");
		
		
		Ex1_House house2 = new Ex1_House();
		
		house2.setFloor(1);
		house2.setRoom(6);
		house2.setRestroom(3);
		house2.setBalcony(2);
		house2.setDirection("남향");
		
		System.out.println(house.getRoom());
		System.out.println(house2.getRoom());
		
		System.out.println(house.hashCode());
		System.out.println(house2.hashCode());

	}
}
