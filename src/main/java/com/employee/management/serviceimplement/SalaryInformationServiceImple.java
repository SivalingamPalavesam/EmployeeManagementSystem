package com.employee.management.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.database.SalaryInformationDatabase;
import com.employee.management.model.SalaryInformation;
import com.employee.management.service.SalaryInformationsSerivice;

@Service
public class SalaryInformationServiceImple implements SalaryInformationsSerivice {

	@Autowired
	SalaryInformationDatabase salaryinformationdatabase;
	
	public List<SalaryInformation> getAllEmployeesSalaryinformation() {
		
		return salaryinformationdatabase.getAllEmployeesSalaryinformation() ;
	}
	@Override
	public SalaryInformation getEmpworkingBasedOnId(int id) {
		
		 List<SalaryInformation> empList = salaryinformationdatabase.getAllEmployeesSalaryinformation();
		 
		 SalaryInformation empidValue = empList.stream().filter(emp->emp.getEmp_id_number() == id).findAny().get();
		
		return empidValue;
	}
	
	@Override
	public  String InsertEmployeeSalarytData(SalaryInformation employeedata)
	{
		return salaryinformationdatabase.InsertEmployeeSalarytData(employeedata);
		
	}



	@Override
	public String deleteEmpSalaryData(SalaryInformation deletedata) {
		
		return salaryinformationdatabase.deleteEmpSalaryData(deletedata);
	}	


	

}
