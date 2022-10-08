package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Empinformationmodel;

public interface EmpinformationService {

	public abstract List<Empinformationmodel> getAllEmployeesinformation();

	public abstract Empinformationmodel getEmpBasedOnId(int id);

	public abstract String InsertEmployeeData(Empinformationmodel employeedata);
	
	public abstract String deleteEmpData(Empinformationmodel deletedata);
	
	
}
