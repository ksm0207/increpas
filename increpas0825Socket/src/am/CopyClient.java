package am;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 접속자가 발생할 때마다 접속자를 의미하는 객체
public class CopyClient extends Thread {

	Socket s;
	BufferedReader in;
	PrintWriter out;
	String ip;
	
	ChatServer server;// 스레드에서 서버에 접속한 모든 접속자들에게 메세지 전달 및
	// 접속을 해제할 때 서버에서 현재 객체를 삭제할 때 호출할 서버의 주소
	
	public CopyClient(Socket s, ChatServer server) {
		this.s = s;
		this.server = server;//*****************중요
		try {
			out = new PrintWriter(s.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 현 스레드가 해야할 일은 언제 어느 때에 실제 클라이언트로부터
		// 서버에게 메세지를 보낼지 모른다. 그래서 항상
		// readLine()을 수행하여 테이터가 넘어 올때를 기다려야 한다.
		while(true) {
			try {
				String msg = in.readLine(); // 메제시가 올 때까지 대기한다.
				
				//받은 메세지 종료메세지("Xx:X~")일 때 무한반복문 탈출
				if(msg.equals("Xx:X~")){
					out.println("Xx:X~");//원격에 있는 실제 클라이언트에게만
					// 종료메세지를 보내어 무한반복을 수행하는 스레드가 탈출할 수
					//있도록 메세지를 보낸다.
					break;//무한반복 탈출!
				}
				
				//받은 메세지를 다른 모든 접속자들에게 보낸다.
				server.sendMsg(ip+":"+msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 무한반복의 끝
		
		try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
			
			server.removeClient(this);//서버의 ArrayList에서 현재 객체 삭제
			
			// 다른 접속자들에게 퇴장메세지 전달
			server.sendMsg("★☆★☆"+ip+"님 퇴장☆★☆★");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}








