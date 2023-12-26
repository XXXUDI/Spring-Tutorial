package com.soCompany.mapper;

import com.soCompany.dto.CompanyReadDto;
import com.soCompany.entity.Company;

public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
