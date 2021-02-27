package backend.challenge.masglobal.facade.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String contractTypeName;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private BigDecimal hourlySalary;
    private BigDecimal monthlySalary;
}
