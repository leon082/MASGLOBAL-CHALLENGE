package backend.challenge.masglobal.service.strategy.impl;

import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import backend.challenge.masglobal.utils.Constants;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
public class HourlySalaryContractImpl implements ICalculateAnnualSalaryStrategy {
    private BigDecimal salary;

    @Override
    public BigDecimal calculateAnnualSalary() {
       return Constants.HOUR_FACTOR.multiply(this.salary).multiply(Constants.YEAR_MONTHS);
    }
}
