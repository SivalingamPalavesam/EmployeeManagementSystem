package com.employee.management.database;

import java.util.List;

import com.employee.management.model.WorkingHistory;

public interface WorkingHistorydatabase {
	
		public abstract List<WorkingHistory> getAllEmployeesinformation();

		public abstract String InsertEmployeeWorkingData(WorkingHistory employeedata);

		public abstract String deleteEmpWorkingData(WorkingHistory deletedata);
		
}
