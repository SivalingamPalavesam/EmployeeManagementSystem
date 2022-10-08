package com.employee.management.model;

public class Empinformationmodel {

		private int  emp_id_number;
		private String firstname;
		private String lastname	;
		private int age;
		private String city;
		
		public int getEmp_id_number() {
			return emp_id_number;
		}
		public void setEmp_id_number(int emp_id_number)
		{
			this.emp_id_number = emp_id_number;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname)
		{
			this.firstname = firstname;
		}
		public String getLastname() 
		{
			return lastname;
		}
		public void setLastname(String lastname)
		{
			this.lastname = lastname;
		}
		public int getAge() 
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
		public String getCity()
		{
			return city;
		}
		public void setCity(String city)
		{
			this.city = city;
		}
	
}
