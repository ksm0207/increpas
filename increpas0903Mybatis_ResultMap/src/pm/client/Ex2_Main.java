package pm.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.EmpDeptVO;
import pm.vo.EmpVO;

public class Ex2_Main {
	
	public static void main(String[] args) {
		
		try {
			
			String path = "pm/config/config.xml";
			
			
			Reader read = Resources.getResourceAsReader(path);
			System.out.println("Line 21");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
			System.out.println("Line 23");
			read.close();
			
			
			SqlSession session = factory.openSession();
			List<EmpVO> list = session.selectList("emp_dept.all");
			
			for(EmpVO vo : list) {
				System.out.println(
						vo.getEmployee_id() + " " +
					    vo.getLast_name() + " " + 
					    vo.getJob_id() + " "+
					    vo.getDvo().getDepartment_name()
				);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
