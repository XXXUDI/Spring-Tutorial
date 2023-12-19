package com.soCompany.SpringBootTutorial;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.CompanyReadDto;
import com.soCompany.entity.Company;
import com.soCompany.listener.EntityEvent;
import com.soCompany.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class CompanyServiceTest {
    private final Integer COMPANY_ID = 1;
    @Mock
    private CompanyRepository repository;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
//        Mockito.doReturn(Optional.of(new Company(COMPANY_ID)))
//                .when(repository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        verify(applicationEventPublisher).publishEvent(EntityEvent.class);
    }
}
