package pm.vo;

public class DeptVO {
	
	/* 현재 부서가 어떤 도시에 있는지 알아내기 위해 객체화 시키기*/
	private LocVO lvo;
	
	public LocVO getLvo() {
		return lvo;
	}
	public void setLvo(LocVO lvo) {
		this.lvo = lvo;
	}
	
	
	
	private String department_id;
	private String department_name;
	
	
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
}
