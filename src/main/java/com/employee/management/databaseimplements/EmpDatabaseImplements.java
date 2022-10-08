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
import com.employee.management.database.Empdatabase;
import com.employee.management.model.Empinformationmodel;

@Component
public class EmpDatabaseImplements implements Empdatabase {

	@Autowired
	JdbcTemplate template;
	@Override
	public List<Empinformationmodel> getAllEmployeesinformation()
	{
		

		  return template.query("select * from empinformation",new ResultSetExtractor<List<Empinformationmodel>>() {

			List<Empinformationmodel> empList = new ArrayList<>();
			@Override
			public List<Empinformationmodel> extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				
				while(rs.next())
				{
					Empinformationmodel empinformationmodel = new Empinformationmodel();
					
					
					empinformationmodel.setEmp_id_number(rs.getInt("emp_id_number"));
					
					empinformationmodel.setFirstname(rs.getString("firstname"));
					
					empinformationmodel.setLastname(rs.getString("lastname"));
					
					empinformationmodel.setAge(rs.getInt("age"));
					
					empinformationmodel.setCity(rs.getString("city"));
					
					empList.add(empinformationmodel);
				}
				
				return empList;
			}
		});
			
	}
	@Override
	public String InsertEmployeeData(Empinformationmodel employeedata) 
	{
		String result ="Data Insertion failed";
		
		String sql ="insert into employeemangementsystem.empinformation(emp_id_number,firstname,lastname,age,city)"+"values("+employeedata.getEmp_id_number()+",'"+employeedata.getFirstname()+"','"+employeedata.getLastname()+"',"+employeedata.getAge()+",'"+employeedata.getCity()+"')";
		
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
	public String deleteEmpData(Empinformationmodel deletedata) {
		
		String status ="Data Delete failed";
		
		String sql ="delete from employeemangementsystem.empinformation WHERE emp_id_number = "+deletedata.getEmp_id_number();

		
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
