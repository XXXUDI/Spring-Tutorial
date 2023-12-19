package com.soCompany.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeInfo {

    private final Integer id;
    private final String firstName;
    private final Integer company_id;

    public EmployeeInfo(Integer id, String firstName, Integer company_id) {
        this.id = id;
        this.firstName = firstName;
        this.company_id = company_id;
    }
}

