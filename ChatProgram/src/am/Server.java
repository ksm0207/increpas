package am;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	/* 클라이언트 객체를 저장 */
	ArrayList<ClientData> data_list;
	
	/* 대화방 관리 */
	ArrayList<ChatRoom> room_list;
	
	ServerSocket server;
	
	ObjectOutputStream object_out;
	ObjectInputStream object_in;
	
	public Server() {
		data_list = new ArrayList<ClientData>();
		room_list = new ArrayList<ChatRoom>();
		
		try {
			server = new ServerSocket(3000);
			System.out.println("Server Oan");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void clientAccept() {
		while(true) {
			try {
				Socket socket = server.accept();
				ClientData data = new ClientData(socket , this);
				data.start();
				data_list.add(data);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	 
	// 대기실 명단을 반환하는 기능
	public String[] getRoomUserList() {
		
		String [] array = new String[data_list.size()];
		
		int i=0;
		for(ClientData data : data_list) {
//			array[i] = data_list.get(i).name;
			array[i] = data.name;
			i++;
		}
		return array;
		
	}
	
	// 방목록(제목)을 반환하는 기능
	public String[] getRoomList() {		
		String [] array = new String[room_list.size()];

		int i=0;
		for(ChatRoom rooms : room_list) {
			array[i] = rooms.getTitle();
			i++;
		}
		return array;
	}
	
	// 대기실 목록을 갱신하기 ( 목록 : 방 목록 , 대기실 명단 )
	public void roomRefresh() {
		
		/* 목록갱신 전용 프로토콜 만들어보기 . */
		
		Protocol protocol = new Protocol();
		protocol.setStatus(2);
		
		protocol.setUsers(getRoomUserList()); /* 방 목록 갱신 */
		protocol.setRooms(getRoomList()); /* 대기자들 명단 갱신 */
		
		/* 마무리 sendMessage 호출 */
		sendMessage(protocol);
		
	} 
	
	
	/* 위 Protocol을 대기실에 있는 클라이언트에게 전달하기 */
	public void sendMessage(Protocol protocol) {
		try {
			
			for(ClientData data : data_list) {
				data.object_out.writeObject(protocol);
				data.object_out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* A클라이언트가 대기실에 대기 하고 있고
	 * B방 클라이언트 방에 들어갔을 때 A의 현재 위치를 삭제하기 */
	public void removeClient(ClientData data) {
		data_list.remove(data);
		roomRefresh(); /* 갱신 */
	}
	
	/* 특정 방에서 방 나가기로 인해 대기실에 오게되면
	 * 다시 대기자명단에 저장 */
	public void addClient(ClientData data) {
		data_list.add(data);
		roomRefresh();
	}
	
	/* 방 객체를 인자로 받아 room_list에서 추가하기.*/
	public void addRoom(ChatRoom room) {
		room_list.add(room);
	}
	
	public void removeRoom(ChatRoom room) {
		room_list.remove(room);
	}
	
	public static void main(String[] args) {
		
		new Server().clientAccept();
	}

}
