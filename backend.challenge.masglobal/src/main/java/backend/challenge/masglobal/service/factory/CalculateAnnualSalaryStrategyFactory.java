package backend.challenge.masglobal.service.factory;

import backend.challenge.masglobal.facade.model.Employee;
import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import backend.challenge.masglobal.service.strategy.impl.HourlySalaryContractImpl;
import backend.challenge.masglobal.service.strategy.impl.MonthlySalaryContractImpl;
import backend.challenge.masglobal.utils.Constants;
import org.springframework.stereotype.Component;

@Component
public class CalculateAnnualSalaryStrategyFactory {

    public ICalculateAnnualSalaryStrategy getStrategy(Employee employee) {

        if (Constants.SALARY_TYPE_HOURLY.equals(employee.getContractTypeName())) {
            return new HourlySalaryContractImpl(employee.getHourlySalary());
        } else {
            return new MonthlySalaryContractImpl(employee.getMonthlySalary());
        }

    }

}
