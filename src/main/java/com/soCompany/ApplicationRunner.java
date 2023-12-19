package com.soCompany;

import com.soCompany.database.ConnectionPool;
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

        System.out.println(context.getBean(ConnectionPool.class));

        var userService = context.getBean(UserService.class);
        System.out.println(userService);

        var companyService = context.getBean(CompanyService.class);
        // here is the smallest change in the code just to test how push is works
        companyService.findById(6);


        Test test = context.getBean(Test.class);
        test.is();
        System.out.println(test.findBy(1));
    }
}
