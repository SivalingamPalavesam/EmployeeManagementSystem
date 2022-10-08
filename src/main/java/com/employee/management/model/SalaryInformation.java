package com.employee.management.model;

public class SalaryInformation 
{
	private int emp_id_number;
	private double monthly_salary;
	private double perannum_salary;
	private int Overtime_salary;
	
	public int getEmp_id_number()
	{
		return emp_id_number;
	}
	public void setEmp_id_number(int emp_id_number)
	{
		this.emp_id_number = emp_id_number;
	}
	public double getMonthly_salary()
	{
		return monthly_salary;
	}
	public void setMonthly_salary(double monthly_salary)
	{
		this.monthly_salary = monthly_salary;
	}
	public double getPerannum_salary() {
		return perannum_salary;
	}
	public void setPerannum_salary(double perannum_salary)
	{
		this.perannum_salary = perannum_salary;
	}
	public int getOvertime_salary()
	{
		return Overtime_salary;
	}
	public void setOvertime_salary(int overtime_salary)
	{
		Overtime_salary = overtime_salary;
	}
	
}
