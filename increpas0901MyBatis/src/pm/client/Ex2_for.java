package pm.client;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.EmpVO;

public class Ex2_for {
	
	public static void main(String[] args) throws Exception {
		
		Reader read = Resources.getResourceAsReader("pm/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
		
		read.close();
		
		SqlSession session = factory.openSession();
		/* ▼ empno_ar */
		Integer[] ar = {100,120,220,289,300,450};
		
		/* emp2.xml에 getEmp를 호출하기 위해 Map 컬렉션 생성 */
		Map<String, Integer[]> map = new LinkedHashMap<String, Integer[]>();
		
		map.put("empno_ar", ar);
		
		List<EmpVO> list = session.selectList("emp2.getEmp",map);
		
		for(EmpVO evo : list) {
			
			System.out.println(
					evo.getEmployee_id() + " " + 
			        evo.getLast_name() + " "
				   +evo.getHire_date() + " " + 
			        evo.getJob_id() + " " + 
				   evo.getDepartment_id());
		}
		
		
		
	}

}
