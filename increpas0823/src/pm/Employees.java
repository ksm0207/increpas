package pm;

import java.io.Serializable;

public class Employees implements Serializable{
	
	
	String id;
	String name;
	String ph;
	String job;
	String depart;
	
	public Employees(String id , String name , String ph , String job , String depart) {
		
		this.id= id;
		this.name = name;
		this.ph = ph;
		this.job = job;
		this.depart = depart;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	

}
