package am.client;

import java.io.BufferedReader;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2_if {

	public static void main(String[] args) throws Exception{
		
		Reader reader = Resources.getResourceAsReader("am/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		reader.close();
		
		SqlSession session = factory.openSession();
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("job_id", "IT_PROG");
//		map.put("deptno","30");
//		▲ 두개 중 하나만 넣기로 한 SQL 문장을 참고하자
//		둘 다 데이터를 넣으면 문법오류가 일어남.
		
		List<EmpVO> list = session.selectList("emp.search", map);
		
		for(EmpVO evo : list) {
			System.out.println(evo.getEmployee_id() + " " + evo.getLast_name() + " "
					+ evo.getHire_date() + " " + evo.getJob_id() + " " + evo.getDepartment_id());
		}
		session.close();
		
		
	}
}
