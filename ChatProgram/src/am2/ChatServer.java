package am2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	ServerSocket ss;
	
	//접속자(대기자)들의 정보를 저장할 곳
	ArrayList<CopyClient> c_list;
	
	//대화방들을 저장할 곳
	ArrayList<ChatRoom> r_list;
	
	public ChatServer() {
		c_list = new ArrayList<CopyClient>();
		r_list = new ArrayList<ChatRoom>();
		try {
			ss = new ServerSocket(3030);
			System.out.println("서버 시작!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exe() {
		while(true) {
			try {
				Socket s = ss.accept();// 접속자가 발생할 때까지 대기한다.
				
				CopyClient cc = new CopyClient(s, this);
				cc.start();
				c_list.add(cc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//대기실 명단을 반환하는 기능 - c_list
	public String[] getUserName() {
		String[] ar = new String[c_list.size()];
		int i=0;
		for(CopyClient cc : c_list) {
			ar[i] = cc.nickName;
			++i;
		}
		return ar;
	}
	
	//방목록을 반환하는 기능 - r_list
	public String[] getRoomName() {
		String[] ar = new String[r_list.size()];
		int i=0;
		for(ChatRoom cr : r_list) {
			ar[i] = cr.getTitle();
			++i;
		}
		return ar;
	}
	
	// 대기실 목록 갱신(방목록, 대기실 명단)
	public void refresh() {
		Protocol2 p = new Protocol2();
		p.setCmd(2);// 접속 및 갱신
		p.setNames(getUserName());//대기자들 명단 갱신
		p.setRooms(getRoomName());//방 목록 갱신
		
		//위의 Protocol을 대기실에 있는 접속자들에게만 전달!
		sendMsg(p);
	}
	
	//대기실에 있는 접속자들 모두에게 전달하는 기능
	public void sendMsg(Protocol2 p) {
		//대기실 접속자들은 c_list에 모두 저장된 상태다.
		for(CopyClient cc : c_list) {
			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//대기실에서 특정 방에 들어갈 때는 현재 대기실에서 삭제
	public void removeClient(CopyClient cc) {
		c_list.remove(cc);
		
		refresh();//목록 갱신
	}
	
	//특정 방에서 방 나가기로 인해 대기실에 오게되면 c_list에 저장
	public void addClient(CopyClient cc) {
		c_list.add(cc);
		
		refresh();//목록 갱신
	}
	
	//방객체를 인자로 받아서 r_list에 추가
	public void addRoom(ChatRoom room) {
		r_list.add(room);
	}
	
	//방객체를 인자로 받아서 r_list에서 삭제
	public void removeRoom(ChatRoom room) {
		r_list.remove(room);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new ChatServer().exe();
	}

}
