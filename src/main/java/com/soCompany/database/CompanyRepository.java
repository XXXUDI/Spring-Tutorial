package com.soCompany.database;

import com.soCompany.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {
    public Optional<Company> findById(Integer id) {
        System.out.println("CompanyRepository: findById method");
        return Optional.of(new Company(id));
    }
}
