package backend.challenge.masglobal.service;

import backend.challenge.masglobal.facade.model.Employee;
import backend.challenge.masglobal.service.strategy.ICalculateAnnualSalaryStrategy;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDTO {

    @ApiModelProperty(value = "Employee's id")
    private int id;

    @ApiModelProperty(value = "Employee's name")
    private String name;

    @ApiModelProperty(value = "Employee's contract type name")
    private String contractTypeName;

    @ApiModelProperty(value = "Employee's role id")
    private int roleId;

    @ApiModelProperty(value = "Employee's role name")
    private String roleName;

    @ApiModelProperty(value = "Employee's role description")
    private String roleDescription;

    @ApiModelProperty(value = "Employee's hourly salary")
    private BigDecimal hourlySalary;

    @ApiModelProperty(value = "Employee's monthly salary")
    private BigDecimal monthlySalary;

    @ApiModelProperty(value = "Employee's annual salary", required = false)
    private BigDecimal annualSalary;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.contractTypeName = e.getContractTypeName();
        this.roleId = e.getRoleId();
        this.roleName = e.getRoleName();
        this.roleDescription = e.getRoleDescription();
        this.hourlySalary = e.getHourlySalary();
        this.monthlySalary = e.getMonthlySalary();
    }
    public void calculateAnnualSalary(ICalculateAnnualSalaryStrategy strategy){
            setAnnualSalary(strategy.calculateAnnualSalary());
    }
}
