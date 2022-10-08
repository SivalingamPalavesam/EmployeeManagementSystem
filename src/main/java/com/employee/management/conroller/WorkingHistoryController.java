package com.employee.management.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employee.management.model.WorkingHistory;
import com.employee.management.serviceimplement.WorkingServiceServiceimplements;

@RestController
public class WorkingHistoryController {

	@Autowired
	WorkingServiceServiceimplements  empinformationimplement;
	
	@RequestMapping (value ="/getwokinghistory",method=RequestMethod.GET)
	
	public List<WorkingHistory> getEmployeeworkingdetail()
	{
		 List<WorkingHistory> emplist = empinformationimplement.getAllEmployeesworkinginformation();
		
		return emplist;
	}
	
	@RequestMapping(value="/getWorkingBasedonId",method =RequestMethod.POST)
	
	public WorkingHistory getEmpBasedOnId(@RequestParam("emp_id_number")int id)
	{
	
		WorkingHistory empBaseid = empinformationimplement.getEmpworkingBasedOnId(id);
	
		return empBaseid;
	}
	
	
	@RequestMapping (value="/putEmployeeWokingData",method =RequestMethod.PUT,
			
			consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
	
	public String InsertEmployeeData(@RequestBody WorkingHistory employeedata )
	{
		if(employeedata.getEmp_id_number() == 0) 
		{
		
			throw new IllegalArgumentException("Employe id is invalid");
			
		}
		String result = empinformationimplement.InsertEmployeeData(employeedata);
		
		return result;
	}
	
		@RequestMapping(value="/deleteEmployeeWorkingData",method =RequestMethod.DELETE,
				
				consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
		
		public String deleteEmpWorkingData(@RequestBody WorkingHistory deletedata )
		{
			if(deletedata.getEmp_id_number() == 0) 
			{
			
				throw new IllegalArgumentException("Employe id is invalid");
				
			}
			String status = empinformationimplement.deleteEmpWorkingData(deletedata);
			
			return status;
		}

}
