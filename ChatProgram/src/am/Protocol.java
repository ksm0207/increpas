package am;

import java.io.Serializable;

public class Protocol implements Serializable {
	
	/* Status 
	 * 0 : 종료
	 * 1 : 메세지
	 * 2 : 접속 및 갱신
	 * 3 : 방만들기
	 * 4 : 방 참여
	 * 5 : 방 나가기
	 * */
	
	private static final long serialVersionUID = 1L;
	final static int HOST = 1;
	
	int status;
	String userMessage;
	
	String[] users; /* 접속자 명단 목록 */
	String[] rooms; /* 방 목록 */
	int userCount; /* 방 목록에 있는 유저 수*/
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public String[] getRooms() {
		return rooms;
	}
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
}


