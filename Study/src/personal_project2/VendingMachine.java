package personal_project2;

import java.util.Scanner;

public class VendingMachine {
	
	static int userMoney;
	Scanner scan = new Scanner(System.in);
	Coffee coffee = new Coffee();
	Drink drink = new Drink();
	Snack snack = new Snack();
	ReturnMoney rm = new ReturnMoney();
	
	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		while(true) {
			vm.start();
		}

	}
	public void start() {
		while(true) {
			System.out.println("1. 커피" + " 2.음료수" + " 3.과자" + " 4.반환" + " 5.나가기");
			int selectCode = scan.nextInt();

			switch (selectCode) {
			case 1: 
				coffee.getCoffee();
				break;
			case 2:
				drink.getDrink();
				break;
			case 3:
				snack.getSnack();
				break;
			case 4:
				rm.returnChangeMoney();
				break;
			case 5:
				System.out.println("감사합니다 또 이용해주세요 !");
				System.exit(selectCode);
				break;
			default:System.out.println("null");
				break;
			}
		}
	}
}
