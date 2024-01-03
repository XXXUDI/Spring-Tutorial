package com.soCompany.dto;

import jakarta.persistence.Column;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@Value
public class UserEditCreateDto {
    private Integer id;

    private Integer companyId;

    private String firstName;

    private String lastName;

    private String position;

    private BigDecimal salary;

    @DateTimeFormat(pattern = "dd=MM-yyyy")
    private Date hireDate;
}
