package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1152 {
	public static void main(String[] args) throws IOException {
		
		// 1. 단어의 개수 - 1152번
		// 2. 조건 : 영어 대소문자와 띄어쓰기만으로 이루어진다
		// 3. 출력 : 몇개의 단어가 있는지 체크할 것
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		System.out.println(st.countTokens());
		
	}
}
