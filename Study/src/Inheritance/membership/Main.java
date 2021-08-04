package Inheritance.membership;

public class Main {
   
   public static void main(String[] args) {
      
      Customer member = new Customer();
      
      member.setMemberID("Hong0207");
      member.setName("홍길동");
      member.setPaid(15500);
      member.getPoint(15500);
      member.isRatingCheck("SILVER");
      member.setMemberRating("SILVER");
      System.out.println(member.getInfo());
      
      System.out.println("=====================");
      
      VipCustomer vipMember = new VipCustomer();
      vipMember.setMemberID("Kim0207");
      vipMember.setName("Kim");
      vipMember.setPaid(10000);
      vipMember.getPoint(10000);
      vipMember.sales(10000);
      vipMember.isRatingCheck("Gold");
      vipMember.setMemberRating("Gold");
      System.out.println(vipMember.getInfo());
    
   }
}