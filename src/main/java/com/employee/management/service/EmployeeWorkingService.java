package com.employee.management.service;

import java.util.List;

import com.employee.management.model.WorkingHistory;

public interface EmployeeWorkingService {


		public abstract List<WorkingHistory> getAllEmployeesworkinginformation();

		public abstract WorkingHistory getEmpworkingBasedOnId(int id);

		public abstract String InsertEmployeeData(WorkingHistory employeedata);
		
		public abstract String deleteEmpWorkingData(WorkingHistory deletedata);
		
}
