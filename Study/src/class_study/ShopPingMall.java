package class_study;

public class ShopPingMall {
	
	String orderNumber;
	String ordererID;
	String ordName;
	String date;
	String productNumber;
	String address;
	
	public void info() {
		System.out.println("주문 번호 : " + orderNumber);
		System.out.println("주문자 아이디 : " + ordererID);
		System.out.println("주문자 이름 : " + ordName);
		System.out.println("주문 날짜 : " + date);
		System.out.println("주문 상품 번호 : " + productNumber);
		System.out.println("배송 주소 : " + address);
	
	}
	
	public static void main(String[] args) {
		ShopPingMall sp = new ShopPingMall();
		sp.orderNumber = "202107200001";
		sp.ordererID = "ksm03071";
		sp.ordName = "Kim";
		sp.date = "2021-07-20";
		sp.productNumber = "PD-345-12";
		sp.address = "서울시 강남구";
		sp.info();
	}
	

}
