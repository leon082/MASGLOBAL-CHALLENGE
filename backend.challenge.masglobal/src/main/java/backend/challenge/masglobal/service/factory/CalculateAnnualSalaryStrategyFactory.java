package backend.challenge.masglobal.service.factory;

import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import backend.challenge.masglobal.service.strategy.impl.HourlySalaryContractImpl;
import backend.challenge.masglobal.service.strategy.impl.MonthlySalaryContractImpl;
import backend.challenge.masglobal.utils.Constants;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CalculateAnnualSalaryStrategyFactory {

    private Map<String,ICalculateAnnualSalaryStrategy> strategies;

    @PostConstruct
    public void init(){
        strategies = new HashMap<>();
        strategies.put(Constants.SALARY_TYPE_HOURLY, new HourlySalaryContractImpl());
        strategies.put(Constants.SALARY_TYPE_MONTHLY, new MonthlySalaryContractImpl());
    }

    public ICalculateAnnualSalaryStrategy getStrategy(String typeContract) {
        return strategies.get(typeContract);
    }

}
