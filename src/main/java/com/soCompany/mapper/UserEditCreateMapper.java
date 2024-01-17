package com.soCompany.mapper;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.entity.Company;
import com.soCompany.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserEditCreateMapper implements Mapper<UserEditCreateDto, Employee>{

    // This method is for update method is service class. We don`t need to create new user, because we already have.
    @Override
    public Employee map(UserEditCreateDto fromObject, Employee toObject) {
        toObject.setFirstName(fromObject.getFirstName());
        toObject.setLastName(fromObject.getLastName());
        toObject.setPosition(fromObject.getPosition());
        toObject.setSalary(fromObject.getSalary());
        toObject.setCompanyID(fromObject.getCompanyId());
//        toObject.setHireDate(fromObject.getHireDate());
        return toObject;
    }

    @Override
    public Employee map(UserEditCreateDto object) {
        return Employee.builder()
                .id(object.getId())
                .salary(object.getSalary())
                .position(object.getPosition())
//                .hireDate(object.getHireDate())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .companyID(object.getCompanyId()).build();
    }
}
