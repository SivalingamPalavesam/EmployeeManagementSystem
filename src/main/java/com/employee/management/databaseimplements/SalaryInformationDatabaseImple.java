package com.employee.management.databaseimplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.employee.management.database.SalaryInformationDatabase;
import com.employee.management.model.SalaryInformation;

@Component
public class SalaryInformationDatabaseImple implements SalaryInformationDatabase
{
	@Autowired
	JdbcTemplate template;
	@Override
	public List<SalaryInformation> getAllEmployeesSalaryinformation()
	{
		  return template.query("select * from salaryinformation",new ResultSetExtractor<List<SalaryInformation>>() 
		  {

			List<SalaryInformation> empList = new ArrayList<>();
			@Override
			public List<SalaryInformation> extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				
				while(rs.next())
				{
					SalaryInformation empinformationmodel = new SalaryInformation();
					
					
					empinformationmodel.setEmp_id_number(rs.getInt("emp_id_number"));
					
					empinformationmodel.setMonthly_salary(rs.getDouble("monthly_salary"));
					
					empinformationmodel.setPerannum_salary(rs.getDouble("perannum_salary"));
					
					empinformationmodel.setOvertime_salary(rs.getInt("Overtime_salary"));
					
					empList.add(empinformationmodel);
				}
				
				return empList;
			}
		});

	 }
	@Override
	public String InsertEmployeeSalarytData(SalaryInformation employeedata) 
	{
		String result ="Data Insertion failed";
		
		String sql ="insert into employeemangementsystem.salaryinformation(emp_id_number,monthly_salary,perannum_salary,Overtime_salary)"+"values("+employeedata.getEmp_id_number()+","+employeedata.getMonthly_salary()+","+employeedata.getPerannum_salary()+","+employeedata.getOvertime_salary()+")";			
		
		try {
				template.execute(sql);
				result ="data insert is successfully";
		}
		catch(Exception e) {
		
			System.out.println(e);
		}
		return result;

		
	}
	@Override
	public String deleteEmpSalaryData(SalaryInformation deletedata) 
	{	
		String status ="Data Delete failed";
		
		String sql ="delete from employeemangementsystem.salaryinformation WHERE emp_id_number = "+deletedata.getEmp_id_number();

		
		try 
		{
				template.execute(sql);
				
				status ="data Delete is successfully";
		}
		catch(Exception e)
		{
		
			System.out.println(e);
		}
		return status;
		
		
	}
}

