package com.soCompany.entity;


import com.soCompany.entity.interfaces.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "company_id")
    private Integer companyID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    public Employee(Integer companyID,
                    String firstName,
                    String lastName,
                    String position,
                    BigDecimal salary,
                    Date hireDate) {
        this.companyID = companyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
