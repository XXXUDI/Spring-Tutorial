package com.soCompany;

import com.soCompany.entity.Company;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired
    private EntityManager entityManager;

    public void is() {
        if(entityManager != null) {
            System.out.println("Works!");
        }
    }

    public String findBy(Integer id) {
        var company = entityManager.find(Company.class, id);
        return company.getName();
    }
}
