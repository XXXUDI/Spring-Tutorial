package com.soCompany.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
public class UserEditCreateDto {
    private Integer id;

    private Integer companyId;

    private String firstName;

    private String lastName;

    private String position;

    private BigDecimal salary;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    Date hireDate;

}
