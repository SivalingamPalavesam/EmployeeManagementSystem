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

import com.employee.management.database.WorkingHistorydatabase;
import com.employee.management.model.WorkingHistory;

@Component
public  class WorkingHistorydatabaseimplements implements WorkingHistorydatabase {

		@Autowired
		JdbcTemplate template;
		@Override
		public List<WorkingHistory> getAllEmployeesinformation()
		{
		
			
			  return template.query("select * from workinghistory",new ResultSetExtractor<List<WorkingHistory>>() {

				List<WorkingHistory> empList = new ArrayList<>();
				@Override
				public List<WorkingHistory> extractData(ResultSet rs) throws SQLException, DataAccessException 
				{
					
					while(rs.next())
					{
						WorkingHistory empinformationmodel = new WorkingHistory();
						
						
						empinformationmodel.setEmp_id_number(rs.getInt("emp_id_number"));
						
						empinformationmodel.setCompany_name(rs.getString("company_name"));
						
						empinformationmodel.setExperince_year(rs.getInt("experince_year"));
						
						empinformationmodel.setCompany_phno(rs.getString("company_phno"));
						
						empList.add(empinformationmodel);
					}
					
					return empList;
				}
			});
				
		}
		@Override
		public String InsertEmployeeWorkingData(WorkingHistory employeedata) 
		{
			String result ="Data Insertion failed";
			
			String sql ="insert into employeemangementsystem.workinghistory(emp_id_number,company_name,experince_year,company_phno)"+"values("+employeedata.getEmp_id_number()+",'"+employeedata.getCompany_name()+"',"+employeedata.getExperince_year()+",'"+employeedata.getCompany_phno()+"')";			
			
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
		public String deleteEmpWorkingData(WorkingHistory deletedata) {
			
			String status ="Data Delete failed";
			
			String sql ="delete from employeemangementsystem.workinghistory WHERE emp_id_number = "+deletedata.getEmp_id_number();

			
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
