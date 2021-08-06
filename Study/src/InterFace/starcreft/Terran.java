package InterFace.starcreft;

import java.util.Scanner;



public class Terran {
	
	public void unitInfo(Production pro) {
//		System.out.print("유닛 : " + pro.getName() + "\n");
//		System.out.print("미네랄 : " + pro.getMineral() + "\n");
//		System.out.print("가스   : " + pro.getGas() + "\n");
//		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Mineral  : ");
		int addMarine = scan.nextInt();
		System.out.print("Gas : ");
		int addGas = scan.nextInt();
		
		int myMoney = addMarine;
		int gasMoney = addGas;
		
		
		
		System.out.print("보유중인 미네랄 : " + myMoney + "\n" + "보유중인 가스 : "+ gasMoney + "\n");
		
		Terran terran = new Terran();
		
		Marine  mr = new Marine();
		Medics  md = new Medics();
		Firebat fb = new Firebat();
		Ghost   gt = new Ghost();
		
		
		System.out.print("============================================================\n");
		System.out.print("(1) " + mr.getName() + " " + mr.getMineral() + " " + "\n");
		System.out.print("(2) " + md.getName() + " " + md.getMineral() + " " + md.getGas()+"\n");
		System.out.print("(3) " + fb.getName() + " " + fb.getMineral() + " " + fb.getGas()+"\n");
		System.out.print("(4) " + gt.getName() + " " + gt.getMineral() + " " + gt.getGas()+"\n");
		System.out.print("(5) " +"Exit"+"\n");
		System.out.print("============================================================\n");
		
		while (true) {
			System.out.print("Select Menu [(1) ~ (5)]" +"\n");
			int select = scan.nextInt();
			
			if (select == 1) {
				if (myMoney < mr.getMineral()) {
					System.out.print("I'm sorry , You don't have any money \n");
					break;
					
				}else {
					System.out.print(mr.getName() + "  success ! \n");
					myMoney -= mr.getMineral();
					System.out.print(myMoney + "  " + gasMoney + "\n");
				}
				
				
			}else if (select == 2) {
				
				if (myMoney < md.getMineral() || gasMoney < md.getGas() ) {
					System.out.print("I'm sorry , You don't have any money \n");
					break;
				}else {
					System.out.print(md.getName() + "  success ! \n");
					myMoney -= md.getMineral();
					gasMoney -= md.getGas();
					System.out.print(myMoney + "  " + gasMoney + "\n");
				}
	
			}else if(select == 5) {
				System.out.print("Bye bye ~ ");
				break;
			}
		} // end while
		System.out.print(myMoney + "  " + gasMoney);
		
	}
}