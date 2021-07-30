package example0730;

import java.util.ArrayList;

public class EmployeeVO {
	
	private String number;
	private String name;
	private String department_name;
	private String hire_date;
	private String birthday;
	
	
	public EmployeeVO(String number , String name , String department_name , String hire_date
			, String birthday){
		this.number = number;
		this.name = name;
		this.department_name = department_name;
		this.hire_date = hire_date;
		this.birthday = birthday;
	}
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사원 : " + number + " | "+ " 이름 : " + name + " | " + " 부서 : " + department_name + " | "+ " 입사날짜 : " +  " | " + hire_date +
				" | "+ " 생일 : "+ birthday;
	}
}
