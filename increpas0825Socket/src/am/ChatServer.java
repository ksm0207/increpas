package am;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	ArrayList<CopyClient> list;
	ServerSocket ss;
	
	public ChatServer() {
		list = new ArrayList<CopyClient>();
		try {
			ss = new ServerSocket(3000);
			System.out.println("서버 시작!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//접속자 모두에게 메세지를 전달하는 기능
	public void sendMsg(String msg) {
		for(CopyClient cc : list) {
			cc.out.println(msg);
		}
		
		
	}
	
	//접속자가 해제할 당시 삭제하는 기능
	public void removeClient(CopyClient cc) {
		//접속을 해제하는 클라이언트가 종료메세지를 보내면
		// 그 메세지 받은 CopyClient에서 무한반복을 탈출하고
		// 현재 메서드를 호출하여 해당 CopyClient가 ArrayList에서
		// 완전히 삭제된다.
		list.remove(cc);
	}
	
	public void exe() {
		while(true) {
			try {
				Socket s = ss.accept();//접속자를 받아들인다.
				
				//접속자가 발생하면 받은 소켓을 가지고 CopyClient생성
				//그리고 CopyClient가 때로는 sendMsg함수와 removeClient라는
				//함수를 호출해야 하므로 현재객체의 주소를 보내야 한다.
				CopyClient cc = new CopyClient(s, this);
				System.out.println(cc.getClass());
				
				cc.start();// CopyClient가 스레드이므로 
							// 항상 readLine()을 수행하는 스레드를 구동시킨다.
				list.add(cc);
				
				sendMsg("※◇※◇ "+cc.ip+"님 입장 ◇※◇※");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//무한반복의 끝
	}
	
	public static void main(String[] args) {
		new ChatServer().exe();
	}

}
