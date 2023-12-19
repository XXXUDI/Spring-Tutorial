package com.soCompany.SpringBootTutorial.Integration.repository;

import com.soCompany.SpringBootTutorial.annotations.IT;
import com.soCompany.database.CompanyRepository;
import com.soCompany.database.EmployeeRepository;
import com.soCompany.database.UserRepository;
import com.soCompany.entity.Company;
import com.soCompany.entity.Employee;
import com.soCompany.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.sql.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@Transactional
public class CompanyRepositoryTest {

    private static final Integer APPLE_COMPANY = 68;

    @Autowired
    private EntityManager manager;

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void printAllUser() {
        var employees = employeeRepository.findAll();
        if(!employees.isEmpty()) {
            for(Employee employee : employees) {
                System.out.println(employee.getId() + " Name: " + employee.getFirstName() + ": " + employee.getSalary());
            }
        }
    }

    @Test
    void testPageable() {
        var pageable = PageRequest.of(1, 1, Sort.by("salary").descending());
        var employees = employeeRepository.findAllBy(pageable);
        employees.forEach(e -> System.out.println(e.getFirstName()));

    }

    @Test
    void findById() {
        var company = manager.find(Company.class, 1);
        assertEquals(company.getName(), "Company A");
    }

    @Test
    void save() {
        Company company = Company.builder()
                .name("Apple")
                .foundedDate(new Date(2000, 1, 1))
                .industry("Tech")
                .build();

        manager.persist(company);
    }

    @Test
    void delete() {
        Optional<Company> optionalCompany = repository.findById(APPLE_COMPANY);
        assertTrue(optionalCompany.isPresent());
        optionalCompany.ifPresent(repository::delete);
        manager.flush();
        assertTrue(repository.findById(APPLE_COMPANY).isEmpty());
    }

    @Test
    void findByFragment() {
//        var maybeCompany = repository.findAllByNameContainingIgnoreCase("Company");
//        assertTrue((maybeCompany.size()) > 1);
        var company = repository.findByName("Apple");
        assertTrue(company.isPresent());
    }

    @Test
    void findEmployeeByFragment() {
        var expected = employeeRepository.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("J", "S");
        assertFalse(expected.isEmpty());
        var actual = employeeRepository.findAllByNamesContaining("J", "S");
        assertFalse(actual.isEmpty());

        assertEquals(expected, actual);
    }

    @Test
    void updatePosition() {
        var actual = employeeRepository.updatePosition("Pilot", 1, 2);
        assertEquals(2, actual);
    }

    @Test
    void checkMaxSalary() {
        var emp = employeeRepository.findFirstBySalaryIsNotNullOrderBySalaryDesc();
        assertFalse(emp.isEmpty());
        emp.ifPresent(
                e -> System.out.println(e.getSalary())
        );
    }

    @Test
    void findTop3HeightEmployeeBySalary() {
        var empls = employeeRepository.findFirst3BySalaryIsNotNullOrderBySalaryDesc();
        assertFalse(empls.isEmpty());
        for(Employee employee : empls) {
            System.out.println(employee.getFirstName() + ": " + employee.getSalary());
        }
    }

    @Test
    void findFirst3() {
        var employees = employeeRepository.findFirst3By(Sort.by("salary").and(Sort.by("id")).descending());
        assertFalse(employees.isEmpty());
        for(Employee employee : employees) {
            System.out.println(employee.getFirstName() + ": " + employee.getSalary());
        }
    }
}

