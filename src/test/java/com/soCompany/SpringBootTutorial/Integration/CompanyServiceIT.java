package com.soCompany.SpringBootTutorial.Integration;

import com.soCompany.ApplicationRunner;
import com.soCompany.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ApplicationRunner.class)
@ActiveProfiles("test")
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;

    @Test
    void findById() {

    }

}
