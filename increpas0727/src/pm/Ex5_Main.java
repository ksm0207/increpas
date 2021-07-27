package pm;

public class Ex5_Main {
	
	public void setData(Ex5_Data changeData) {
		changeData.setName("Sungmin");
		changeData.setPhone("010-5555-5555");
	}
	
	public static void main(String[] args) {
		
		Ex5_Data data = new Ex5_Data();
		
		
		String name = data.getName();
		System.out.println("name : " + name);
		
		String phone = data.getName();
		System.out.println("phone : " + phone);
		
		// 이제 원하는 이름과 전화번호로 변경
		
		data.setName("Kim");
		data.setPhone("010-1234-5678");
		
		String name2 = data.getName();
		System.out.println("name2 : " + name2);
		
		String phone2 = data.getPhone();
		System.out.println("phone2 : " + phone2);
		
		Ex5_Main data_main = new Ex5_Main();
		
		data_main.setData(data);
		
		String name3 = data.getName();
		System.out.println("name3 : " + name3);
		
		String phone3 = data.getPhone();
		System.out.println("phone3 : " + phone3);
	}

}
