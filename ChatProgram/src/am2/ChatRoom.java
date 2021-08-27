package am2;

import java.util.ArrayList;

public class ChatRoom {

	//방 참여자들이 저장되는 곳 - 방나가기 또는 접속해제시 여기서 삭제되어야 함!
	ArrayList<CopyClient> j_list;
	
	String title;//방 제목
	
	public ChatRoom(String title) {
		this.title = title;
		j_list = new ArrayList<CopyClient>();
	}
	
	// 방 참여자 명단을 반환하는 기능(누군가가 방을 나가면 명단 갱신이 필요하다)
	public String[] getJoinUsers() {
		//방 참여자들은 모두 j_list에 있다.
		String[] ar = new String[j_list.size()];
		
		//j_list에 있는 CopyClient들이 가지는 nickName을 수집한다.
		int i = 0;
		for(CopyClient cc : j_list) {
			ar[i] = cc.nickName;
			i++;
		}
		return ar;
	}
	
	// 채팅 기능
	public void sendProtocol(Protocol2 p) {
		// 현재 방에 참여한 모든 사람들에게 전달
		for(CopyClient cc : j_list) {
			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 방 참여기능
	public void join(CopyClient cc) {
		j_list.add(cc);
		
		//방 참여 프로토콜 생성하여 방에 있는
		// 참여자들에게 전달!(입장 메세지)
		Protocol2 p = new Protocol2();
		p.setCmd(4);
		p.setMsg("※◇※◇ "+cc.nickName+"님 입장 ◇※◇※");
		
		//String[] ar = getJoinUsers();//참여자 명단 수집
		//p.setNames(ar);
		p.setNames(getJoinUsers());
		
		//현재 방에 참여하고 있는 사람들에게만 전달
		sendProtocol(p);
	}
	
	// 방 나가기 기능
	public void goOut(CopyClient cc) {
		j_list.remove(cc);//참여자에서 삭제!!
		
		//"★☆★☆"+cc.nickName+"님 퇴장☆★☆★"
		Protocol2 p = new Protocol2();
		p.setCmd(4);
		p.setMsg("★☆★☆"+cc.nickName+"님 퇴장☆★☆★");
		
		p.setNames(getJoinUsers());//참여자 명단 수집
		
		//현재 방에 참여하고 있는 모든 사람들에게 전달
		sendProtocol(p);
	}
	
	// 방 제목을 반환하는 기능 - 대기실에 표현할 방제목
	public String getTitle() {
		return title;
	}
	
	// 현재 방에 참여자들의 수를 반환하는 기능
	// (방 나갈 때 마지막 사람일 경우 방을 삭제해야 함)
	public int getJoinCount() {
		return j_list.size();
	}
}







