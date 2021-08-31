package pm.model;

import javax.swing.table.AbstractTableModel;

import pm.client.Ex1_Frame;

public class MyModel extends AbstractTableModel {
	
	// 1. JTable 만들기(1) Model 객체 만들기
	
	// 1-1. 컬럼명들을 배열로 선언
	String[] col_name; // 열
	
	// 실제 표현할 데이터를 2차원 배열로 선언해주기.
	String[][] data;   // 행
	
	Ex1_Frame ex1;
	
	public MyModel (String[] col_name , String[][] data) {
		
		this.col_name = col_name;
		this.data = data;
	}
	
	@Override
	public int getRowCount() {
		// String[] col_name : 열의 수를 반환
		
		return data.length;
	}
	
	@Override
	public int getColumnCount() {
		// String[][] data : 행의 수를 반환
		return col_name.length;
	}
	
	
	@Override
	public Object getValueAt(int row, int column) {
		// row 0 1 2
		// col 0 1 3 4
		
		// 0,0 , 0,1 , 0,2 , 0,3
		// 1,0 , 1,1 , 1,2 , 1,3 ...
		
		// ▲ 2차원배열에서 데이터 추출하는곳
		return data[row][column];
	}
	
	@Override
	public String getColumnName(int column) {
		// getColumnCount() 가 반환하는 수 만큼 호출됨.
		return col_name[column];
	}
}
