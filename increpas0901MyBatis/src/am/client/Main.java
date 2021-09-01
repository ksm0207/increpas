package am.client;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import am.vo.EmpVO;

public class Main {
	/* Mybatis : if문 활용 */
	public static void main(String[] args) throws Exception{
		
		Reader reader = Resources.getResourceAsReader("am/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		reader.close();
		
		SqlSession sql_session = factory.openSession();
		
//		List<EmpVO> list = sql_session.selectList("emp.searchDept",110);
		
		/*
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("department_id3",80);
		map.put("salary",12000);
		List<EmpVO> list = sql_session.selectList("emp.searchDept3",map);
		*/
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("aa",80);
//		map.put("sa",12000); salary 값이 들어갈 수도 있고 없을 수도 있는
//							 동적인 상황일때는 sql문장에서 if문으로 확인 후
//							 구동 되도록 할 수 있음. (emp.xml 참고)
		
		List<EmpVO> list = sql_session.selectList("emp.searchDept4",map);
		
		for (EmpVO evo : list) {
			System.out.println(evo.getEmployee_id() + " " + evo.getLast_name() + " "
					+ evo.getHire_date() + " " + evo.getJob_id() + " " + evo.getDepartment_id());
		}
		sql_session.close();
		
		
	}

}
