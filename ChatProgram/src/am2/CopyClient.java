package am2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread {
	
	String nickName;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	ChatServer server;
	
	//현재 클라이언트가 참여하고 있는 방의 정보
	ChatRoom c_room;// null이면 그 어떤 방에도 참여하고 있지 않은 상태
					// (대기실에 있는 경우)
	
	public CopyClient(Socket s, ChatServer server) {
		// 인자들은 지역변수이므로 삭제되기 전에
		// 멤버변수에 저장해야 다른 메서드에서 사용이 가능하다.
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
		// ChatServer의 exe함수에서 접속자가 생겼을 때
		//현재 객체(CopyClient)가 생성되어 ArrayList에 저장된다.
		//그리고 접속자 각자가 별도로 통신을 위한 스레드를 구동시킨다.
		// 그 부분이 바로 현재 영역이다.
		bk:while(true) {
			try {
				Object obj = in.readObject();
				
				//우린 무조건 Protocol객체를 보내고 받기로 했다.
				Protocol2 p = (Protocol2) obj;
				
				//동작에 대한 구별은 cmd값으로 한다.
				switch(p.getCmd()) {
					case 0: //종료
						out.writeObject(p);//직접 연결된 클라이언트의
						// readObject에 걸려있는 스레드를 탈출시킨다.
						break bk;
					case 2: //접속 및 갱신
						nickName = p.getMsg();//대화명 저장
						
						//현재 대기실의 명단을 수집한다.
						p.setNames(server.getUserName());
						
						//이미 만들어져 있는 방들이 있을 수 있으니
						//방 제목들을 수집한다.
						p.setRooms(server.getRoomName());
						
						// 대기실의 접속자들 모두에게 전달
						server.sendMsg(p);
						break;
					case 3:
						//방 객체 생성
						c_room = new ChatRoom(p.getMsg());
						
						c_room.join(this);//방에 현재객체 참여
						
						server.removeClient(this);
						
						server.addRoom(c_room);//서버에 생성된 방 객체 추가 
						
						server.refresh();//대기실 갱신
						break;
				}//switch의 끝
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//무한반복의 끝
		
		//현재객체를 서버의 c_list에서 삭제
		server.removeClient(this);
		
		//현재객체가 접속을 해제했다는 메세지를 또는 명단을 갱신하도록
		//Protocol을 만들어 남아있는 접속자들에게 모두 보내야 한다.
		
		try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}






