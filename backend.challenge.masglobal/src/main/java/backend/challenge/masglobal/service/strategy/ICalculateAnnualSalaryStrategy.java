package backend.challenge.masglobal.service.strategy;

import backend.challenge.masglobal.service.EmployeeDTO;

import java.math.BigDecimal;

public interface ICalculateAnnualSalaryStrategy {
    public BigDecimal calculateAnnualSalary(EmployeeDTO empDTO);
}
