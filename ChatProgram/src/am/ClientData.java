package am;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientData extends Thread {
	
	String name;
	
	Socket socket;
	ObjectOutputStream object_out;
	ObjectInputStream object_in;
	
	Server server;
	
	ChatRoom present_room;
	
	
	public ClientData(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
		
		try {
			
			object_out = new ObjectOutputStream(socket.getOutputStream());
			object_in = new ObjectInputStream(socket.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of ClientData Con
	
	@Override
	public void run() {
		exit:while(true) {
			try {
				Object obj = object_in.readObject();
				if(obj != null) {
					Protocol protocol = (Protocol)obj;
					
					switch (protocol.getStatus()) {
					
					case 0:
						// != null 은 현재 창에서 X 버튼을 눌렀을때
						// 현재 방에 참여하고 있는 상태인지 확인하기.
						if(present_room != null) {
							outRoom();
						}
						
						object_out.writeObject(protocol);
						break exit;
					case 1:
						System.out.println("ClientData Case 1 On");
						protocol.setUserMessage(name + " : " + protocol.getUserMessage());
						present_room.setProtocol(protocol);
						break;
					case 2:
						System.out.println("ClientData Case 2 O5n");
						name = protocol.getUserMessage();
						protocol.setUsers(server.getRoomUserList());
						protocol.setRooms(server.getRoomList());
						server.roomRefresh();
						server.sendMessage(protocol);
						break;
					case 3:
						
						System.out.println("ClientData Case 3 On");
						
						present_room = new ChatRoom(protocol.getUserMessage());
						
						present_room.join(this); // 현 객체 방에 참여
						
						server.removeClient(this); 
						
						server.addRoom(present_room); // 서버에 생성된 방 객체 추가
						
						server.roomRefresh();// 대기실 갱신
		
						break;
					
					case 4:
						
						// 프로토콜에 있는 room_index 값을 가지고
						// 서버에 있는 room_list 값을 가지고 방객체를 가져오기
						present_room = server.getRoom(protocol.getRoom_index());
						
						// 참여
						present_room.join(this);
						
						// 남아있는 대기실에서 현재 객체 삭제 
						server.removeClient(this);
						break;
						
					case 5:
						outRoom();
						server.addClient(this);
						
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// end of while
	
	/* 현재 객체를 서버의 c_list에서 삭제하기 */
	
	
	try {
		if(object_in != null)object_in.close();
		if(object_out != null)object_out.close();
		if(socket != null)socket.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}

	// 현재 방의 접속자 수가 없다면 방 삭제하기.
	private void outRoom() {
		present_room.exitRoom(this);
		
		int cnt = present_room.getJoinCount(); // getJoinCount() : 참여 인원수
		if (cnt == 0) {
			server.removeRoom(present_room);
		}
		present_room = null;
	}
}
