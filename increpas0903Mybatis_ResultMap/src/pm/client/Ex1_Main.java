package pm.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.EmpDeptVO;

public class Ex1_Main {
	
	public static void main(String[] args) {
		
		try {
			
			Reader read = Resources.getResourceAsReader("pm/config/config.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
			
			read.close();
			
			SqlSession session = factory.openSession();
			
			List<EmpDeptVO> list = session.selectList("emp_dept.empDept");
			
			for(EmpDeptVO edv : list) {
				System.out.println(edv.getEmployee_id() + " " + edv.getLast_name() + " " + edv.getJob_id()
				+ " " + edv.getDepartment_id() + " " + edv.getDepartment_name());
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
