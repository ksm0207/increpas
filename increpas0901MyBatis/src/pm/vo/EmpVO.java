package pm.vo;

public class EmpVO {
	// EmpVO : employee 테이블로부터 가져오고 싶은 컬럼명들을
	//         동일한 이름으로 멤버변수로 선언한다.
	//         동일한 이름으로 선언하지 않으면 테이블과 매칭이 되지 않는다
	
	private String employee_id;
	private String last_name;
	private String hire_date;
	private String email;
	private String job_id;
	private String department_id;
	
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	
	
}
