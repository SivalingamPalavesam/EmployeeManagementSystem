package com.employee.management.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.database.WorkingHistorydatabase;
import com.employee.management.model.WorkingHistory;
import com.employee.management.service.EmployeeWorkingService;


@Component
public class WorkingServiceServiceimplements implements EmployeeWorkingService {

	@Autowired 
	WorkingHistorydatabase obj;
	
	@Override
	public List<WorkingHistory> getAllEmployeesworkinginformation() {
		
		 List<WorkingHistory> empList = obj.getAllEmployeesinformation();
		return empList;		
	}

	

	@Override
	public WorkingHistory getEmpworkingBasedOnId(int id) {
		
		 List<WorkingHistory> empList = obj.getAllEmployeesinformation();
		 
		 WorkingHistory empidValue = empList.stream().filter(emp->emp.getEmp_id_number() == id).findAny().get();
		
		return empidValue;
	}
	
	@Override
	public  String InsertEmployeeData(WorkingHistory employeedata)
	{
		return obj.InsertEmployeeWorkingData(employeedata);
		
	}



	@Override
	public String deleteEmpWorkingData(WorkingHistory deletedata) {
		
		return obj.deleteEmpWorkingData(deletedata);
	}	
}


