package com.employee.management.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.model.Empinformationmodel;
import com.employee.management.service.EmpinformationService;
import com.employee.management.database.*;

@Component
public class EmpinformationImplement implements EmpinformationService {

	@Autowired 
	Empdatabase obj;
	
	@Override
	public List<Empinformationmodel> getAllEmployeesinformation() {
		
		 List<Empinformationmodel> empList = obj.getAllEmployeesinformation();
		return empList;		
	}

	

	@Override
	public Empinformationmodel getEmpBasedOnId(int id) {
		
		 List<Empinformationmodel> empList = obj.getAllEmployeesinformation();
		 
		Empinformationmodel empidValue = empList.stream().filter(emp->emp.getEmp_id_number() == id).findAny().get();
		
		return empidValue;
	}
	
	@Override
	public  String InsertEmployeeData(Empinformationmodel employeedata)
	{
		return obj.InsertEmployeeData(employeedata);
		
	}



	@Override
	public String deleteEmpData(Empinformationmodel deletedata) {
		
		return obj.deleteEmpData(deletedata);
	}
}

