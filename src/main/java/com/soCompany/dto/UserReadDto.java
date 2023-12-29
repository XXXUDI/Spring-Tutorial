package com.soCompany.dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
public class UserReadDto {
    private Integer id;

    private CompanyReadDto company;

    private String firstName;

    private String lastName;

    private String position;

    private BigDecimal salary;

    private Date hireDate;

}