package com.soCompany.service;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.CompanyReadDto;
import com.soCompany.listener.AccessType;
import com.soCompany.listener.EntityEvent;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@ToString
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id).map(entity -> {
            log.info("Trying to publish event.");
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            log.info("event has been published");
            return new CompanyReadDto(entity.getId(), entity.getName());
        });
    }
}