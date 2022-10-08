package com.employee.management.model;

public class ContactInformationmodel
{
	private int emp_id_number;
	private String home_Phone_number;
	private	String home_address;
	private String Gender;
	
	public int getEmp_id_number() {
		return emp_id_number;
	}
	public void setEmp_id_number(int emp_id_number)
	{
		this.emp_id_number = emp_id_number;
	}
	public String getHome_Phone_number()
	{
		return home_Phone_number;
	}
	public void setHome_Phone_number(String home_Phone_number)
	{
		this.home_Phone_number = home_Phone_number;
	}
	public String getHome_address()
	{
		return home_address;
	}
	public void setHome_address(String home_address) 
	{
		this.home_address = home_address;
	}
	public String getGender()
	{
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
}
