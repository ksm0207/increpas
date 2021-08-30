package employee;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Main {

	public static void main(String[] args) throws Exception {
		 
		
		// 1. 환경설정 파일 읽어오기 ( Oracle + mybytis 작업 )
		//    config.xml		
		Reader read = Resources.getResourceAsReader("employee/config.xml");
		
		SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = sqlBuilder.build(read);
		read.close();
		
		SqlSession session = factory.openSession();
		
		List<EmployeeVO> list = session.selectList("emp.all");
		
		for(EmployeeVO vo : list) {
			
			System.out.println(vo.getEmployee_id() + " / " +
					vo.getFirst_name() + " " + vo.getJob_id() + " " + vo.getSalary());
			
			if (session != null) {
				session.close();
			}
		}
	}
}
