package Inheritance.membership;

public class VipCustomer extends Customer {
	
	int bonusPoint;
	double salesRatio;
	
   @Override
   public void isRatingCheck(String rating) {
      if (rating.equals("Gold")) {
         System.out.println("회원등급 : 프리미엄");
         System.out.println("10% 할인율 혜택을 받을 수 있습니다.");
      }else {
         System.out.println("등급 확인을 할 수 없습니다.");
      }
   }
   
   public int sales(int sales) {
	   salesRatio = 0.1;
	   paid -= (sales * salesRatio);
	   return paid;
   }
   
   @Override
   public int getPoint(int itemsPrice) {
      bonusRate = 0.05;
//      System.out.println( "Items Price == > "+itemsPrice); // 0
      bonusPoint += ( (paid -itemsPrice) * (bonusRate));
      return bonusPoint;
   }
 
   

}