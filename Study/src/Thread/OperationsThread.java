package Thread;

public class OperationsThread {
	
	/* 아래조건을 만족하며 스레드를 구현해보기.*/
	
	/* 1. run메소드는 1초씩 대기를 한다. */
	/* 2. 1 ~ 10까지 3개의 스레드를 나눠서 더하기를 진행한다 */
	/* 1. 모든 스레드 작업이 완료되면 합을 출력한다. */

	/* 1번 스레드는 1 ~ 3까지 */
	/* 2번 스레드는 4 ~ 6까지 */
	/* 3번 스레드는 7 ~ 10까지 */
	
	
	public static void main(String[] args) {
		
		StartOperations thread1 = new StartOperations(1,1,3);
		StartOperations thread2 = new StartOperations(2,4,6);
		StartOperations thread3 = new StartOperations(3,7,10);
		
		thread1.start();
		thread2.start();
		thread3.start();
	
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("합 : ");
	}
}
class StartOperations extends Thread{
	
	int sum;
	
	int turn,start,end;
	
	public StartOperations(int turn, int start, int end ) {
		this.turn = turn;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		try {
			sleep(1000);
			for(int i=start; i<=end; i++) {
				sum = sum + i;
//				System.out.println("스레드 진행중 :" + turn + " i = " + i);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public int getOperations() {
			
		return sum;
	}

}
