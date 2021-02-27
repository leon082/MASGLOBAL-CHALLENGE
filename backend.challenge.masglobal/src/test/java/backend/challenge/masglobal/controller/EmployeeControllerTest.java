package backend.challenge.masglobal.controller;

import backend.challenge.masglobal.facade.model.Employee;
import backend.challenge.masglobal.service.EmployeeDTO;
import backend.challenge.masglobal.service.impl.EmployeeServiceImpl;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {



    @InjectMocks
    private EmployeeController controller;

    @Mock
    private EmployeeServiceImpl employeeService;

    private EmployeeDTO employeeDTO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setHourlySalary(new BigDecimal("50000"));
        employee.setMonthlySalary(new BigDecimal("800000"));
        employee.setName("Leon");
        employee.setRoleId(1);
        employee.setRoleName("Role Name");
        employee.setRoleDescription("Role Description");
        employeeDTO = new EmployeeDTO(employee);
    }

    @Test
    public void employeesWithAnnualSalariesTestWithHourlySalaryEmployeeContract() {
        employeeDTO.setContractTypeName("HourlySalaryEmployee");

        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        employeesDTO.add(employeeDTO);

        Mockito.when(employeeService.getEmployeesWithAnnualSalary()).thenReturn(employeesDTO);
        List<EmployeeDTO> employeesDtosList = controller.employeesWithAnnualSalaries();
        assertNotNull(employeesDtosList);
        assertEquals(1, employeesDtosList.size());
    }

    @Test
    public void employeesWithAnnualSalariesByIdTestWithHourlySalaryEmployeeContract() {
        employeeDTO.setContractTypeName("HourlySalaryEmployee");

        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        employeesDTO.add(employeeDTO);

        Mockito.when(employeeService.getEmployeesWithAnnualSalary(Arrays.asList(1))).thenReturn(employeesDTO);
        List<EmployeeDTO> employeesDtosList = controller.employeesByIdWithAnnualSalaries(Arrays.asList(1));
        assertNotNull(employeesDtosList);
        assertEquals(1, employeesDtosList.size());
    }




}
