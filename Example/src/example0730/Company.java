package example0730;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Company {
	
	ArrayList<EmployeeVO> emp = new ArrayList<EmployeeVO>();
	
	public void getInit() {
	
		emp.add(new EmployeeVO("100", "마루치", "개발-2팀", "2021-07-31", "2001-07-30"));
		emp.add(new EmployeeVO("200", "아라치", "개발-3팀", "2021-07-31", "2001-07-30"));
		emp.add(new EmployeeVO("300", "Kim", "개발-3팀", "2021-07-28", "2001-07-30"));
		emp.add(new EmployeeVO("400", "Nam", "개발-3팀", "2021-07-29", "2001-07-30"));
		emp.add(new EmployeeVO("500", "Seo", "개발-4팀", "2021-07-30", "2001-07-29"));
	}

	public void getPrint() {
		Date from = new Date();
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-MM-dd");
		String res = trans.format(from);
		
		for (int i=0; i<emp.size(); i++){
			if (emp.get(i).getHire_date().equals(res)) {
				System.out.println(emp.get(i));						
			}else {
				break;
				
			}
		}
		
	}
}
