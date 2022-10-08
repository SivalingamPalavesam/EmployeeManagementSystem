package com.employee.management.database;

import java.util.List;

import com.employee.management.model.SalaryInformation;

public interface SalaryInformationDatabase {

	public abstract List<SalaryInformation> getAllEmployeesSalaryinformation();

	public abstract String InsertEmployeeSalarytData(SalaryInformation employeedata);

	public abstract String deleteEmpSalaryData(SalaryInformation deletedata);

	

}
