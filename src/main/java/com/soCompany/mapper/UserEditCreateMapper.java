package com.soCompany.mapper;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.entity.Company;
import com.soCompany.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserEditCreateMapper implements Mapper<UserEditCreateDto, Employee>{

    private final CompanyRepository companyRepository;

    @Override
    public Employee map(UserEditCreateDto object) {
        return null;
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }
}
