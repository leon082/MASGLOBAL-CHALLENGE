package backend.challenge.masglobal.facade.impl;

import backend.challenge.masglobal.facade.IEmployeeRepositoryFacade;
import backend.challenge.masglobal.facade.model.Employee;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Data
@Component
public class MasGlobalTestApiFacadeImpl implements IEmployeeRepositoryFacade {
    @Value("${masglobal.api.baseUrl}")
    private String masglobalURL;

    @Value("${masglobal.api.employees}")
    private String employeesURL;

    private RestTemplate restTemplate;

    @Autowired
    public MasGlobalTestApiFacadeImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> getEmployees() {
        return restTemplate.exchange(this.buildEmployeesURL(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                }).getBody();
    }

    private String buildEmployeesURL() {
        return masglobalURL.concat(employeesURL);
    }

}
