package backend.challenge.masglobal.service.impl;

import backend.challenge.masglobal.facade.impl.MasGlobalTestApiFacadeImpl;
import backend.challenge.masglobal.facade.model.Employee;
import backend.challenge.masglobal.service.EmployeeDTO;
import backend.challenge.masglobal.service.factory.CalculateAnnualSalaryStrategyFactory;
import backend.challenge.masglobal.service.strategy.impl.HourlySalaryContractImpl;
import backend.challenge.masglobal.service.strategy.impl.MonthlySalaryContractImpl;
import backend.challenge.masglobal.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {


    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private MasGlobalTestApiFacadeImpl facade;

    private Employee employee;

    @Mock
    private CalculateAnnualSalaryStrategyFactory factory;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee();
        employee.setId(1);
        employee.setHourlySalary(new BigDecimal("50000"));
        employee.setMonthlySalary(new BigDecimal("800000"));
        employee.setName("Leon");
        employee.setRoleId(1);
        employee.setRoleName("Role Name");
        employee.setRoleDescription("Role Description");
        Mockito.when(factory.getStrategy(Constants.SALARY_TYPE_HOURLY)).thenReturn(new HourlySalaryContractImpl());
        Mockito.when(factory.getStrategy(Constants.SALARY_TYPE_MONTHLY)).thenReturn(new MonthlySalaryContractImpl());
    }

    @Test
    public void getEmployeesWithAnnualSalaryTestWithHourlySalaryEmployeeContract() {
        employee.setContractTypeName("HourlySalaryEmployee");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(facade.getEmployees()).thenReturn(employees);
        List<EmployeeDTO> employeesDtosList = employeeService.getEmployeesWithAnnualSalary();
        assertNotNull(employeesDtosList);
        assertEquals(1, employeesDtosList.size());

        EmployeeDTO dto = employeesDtosList.get(0);
        assertEquals(employee.getId(), dto.getId());
        assertEquals(employee.getContractTypeName(), dto.getContractTypeName());
        assertEquals(employee.getName(), dto.getName());
        assertEquals(employee.getRoleId(), dto.getRoleId());
        assertEquals(employee.getRoleName(), dto.getRoleName());
        assertEquals(employee.getRoleDescription(), dto.getRoleDescription());
        assertEquals(employee.getHourlySalary(), dto.getHourlySalary());
        assertEquals(employee.getMonthlySalary(), dto.getMonthlySalary());
        assertEquals(0, new BigDecimal("72000000").compareTo(dto.getAnnualSalary()));
    }

    @Test
    public void getEmployeesWithAnnualSalaryTestWithMonthlySalaryEmployeeContract() {
        employee.setContractTypeName("MonthlySalaryEmployee");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(facade.getEmployees()).thenReturn(employees);
        List<EmployeeDTO> employeesDtosList = employeeService.getEmployeesWithAnnualSalary();
        assertNotNull(employeesDtosList);
        assertEquals(1, employeesDtosList.size());


        EmployeeDTO dto = employeesDtosList.get(0);
        assertEquals(employee.getId(), dto.getId());
        assertEquals(employee.getContractTypeName(), dto.getContractTypeName());
        assertEquals(employee.getName(), dto.getName());
        assertEquals(employee.getRoleId(), dto.getRoleId());
        assertEquals(employee.getRoleName(), dto.getRoleName());
        assertEquals(employee.getRoleDescription(), dto.getRoleDescription());
        assertEquals(employee.getHourlySalary(), dto.getHourlySalary());
        assertEquals(employee.getMonthlySalary(), dto.getMonthlySalary());
        assertEquals(0, new BigDecimal("9600000").compareTo(dto.getAnnualSalary()));
    }

    @Test
    public void getAllEmployeesWithAnnualSalaryTest_empty() {
        Mockito.when(facade.getEmployees()).thenReturn(Collections.EMPTY_LIST);
        List<EmployeeDTO> employeesDtosList = employeeService.getEmployeesWithAnnualSalary();
        assertNotNull(employeesDtosList);
        assertEquals(0, employeesDtosList.size());
    }

    @Test
    public void getEmployeesWithAnnualSalaryTestByIdWithMonthlySalaryEmployeeContract() {
        employee.setContractTypeName("MonthlySalaryEmployee");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(facade.getEmployees()).thenReturn(employees);
        List<EmployeeDTO> employeesDtosList = employeeService.getEmployeesWithAnnualSalary(Arrays.asList(1));
        assertNotNull(employeesDtosList);
        assertEquals(1, employeesDtosList.size());


        EmployeeDTO dto = employeesDtosList.get(0);
        assertEquals(employee.getId(), dto.getId());
        assertEquals(employee.getContractTypeName(), dto.getContractTypeName());
        assertEquals(employee.getName(), dto.getName());
        assertEquals(employee.getRoleId(), dto.getRoleId());
        assertEquals(employee.getRoleName(), dto.getRoleName());
        assertEquals(employee.getRoleDescription(), dto.getRoleDescription());
        assertEquals(employee.getHourlySalary(), dto.getHourlySalary());
        assertEquals(employee.getMonthlySalary(), dto.getMonthlySalary());
        assertEquals(0, new BigDecimal("9600000").compareTo(dto.getAnnualSalary()));
    }

    @Test
    public void getEmployeesWithAnnualSalaryTestByWrongIdWithMonthlySalaryEmployeeContract() {
        employee.setContractTypeName("MonthlySalaryEmployee");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);


        Mockito.when(facade.getEmployees()).thenReturn(employees);
        List<EmployeeDTO> employeesDtosList = employeeService.getEmployeesWithAnnualSalary(Arrays.asList(10));
        assertNotNull(employeesDtosList);
        assertEquals(0, employeesDtosList.size());

    }


}
