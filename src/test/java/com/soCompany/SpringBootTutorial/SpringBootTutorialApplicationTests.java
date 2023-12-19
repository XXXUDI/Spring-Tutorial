package com.soCompany.SpringBootTutorial;

import com.soCompany.ApplicationRunner;
import com.soCompany.entity.Company;
import com.soCompany.service.UserService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ApplicationRunner.class)
class SpringBootTutorialApplicationTests {

	@Autowired
	private UserService service;

	@Autowired
	private EntityManager manager;
	@Test
	void contextLoads() {
		var obj = manager.find(Company.class, 1);

		System.out.println(obj.getName());
	}

}

