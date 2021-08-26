package Socket.Chat;

import java.io.Serializable;

public class Protocol implements Serializable{
	//통신규약(규칙)
	//   cmd라는 변수에 0 : 종료(접속해제)
	//	 cmd라는 변수에 1 : 이름 받기
	//	 cmd라는 변수에 2 : 메세지
	int cmd;
	String msg;
	
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
}
