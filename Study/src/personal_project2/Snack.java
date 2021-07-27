package personal_project2;

public class Snack {
	
	public void getSnack() {
		VendingMachine vm = new VendingMachine();
		CheckMoney cm = new CheckMoney();
		
		System.out.println("Snack 메뉴");
		String[][] snackMenu = {
				{"▦ 꼬북칩 오리지날" , "2000"},
				{"▦ 꼬북칩 초코" , "2500"},
				{"▦ 새우깡" , "2000"},
				{"▦ 오징어칩" ,"2000"}
			};
		
		for(int i=0 ; i <snackMenu.length; i ++) {
			System.out.println((i+1)+"."+snackMenu[i][0] + "  -----------" + snackMenu[i][1] + "원");
		}
		
		System.out.println("무엇을 주문 해 볼까요?");
		System.out.print("주문번호 : ");
		int userChoies = vm.scan.nextInt() - 1; // Index - 입력값
	
		// 사용자 가 가지고 있는 금액이 0원 일때 체크
		if (vm.userMoney == 0) {
			System.out.println("금액을 충전하고 이용하시겠습니까?");
			System.out.println("선택한 메뉴 :"  +snackMenu[userChoies][0] + "\n"
							 + "필요한 금액 :" +snackMenu[userChoies][1]+"원");
			
			System.out.print("Y 를누르면 계속 진행합니다.");
			
			// y 를 누르면 금액을 충전할 수 있도록 입력값 받기
			if (vm.scan.next().equals("y")) {
				System.out.println("감사합니다 금액을 입력해주세요.");
				vm.userMoney += vm.scan.nextInt();
				// moneyCheck() : 사용자 금액 체크 / 선택메뉴 + 금액 계산하는 메소드
				vm.userMoney = cm.checkItems(vm.userMoney,userChoies,snackMenu);
			}else {
				// y 가 아닌 경우
				System.out.println("감사합니다.");
			}		
		}else {
			 
			// 소지금액이 선택한 메뉴의 금액보다 많을 경우 추가 구매 하기
			 if (vm.userMoney >= Integer.parseInt(snackMenu[userChoies][1])) {
				 vm.userMoney = cm.checkItems(vm.userMoney,userChoies,snackMenu);
			 }
			// 소지금액이 선택한 메뉴의 금액보다 적을 경우 충전하기
			 else if (vm.userMoney <= Integer.parseInt(snackMenu[userChoies][1])) {
				 vm.userMoney = cm.checkItems(vm.userMoney,userChoies,snackMenu);
			 }	
		}
		System.out.println("현재 가지고 있는 금액은 " + vm.userMoney +" 원 입니다");
	}

}
