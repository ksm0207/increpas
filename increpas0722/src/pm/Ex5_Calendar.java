package pm;

import java.sql.Date;
import java.util.Calendar;

public class Ex5_Calendar {
	public static void main(String[] args) {
		
		// 현재 날짜를 구하기 위한 객체를 만들자
		
		Calendar cal = Calendar.getInstance();
		
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH); // 1월이 0으로 기억됨 
		int dd = cal.get(Calendar.DAY_OF_MONTH); // 현재 월의 날짜
		
		System.out.println(yy + " 년 " 
		                + (mm+1) + " 월 " 
				         + dd + " 일 " + " 입니다 ");
		
		StringBuffer sb = new StringBuffer();
		sb.append(yy).append("-").append((mm+1)).append("-").append(dd);
		
		String res = sb.toString();
		System.out.println(res);
		
		// 날짜 구하기 초 간단한 방법
		
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		
	}
}
