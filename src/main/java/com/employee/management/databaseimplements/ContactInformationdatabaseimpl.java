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

import com.employee.management.database.ContactInformationdatabase;
import com.employee.management.model.ContactInformationmodel;

@Component
public  class ContactInformationdatabaseimpl implements ContactInformationdatabase  {
	
	@Autowired
	JdbcTemplate template;
	@Override
	public List<ContactInformationmodel> getAllEmployeesinformation()
	{
		  return template.query("select * from contactInformation",new ResultSetExtractor<List<ContactInformationmodel>>() {

			List<ContactInformationmodel> empList = new ArrayList<>();
			@Override
			public List<ContactInformationmodel> extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				
				while(rs.next())
				{
					ContactInformationmodel empinformationmodel = new ContactInformationmodel();
					
					
					empinformationmodel.setEmp_id_number(rs.getInt("emp_id_number"));
					
					empinformationmodel.setHome_Phone_number(rs.getString("home_Phone_number"));
					
					empinformationmodel.setHome_address(rs.getString("home_address"));
					
					empinformationmodel.setGender(rs.getString("Gender"));
					
					empList.add(empinformationmodel);
				}
				
				return empList;
			}
		});
			
	}
	@Override
	public String InsertEmployeeContactData(ContactInformationmodel employeedata) 
	{
		String result ="Data Insertion failed";
		
		String sql ="insert into employeemangementsystem.contactInformation(emp_id_number,home_Phone_number,home_address,Gender)"+"values("+employeedata.getEmp_id_number()+",'"+employeedata.getHome_Phone_number()+"','"+employeedata.getHome_address()+"','"+employeedata.getGender()+"')";			
		
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
	public String deleteEmpContactData(ContactInformationmodel deletedata) {
		
		String status ="Data Delete failed";
		
		String sql ="delete from employeemangementsystem.contactInformation WHERE emp_id_number = "+deletedata.getEmp_id_number();

		
		try {
				template.execute(sql);
				
				status ="data Delete is successfully";
		}
		catch(Exception e) {
		
			System.out.println(e);
		}
		return status;
		
		
	}


}
