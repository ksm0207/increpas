package am.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;

import java.util.List;

public class Ex1_Main {
	
	public static void main(String[] args) {
		
		try {
			
			Reader read = Resources.getResourceAsReader("am/config/config.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
			
			read.close();
			
			SqlSession session = factory.openSession();
			
			List<EmpVO> list = session.selectList("emp.all");
			
			for(EmpVO evo : list) {
				System.out.println(evo.getEmpno());
				System.out.println(evo.getFirst_name());
				System.out.println(evo.getJob_id());
				System.out.println(evo.getSalary());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
