package backend.challenge.masglobal.service.strategy.impl;

import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import backend.challenge.masglobal.utils.Constants;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
public class MonthlySalaryContractImpl implements ICalculateAnnualSalaryStrategy {
        private BigDecimal salary;
    @Override
    public BigDecimal calculateAnnualSalary() {
        return Constants.YEAR_MONTHS.multiply(this.salary);
    }
}
