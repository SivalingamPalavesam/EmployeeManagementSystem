package com.employee.management.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.management.database.ContactInformationdatabase;
import com.employee.management.model.ContactInformationmodel;
import com.employee.management.service.ContactInformationService;
@Service
public class ContactInformationServiceimpl implements ContactInformationService
{

	@Autowired 
	ContactInformationdatabase obj;
	
	@Override
	public List<ContactInformationmodel> getAllEmployeesContactinformation() {
		
		 List<ContactInformationmodel> empList = obj.getAllEmployeesinformation();
		return empList;		
	}

	

	@Override
	public ContactInformationmodel getEmpContactBasedOnId(int id) {
		
		 List<ContactInformationmodel> empList = obj.getAllEmployeesinformation();
		 
		 ContactInformationmodel empidValue = empList.stream().filter(emp->emp.getEmp_id_number() == id).findAny().get();
		
		return empidValue;
	}
	
	@Override
	public  String InsertEmployeeContactData(ContactInformationmodel employeedata)
	{
		return obj.InsertEmployeeContactData(employeedata);
		
	}



	@Override
	public String deleteEmpContactData(ContactInformationmodel deletedata) {
		
		return obj.deleteEmpContactData(deletedata);
	}	

	

	
	
}
