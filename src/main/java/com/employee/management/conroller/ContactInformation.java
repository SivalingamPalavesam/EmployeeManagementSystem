package com.employee.management.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employee.management.model.ContactInformationmodel;
import com.employee.management.serviceimplement.ContactInformationServiceimpl;

@RestController
public class ContactInformation {
	
	@Autowired
	ContactInformationServiceimpl  empinformationimplement;
	
	@RequestMapping (value ="/getcontactDetails",method=RequestMethod.GET)
	
	public List<ContactInformationmodel> getEmployeecdetail()
	{
		 List<ContactInformationmodel> emplist = empinformationimplement.getAllEmployeesContactinformation();
		
		return emplist;
	}
	
	@RequestMapping(value="/getcontactBasedonId",method =RequestMethod.POST)
	
	public ContactInformationmodel getEmpBasedOnId(@RequestParam("emp_id_number")int id)
	{
	
		ContactInformationmodel empBaseid = empinformationimplement.getEmpContactBasedOnId(id);
	
		return empBaseid;
	}
	
	
	@RequestMapping (value="/putEmployeecontactData",method =RequestMethod.PUT,
			
			consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
	
	public String InsertEmployeeData(@RequestBody ContactInformationmodel employeedata )
	{
		if(employeedata.getEmp_id_number() == 0) 
		{
		
			throw new IllegalArgumentException("Employe id is invalid");
			
		}
		String result = empinformationimplement.InsertEmployeeContactData(employeedata);
		
		return result;
	}
	
		@RequestMapping(value="/deleteEmployeeContactData",method =RequestMethod.DELETE,
				
				consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
		
		public String deleteEmpContactData(@RequestBody ContactInformationmodel deletedata )
		{
			if(deletedata.getEmp_id_number() == 0) 
			{
			
				throw new IllegalArgumentException("Employe id is invalid");
				
			}
			String status = empinformationimplement.deleteEmpContactData(deletedata);
			
			return status;
		}

}
