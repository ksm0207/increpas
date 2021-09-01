package pm.client;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.EmpVO;

public class Ex3_forInsert {
	
	public static void main(String[] args) throws Exception {
		
		EmpVO evo = new EmpVO();
		
		evo.setEmployee_id("11");
		evo.setLast_name("Kim");
		evo.setEmail("ksm03071@gmail.com");
		evo.setHire_date("2021-09-01");
		evo.setJob_id("IT_PROG");
		evo.setDepartment_id("30");
	
		EmpVO[] ar = new EmpVO[1];
		ar[0] = evo;
		
		
		Map<String, EmpVO[]> map = new LinkedHashMap<String, EmpVO[]>();
		
		map.put("list",ar);
		
		Reader read = Resources.getResourceAsReader("pm/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
		
		read.close();
		
		SqlSession session = factory.openSession(true);
//		
		int status = session.insert("emp2.add_list",map);
//		
		if(status > 0) {
		System.out.println("데이터 추가 완료 ");
	    }else {
		System.out.println("추가 실패");
	    }
		session.close();
		
//		List<EmpVO> list = session.selectList("emp2.add_list",map);
		

		

		
	}
	
	private void insertTest(Map<String,String> list) {
		
	}
	
	

}
