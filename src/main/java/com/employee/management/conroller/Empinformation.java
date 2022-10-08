package com.employee.management.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Empinformationmodel;
import com.employee.management.service.EmpinformationService;

@RestController
public class Empinformation {
	
	@Autowired
	EmpinformationService  empinformationimplement;
	
	@RequestMapping (value ="/getemployees",method=RequestMethod.GET)
	public List<Empinformationmodel> getEmployee()
	{
		 List<Empinformationmodel> emplist = empinformationimplement.getAllEmployeesinformation();
		
		return emplist;
	}
	
	@RequestMapping(value="/getempbasedonid",method =RequestMethod.POST)
	public Empinformationmodel getEmpBasedOnId(@RequestParam("emp_id_number")int id)
	{
	
		Empinformationmodel empBaseid = empinformationimplement.getEmpBasedOnId(id);
	
		return empBaseid;
	}
	
/*	@RequestMapping (value="/getEmpBasedOnName",method =RequestMethod.POST,
			
	consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
	
	public void getEmpBasedOnBody(@RequestBody Empinformationmodel employeeValue )
	{
		//Empinformationmodel empBaseName = empinformationimplement.getEmpBasedOnBody();
		
		List<Empinformationmodel> empList = empinformationimplement.getAllEmployeesinformation();
		
		Empinformationmodel ValueFind = empList.stream().filter(objname ->objname.getFirstname()==employeeValue.getFirstname()).findAny().get();
	}	*/
	
	@RequestMapping (value="/putEmployeeData",method =RequestMethod.PUT,
			
			consumes =MediaType.APPLICATION_JSON_VALUE) 
	public String putempData(@RequestBody Empinformationmodel employeedata )
	{
		if(employeedata.getEmp_id_number() == 0) 
		{
		
			throw new IllegalArgumentException("Employe id is invalid");
			
		}
		String result = empinformationimplement.InsertEmployeeData(employeedata);
		
		return result;
	}
	
		@RequestMapping(value="/deleteEmployeeData",method =RequestMethod.DELETE,consumes =MediaType.APPLICATION_JSON_VALUE) 
		public String deleteEmpData(@RequestBody Empinformationmodel deletedata )
		{
			if(deletedata.getEmp_id_number() == 0) 
			{
			
				throw new IllegalArgumentException("Employe id is invalid");
				
			}
			String status = empinformationimplement.deleteEmpData(deletedata);
			
			return status;
		}
	
	
}
