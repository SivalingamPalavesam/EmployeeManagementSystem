package com.employee.management.database;

import java.util.List;

import com.employee.management.model.Empinformationmodel;

public interface Empdatabase {

	public abstract List<Empinformationmodel> getAllEmployeesinformation();

	public abstract String InsertEmployeeData(Empinformationmodel employeedata);

	public abstract String deleteEmpData(Empinformationmodel deletedata);

}
