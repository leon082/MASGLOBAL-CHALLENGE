package backend.challenge.masglobal.facade;

import backend.challenge.masglobal.facade.model.Employee;

import java.util.List;

public interface IEmployeeRepositoryFacade {

    List<Employee> getEmployees();
}
