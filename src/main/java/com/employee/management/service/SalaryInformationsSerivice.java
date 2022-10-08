package com.employee.management.service;

import java.util.List;

import com.employee.management.model.SalaryInformation;

public interface SalaryInformationsSerivice
{
	
	public abstract List<SalaryInformation> getAllEmployeesSalaryinformation();

	public abstract SalaryInformation getEmpworkingBasedOnId(int id);

	public abstract String InsertEmployeeSalarytData(SalaryInformation employeedata);
	
	public abstract String deleteEmpSalaryData(SalaryInformation deletedata);
}
