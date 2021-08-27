package am2;

import java.io.Serializable;

public class Protocol2 implements Serializable{
	int cmd;
	// cmd변수 의미
	//		0 : 종료
	//		1 : 메세지
	//		2 : 접속 및 갱신
	//		3 : 방만들기
	//		4 : 방 참여
	//		5 : 방 나가기
	
	String msg; // 메세지를 저장할 변수
	
	String[] names; //접속자 명단!
	String[] rooms; //방 목록
	int u_count;
	
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String[] getRooms() {
		return rooms;
	}
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}
	public int getU_count() {
		return u_count;
	}
	public void setU_count(int u_count) {
		this.u_count = u_count;
	}
	
}
