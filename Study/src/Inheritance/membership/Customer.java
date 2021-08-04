package Inheritance.membership;

public class Customer {
   
   private String memberID;       // 멤버아이디
   private String name;           // 이름
   private String memberRating;   // 등급
   private int bonusPoint;        // 보너스포인트
   protected int paid;			  // 지급한 돈
   protected double bonusRate;    // 보너스포인트 비율
   
   
//   일반 고객의 경우 물품 구매시 1%의 보너스 포인트 적립
   public void isRatingCheck(String rating) {
      
      if (rating.equals("SILVER")) {
         
         System.out.println("회원등급 : 일반");
      }else {
         System.out.println("등급 확인을 할 수 없습니다.");
      }
   }
   
   public int getPoint(int itemsPrice) {
	   bonusRate = 0.01;
       bonusPoint += (itemsPrice * bonusRate);
      
       return bonusPoint;
   }
   
   public String getInfo() {
   
      return name + "님의 등급은 " + memberRating + " 이며 " + " 구매 가격은 " + paid
    		+ "원 입니다 "
            +" 보너스 포인트는 " + getPoint(bonusPoint) + "원 지급되었습니다. ";
   }
   
   
   
   public String getMemberID() {
      return memberID;
   }
   public void setMemberID(String memberID) {
      this.memberID = memberID;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getMemberRating() {
      return memberRating;
   }
   public void setMemberRating(String memberRating) {
      this.memberRating = memberRating;
   }
   
   public int getPaid() {
	return paid;
   }
   
   public void setPaid(int paid) {
	this.paid = paid;
}
    
   public int getBonusPoint() {
      return bonusPoint;
   }
   public void setBonusPoint(int bonusPoint) {
      this.bonusPoint = bonusPoint;
   }
   public double getBonusRate() {
      return bonusRate;
   }
   public void setBonusRate(double bonusRate) {
      this.bonusRate = bonusRate;
   }
   

}