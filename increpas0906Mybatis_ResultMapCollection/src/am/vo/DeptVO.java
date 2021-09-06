package am.vo;

import java.util.List;

public class DeptVO {
	
	private String department_id;
	private String department_name;
	
	/* 현 부서에 속하는 사원들의 정보 */
	/* 사원들의 정보가 여러명 일 수 있어서 
	 * 모든 정보를 한번에 List로 담음 */
	
	private List<EmpVO> emp_list;

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

	public List<EmpVO> getEmp_list() {
		return emp_list;
	}

	public void setEmp_list(List<EmpVO> emp_list) {
		this.emp_list = emp_list;
	}
	
	
	
}
