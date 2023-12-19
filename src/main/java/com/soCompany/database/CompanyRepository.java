package com.soCompany.database;

import com.soCompany.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);

}
