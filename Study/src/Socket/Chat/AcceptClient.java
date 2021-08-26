package Socket.Chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AcceptClient extends Thread{

	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	String nickName;
	
	Ch_Server server;
	
	public AcceptClient(Socket s, Ch_Server server) {
		this.s = s;
		this.server = server;
		try {
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void run() {
		bk:while(true) {
			try {
				Object obj = in.readObject();
				if(obj != null) {
					Protocol p = (Protocol) obj;
					switch(p.getCmd()) {
						case 0: //접속해제
							//원격에 있는 원본 클라이언트에게만 종료 Protocol을
							//보낸다. 이유는 원본 클라이언트에서 무한반복하고 있는
							//스레드를 탈출시켜 종료시키기 위해!
							out.writeObject(p);
							break bk; // bk라는 이름표가 붙은 반복문 탈출!
						case 1: // 로그인
							nickName = p.getMsg();
							//입장했다는 메세지를 클라이언트 모두에게 전달!!!!
							//입장 메세지를 접속자 모두에게 전달!
							p.setMsg(nickName+" 님이 입장 하였습니다. ");
							p.setCmd(2);// 일반 메세지
							server.sendMsg(p);//접속자 모두에게 전달하는 기능 호출!!!
							break;
						case 2: // 일반 채팅 메세지
							//접속자 모두에게 메세지 전달
							p.setMsg(nickName+" : "+p.getMsg());
							server.sendMsg(p);
							break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			
			if(out != null)out.close();
			if(in != null)in.close();
			if(s != null)s.close();
			
			//서버에 있는 접속들이 모여있는 ArrayList에서 현재 객체 삭제
			
			//아직 남아 있는 접속자들에게 퇴장메세지 전달
			
			Protocol p = new Protocol();
			
			if(s.isConnected()) {
				server.removeClient(this);
				p.setCmd(2);
				p.setMsg(nickName+ "님이 퇴장하였습니다.");
				server.sendMsg(p);	
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// end of run method
}
