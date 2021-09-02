package am.Client;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			// 1. 환경설정(config.xml) 파일과 연결되는 스트림을 생성하기.
			Reader reader = Resources.getResourceAsReader("am/config/config.xml");
			
			// 2. 필요한 것은 SqlSession 이지만 '이전에' 세션을 만들어주는
			//    Factory를 생성해준다.
			SqlSessionFactory factory = 
			new SqlSessionFactoryBuilder().build(reader);
			
			// 3. 사용된 스트림 닫기.
			reader.close();
			
			// 4. SQL 문장을 모두 호출할 수 있는 SqlSession 객체를
			//    Factory를 통해 얻어내주자.
			SqlSession s_session = factory.openSession();
			
			// 5. Sql Mapper - emp.xml
			//'전체' 사원 즉 여러 데이터 확인할때는 List쓰기 , 인자값 확인
//			List<EmpVO> list = s_session.selectList("emp.all");
			
			
			// 6. Sql Mapper - emp.xml
			// 여러데이터가 아닌 단일 데이터를 확인할때는 다음과 같이
			// 사용하기.	
			EmpVO vo = s_session.selectOne("emp.search_empno","200");
			
			if(vo != null) {
				System.out.println("사원 번호 : " +vo.getEmployee_id());
				System.out.println("사원 이름 : " +vo.getFirst_name());
				System.out.println("사원 직업 : " +vo.getJob_id());
				System.out.println("입사 날짜 : " +vo.getHire_date());
				System.out.println("부서 코드 : " +vo.getDepartment_id());
			}else {
				System.out.println("존재하지않는 데이터 입니다.");
			}
			
			
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 검색 :");
			String name = scan.nextLine();
			
			List<EmpVO> list2 = s_session.selectList("emp.search_name",name);
			
			for(EmpVO evo : list2) {
				if(evo != null) {
					System.out.println(evo.getFirst_name());					
				}else {
					System.out.println("존재하지 않는 데이터 입니다.");
				}
			}
			
			if (s_session != null)
				s_session.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
