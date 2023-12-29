package com.soCompany.mapper;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.CompanyReadDto;
import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.Company;
import com.soCompany.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<Employee, UserReadDto>
{

    private final CompanyRepository companyRepository;
    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(Employee object) {
        CompanyReadDto dto = companyReadMapper
                .map(Objects.requireNonNull(companyRepository.findById(object.getCompanyID()).orElse(null)));

        return new UserReadDto(
                object.getId(),
                dto,
                object.getFirstName(),
                object.getLastName(),
                object.getPosition(),
                object.getSalary(),
                object.getHireDate()
        );
    }
}
