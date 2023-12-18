package com.soCompany.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "first_name")
    private Integer company_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "hire_date")
    private Date hireDate;

    public Employee(Integer company_id,
                    String firstName,
                    String lastName,
                    String position,
                    Integer salary,
                    Date hireDate) {
        this.company_id = company_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
