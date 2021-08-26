package Socket.Chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Ch_Server {

	// 서버의 주 목적은 접속자를 받아들여서(accept) 
	// 받은 소켓을 가지고 AcceptClient객체를 생성한 후 스레드를 구동시켜서,
	// ArrayList에 저장!
	ArrayList<AcceptClient> list;
	ServerSocket ss;
	
	public Ch_Server() {
		list = new ArrayList<AcceptClient>();
		try {
			ss = new ServerSocket(3000);
			System.out.println("서버시작!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void exe() {
		while(true) {
			try {
				
				Socket s = ss.accept();// 접속자가 발생할 때까지 대기함!
				
				//접속자의 소켓정보(s)를 가지고 AcceptClient객체 생성
				AcceptClient ac = new AcceptClient(s, this);
				list.add(ac);
				ac.start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(Protocol p) {
		try {
			for(AcceptClient ac : list)
				ac.out.writeObject(p);
				
		}catch(Exception e) {}
	}
	
	//접속해제 시 list에서 삭제하는 기능
	public void removeClient(AcceptClient ac) {
		list.remove(ac);
	}
	
	public static void main(String[] args) {
		new Ch_Server().exe();

	}

}
