package com.employee.management.model;

public class WorkingHistory {

				private int  emp_id_number;
				private String company_name;
				private int experince_year	;
				private String company_phno;
				
				
				public int getEmp_id_number() 
				{
					return emp_id_number;
				}
				public void setEmp_id_number(int emp_id_number)
				{
					this.emp_id_number = emp_id_number;
				}
				public String getCompany_name() 
				{
					return company_name;
				}
				public void setCompany_name(String company_name) 
				{
					this.company_name = company_name;
				}
				public int getExperince_year() 
				{
					return experince_year;
				}
				public void setExperince_year(int experince_year)
				{
					this.experince_year = experince_year;
				}
				public String getCompany_phno() 
				{
					return company_phno;
				}
				public void setCompany_phno(String company_phno) 
				{
					this.company_phno = company_phno;
				}
}
