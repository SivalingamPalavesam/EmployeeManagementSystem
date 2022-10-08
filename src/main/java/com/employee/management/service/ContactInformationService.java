package com.employee.management.service;

import java.util.List;

import com.employee.management.model.ContactInformationmodel;

public interface ContactInformationService {

	public abstract List<ContactInformationmodel> getAllEmployeesContactinformation();

	public abstract ContactInformationmodel getEmpContactBasedOnId(int id);

	public abstract String InsertEmployeeContactData(ContactInformationmodel employeedata);
	
	public abstract String deleteEmpContactData(ContactInformationmodel deletedata);
	

	
}
