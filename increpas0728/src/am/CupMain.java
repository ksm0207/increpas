package am;

public class CupMain {
	
	public static void main(String[] args) {
		
		Cup cup1 = new Cup();
		
		cup1.setCupTypes("머그컵");
		cup1.setColor("그린");
		cup1.setCupCapacity(250);
		cup1.setCupMaterial("유리");
		System.out.println("========================");
		System.out.println("타입 : "+cup1.getCupTypes());
		System.out.println("색상 : "+cup1.getColor());
		System.out.println("용량 : "+cup1.getCupCapacity() +"ml");
		System.out.println("재질 : "+cup1.getCupMaterial());
		System.out.println("========================");
		Cup cup2 = new Cup();
		
		cup2.setCupTypes("맥주잔");
		cup2.setColor("투명색");
		cup2.setCupCapacity(500);
		cup2.setCupMaterial("유리");
		
		System.out.println("타입 : "+cup2.getCupTypes());
		System.out.println("색상 : "+cup2.getColor());
		System.out.println("용량 : "+cup2.getCupCapacity() + "cc");
		System.out.println("재질 : "+cup2.getCupMaterial());
		System.out.println("========================");
		
		Cup cup3 = new Cup();
		
		cup3.setCupTypes("텀블러");
		cup3.setColor("블랙");
		cup3.setCupCapacity(345);
		cup3.setCupMaterial("스테인리스 스틸");
		
		System.out.println("타입 : "+cup3.getCupTypes());
		System.out.println("색상 : "+cup3.getColor());
		System.out.println("용량 : "+cup3.getCupCapacity() + "ml");
		System.out.println("재질 : "+cup3.getCupMaterial());
		System.out.println("========================");
		
		
	}

}
