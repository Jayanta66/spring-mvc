package com;



public class Employee {
	
	int eid;
	String ename;
	String eband;
	
	
	public Employee() {
		super();
	}
	

	
	public Employee(int eid, String ename, String eband) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eband = eband;
	}



	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEband() {
		return eband;
	}
	public void setEband(String eband) {
		this.eband = eband;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eband=" + eband + "]";
	}
	
	

}
