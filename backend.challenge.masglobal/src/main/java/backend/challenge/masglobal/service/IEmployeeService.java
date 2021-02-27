package backend.challenge.masglobal.service;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDTO> getEmployeesWithAnnualSalary();

    List<EmployeeDTO> getEmployeesWithAnnualSalary(List<Integer> employeeIds);
}
