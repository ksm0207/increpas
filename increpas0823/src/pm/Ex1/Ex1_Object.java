package pm.Ex1;

import java.io.Serializable;

import am.Ex2_Data;

public class Ex1_Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ex2_Data data;
	
	String value;
	
	private transient String password;
	
	public Ex1_Object(Ex2_Data data , String value) {
		this.data = data;
		this.value = value;
	}
	
	public Ex2_Data getData() {
		return data;
	}
	
	public String getValue() {
		return value;
	}
}
