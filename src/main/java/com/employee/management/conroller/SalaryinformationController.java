package com.employee.management.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.SalaryInformation;
import com.employee.management.serviceimplement.SalaryInformationServiceImple;

@RestController
public class SalaryinformationController {

	@Autowired
	SalaryInformationServiceImple  empinformationimplement;
	
	@RequestMapping (value ="/getSalaryDetails",method=RequestMethod.GET)
	
	public List<SalaryInformation> getEmployeecdetail()
	{
		 List<SalaryInformation> emplist = empinformationimplement.getAllEmployeesSalaryinformation();
		
		return emplist;
	}
	
@RequestMapping(value="/getSalaryBasedonId",method =RequestMethod.POST)
	
	public SalaryInformation getEmpBasedOnId(@RequestParam("emp_id_number")int id)
	{
	
	SalaryInformation empBaseid = empinformationimplement.getEmpworkingBasedOnId(id);
	
		return empBaseid;
	}
	
	
	@RequestMapping (value="/putEmployeeSalaryData",method =RequestMethod.PUT,
			
			consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
	
	public String InsertEmployeeData(@RequestBody SalaryInformation employeedata )
	{
		if(employeedata.getEmp_id_number() == 0) 
		{
		
			throw new IllegalArgumentException("Employe id is invalid");
			
		}
		String result = empinformationimplement.InsertEmployeeSalarytData(employeedata);
		
		return result;
	}
	
		@RequestMapping(value="/deleteEmployeeSalaryData",method =RequestMethod.DELETE,
				
				consumes =MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE) 
		
		public String deleteEmpWorkingData(@RequestBody SalaryInformation deletedata )
		{
			if(deletedata.getEmp_id_number() == 0) 
			{
			
				throw new IllegalArgumentException("Employe id is invalid");
				
			}
			String status = empinformationimplement.deleteEmpSalaryData(deletedata);
			
			return status;
		}
	
}
