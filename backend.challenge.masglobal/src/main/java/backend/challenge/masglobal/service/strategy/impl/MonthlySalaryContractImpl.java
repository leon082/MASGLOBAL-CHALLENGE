package backend.challenge.masglobal.service.strategy.impl;

import backend.challenge.masglobal.service.EmployeeDTO;
import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import backend.challenge.masglobal.utils.Constants;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
public class MonthlySalaryContractImpl implements ICalculateAnnualSalaryStrategy {

    @Override
    public BigDecimal calculateAnnualSalary(EmployeeDTO empDTO) {
        return Constants.YEAR_MONTHS.multiply(empDTO.getMonthlySalary());
    }
}
