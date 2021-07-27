package personal_project2;

public class ReturnMoney {
	
	public int returnChangeMoney() {
		VendingMachine vm = new VendingMachine();
			
		int [] money = {10000,5000,1000,500,100,50,10};
		int remainMoney;
		
		if (vm.userMoney == 0) {
			System.out.println("반환하실 금액이 없습니다.");
		}else {
			for (int i=0 ; i <money.length; i ++) {
				
				if (vm.userMoney / money[i] > 0) {
					System.out.println(money[i] + "원 " + vm.userMoney/money[i] + "개");
					vm.userMoney %=money[i];
				}
			}// end of for
			remainMoney = vm.userMoney - vm.userMoney;
			System.out.println("자판기에 남은 돈 : " + remainMoney);
		}
		return vm.userMoney;
	}// end of returnChangeMoney
}
