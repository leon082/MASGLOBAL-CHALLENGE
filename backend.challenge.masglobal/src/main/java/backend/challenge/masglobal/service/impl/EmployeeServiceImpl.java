package backend.challenge.masglobal.service.impl;

import backend.challenge.masglobal.facade.IEmployeeRepositoryFacade;
import backend.challenge.masglobal.service.EmployeeDTO;
import backend.challenge.masglobal.service.IEmployeeService;
import backend.challenge.masglobal.service.factory.CalculateAnnualSalaryStrategyFactory;
import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepositoryFacade facade;
    private CalculateAnnualSalaryStrategyFactory strategyFactory;


    @Autowired
    public EmployeeServiceImpl(IEmployeeRepositoryFacade facade,
                               CalculateAnnualSalaryStrategyFactory strategyFactory) {
        this.facade = facade;
        this.strategyFactory= strategyFactory;
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithAnnualSalary() {
        List<EmployeeDTO> employeesList = new ArrayList<>();
        facade.getEmployees().forEach(emp -> {
            ICalculateAnnualSalaryStrategy strategy = strategyFactory.getStrategy(emp);
            EmployeeDTO dto = new EmployeeDTO(emp);
            dto.calculateAnnualSalary(strategy);
            employeesList.add(dto);
        });
        return employeesList;
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithAnnualSalary(List<Integer> employeeIds) {
        return getEmployeesWithAnnualSalary().stream().filter(emp -> employeeIds.contains(emp.getId()))
                .collect(Collectors.toList());
    }
}
