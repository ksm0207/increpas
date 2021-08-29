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
						object_out.writeObject(protocol);
						break exit;
					case 1:
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
						present_room.getTitle();
						server.removeClient(this);
						server.roomRefresh();
						break;
					case 5:
						System.out.println("Client Data Case 5 On");
						present_room.join(this);
						server.sendMessage(protocol);
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
}
