package SerializableTest.FirstExample;

import java.io.Serializable;

public class SerialDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int bookOrder;
	private int soldPerday;
	private boolean bestSeller;
	
	public SerialDTO(String name , int bookOrder , int soldPerday, boolean bestSeller) {
		this.name = name;
		this.bookOrder = bookOrder;
		this.soldPerday = soldPerday;
		this.bestSeller = bestSeller;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBookOrder() {
		return bookOrder;
	}
	public void setBookOrder(int bookOrder) {
		this.bookOrder = bookOrder;
	}
	public int getSoldPerday() {
		return soldPerday;
	}
	public void setSoldPerday(int soldPerday) {
		this.soldPerday = soldPerday;
	}
	public boolean isBestSeller() {
		return bestSeller;
	}
	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}
	
	
	@Override
	public String toString() {
		
		return "SerialDTO {"+"name:"+name+ "," + "bookOrder:"+bookOrder+","
				 			   +"soldPerday:"+soldPerday+"," + "bestSeller:"+bestSeller+"}";
	}
	
	
}
