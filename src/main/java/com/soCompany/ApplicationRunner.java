package com.soCompany;

import com.soCompany.database.ConnectionPool;
import com.soCompany.database.EmployeeRepository;
import com.soCompany.service.CompanyService;
import com.soCompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class);
    }
}
