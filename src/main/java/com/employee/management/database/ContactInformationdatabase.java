package com.employee.management.database;

import java.util.List;
import com.employee.management.model.ContactInformationmodel;

public interface ContactInformationdatabase 
{
	public  List<ContactInformationmodel> getAllEmployeesinformation();

	public  String InsertEmployeeContactData(ContactInformationmodel employeedata);

	public  String deleteEmpContactData(ContactInformationmodel deletedata);
}
