package backend.challenge.masglobal.controller;

import backend.challenge.masglobal.service.EmployeeDTO;
import backend.challenge.masglobal.service.IEmployeeService;
import backend.challenge.masglobal.utils.Constants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/annualSalaries/all")
    @ApiOperation(value = "Gets all employees with annual salaries info.", tags = { Constants.EMPLOYEE_TAG })
    public List<EmployeeDTO> employeesWithAnnualSalaries() {
        return employeeService.getEmployeesWithAnnualSalary();
    }

    @GetMapping("/annualSalaries/id={employeeId}")
    @ApiOperation(value = "Gets employees by ID with annual salaries info.", tags = { Constants.EMPLOYEE_TAG })
    @ApiImplicitParams(
            @ApiImplicitParam(required = true, value = "Employees id", name = "employeeId", paramType = "path", allowMultiple = true))
    public List<EmployeeDTO> employeesByIdWithAnnualSalaries(@PathVariable List<Integer> employeeId) {
        return employeeService.getEmployeesWithAnnualSalary(employeeId);
    }
}
