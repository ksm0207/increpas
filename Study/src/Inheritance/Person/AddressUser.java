package Inheritance.Person;

public class AddressUser extends Person {

	String address;
	
	public AddressUser(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
}
