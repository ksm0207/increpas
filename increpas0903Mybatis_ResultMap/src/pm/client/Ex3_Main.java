package pm.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.DeptVO;

public class Ex3_Main {
	
	public static void main(String[] args) {
		
		try {
		
			Reader read = Resources.getResourceAsReader("pm/config/config.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
			
			read.close();
			
			SqlSession session = factory.openSession();
			
			List<DeptVO> list = session.selectList("dept.total");
			
			for(DeptVO dvo : list) {
				
				System.out.println(dvo.getDepartment_id());
				System.out.println(dvo.getDepartment_name());
				System.out.println(dvo.getLvo().getCity());
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
