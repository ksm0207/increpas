package am.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.DeptVO;
import am.vo.EmpVO;

public class Ex1_Main {
	public static void main(String[] args) {
		
		try {
			
			Reader read = Resources.getResourceAsReader("am/conf/config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
			read.close();
			
			SqlSession session = factory.openSession();
			List<DeptVO> dept_list = session.selectList("dept_emp.total");
			
			for(DeptVO dvo : dept_list) {
				
				System.out.println("부서코드 : " +dvo.getDepartment_id());
				System.out.println("부서이름 : " +dvo.getDepartment_name());
			
				/* ▼ 사원 정보 */
				List<EmpVO> emp_list = dvo.getEmp_list();
				
				/* 사원 출력 */
				for(EmpVO evo : emp_list) {
					
					System.out.println("사원번호 : " + evo.getEmployee_id());
					System.out.println("이름 : " + evo.getFirst_name());
					System.out.println("직종 : " + evo.getJob_id());
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
