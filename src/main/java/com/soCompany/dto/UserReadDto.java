package com.soCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class UserReadDto {
    private Integer id;

    private CompanyReadDto company;

    private String firstName;

    private String lastName;

    private String position;

    private BigDecimal salary;

    @DateTimeFormat
    private Date hireDate;

}
