package pm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3_StringTokenizer {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String res = "";
		String date = "2021-07-22";
		
		st = new StringTokenizer(date, "-");
		
		int count = st.countTokens();
		System.out.println(count);
		
		// hasMoreTokens : 분리할 것이 있으면 true 값을 반환
		while (st.hasMoreTokens()) {
			res = st.nextToken();
//			System.out.println(res);
		}
		
		System.out.println(date.split(" - "));
		String [] a = date.split("-");
		
		for (int i = 0 ; i < a.length; i ++) {
			System.out.println(a[i]);
		}

	}
}
