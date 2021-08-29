package am;

import java.util.ArrayList;


/* 참여자들의 방을 관리하는 클래스 */
public class ChatRoom {
	
	/* 나가기 , 접속해제시 데이터를 삭제하는 ArrayList */
	ArrayList<ClientData> client_list;
	
	String title; /* Protocol rooms 에 전달하여 방 제목 띄우기*/
	
	public ChatRoom(String title) {
		this.title = title;
		client_list = new ArrayList<ClientData>();
	}
	
	/* 구현해야 할 기능 
	 * 1. 방 참여기능
	 * 2. 방 나가기 기능
	 * 3. 방 제목을 반환하는 기능
	 * 4. 참여자 명단을 반환하는 기능(A클라이언트가 방을 나가면 현재 방의 명단 갱신필요)
	 * 5. 채팅 기능
	 * 6. 현재 방에 참여자들의 수를 반환하는 기능
     * (방 나갈때 마지막에 남은 사람이 나가기를 했을때 방이 삭제되야함)
	 * */
	
	/* 구현 순서는 번호로 명시하기.*/
	
//   6. 현재 방에 참여자들의 수를 반환하는 기능
//	(방 나갈때 마지막에 남은 사람이 나가기를 했을때 방이 삭제되야함)
	
	public int getJoinCount() {
		return client_list.size();
	}
	
	// 5. 방 제목을 반환하는 기능
	public String getTitle() {
		/* 대기실에 표현할 방 제목 */
		return title;
	}
	
    // 4. 방 나가기 기능
	public void exitRoom(ClientData data) {
		client_list.remove(data);
		Protocol protocol = new Protocol();		
		protocol.setStatus(4);
		protocol.setUserMessage(data.name + " 님이 현재 방에서 퇴장하였습니다.");
		protocol.setUsers(getJoinUsers()); /* 참여자 명단  */
		setProtocol(protocol); /* 남은 참여자에게 데이터 전달 */
	}
	
	// 3. 채팅 기능
	public void setProtocol(Protocol protocol) {
		/* 현재 방에 참여한 모든 사람들을 서버에 전달하기 */
		for(ClientData data : client_list) {
			try {
				data.object_out.writeObject(protocol);
				data.object_out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    // 2. 참여자 명단을 반환하는 기능(A클라이언트가 방을 나가면 현재 방의 명단 갱신필요)
	public String[] getJoinUsers() {
		String[] array = new String[client_list.size()];
		
		int i=0;
		for(ClientData data : client_list) {
			array[i] = client_list.get(i).name;
			i++;
		}
		return array;
		
//		for(int i=0; i<array.length; i++) {
//			array[i] = client_list.get(i).name;
//		}
		
	}
	// 1. 방 참여기능
	public void join(ClientData data) {
		
		client_list.add(data);
		
		Protocol protocol = new Protocol();
		protocol.setStatus(4);
		protocol.setUserMessage(data.name + " 님이 입장 하였습니다.");
		
		/* 참여자 명단 호출 */
		protocol.setUsers(getJoinUsers());
		
		/* 현재 방에 참여하고 있는 사람에게 전달하기 */
		setProtocol(protocol);
	}

}
