package com.soCompany.service;

import com.soCompany.database.EmployeeRepository;
import com.soCompany.database.UserRepository;
import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.Employee;
import com.soCompany.mapper.UserEditCreateMapper;
import com.soCompany.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final EmployeeRepository repository;
    private final UserReadMapper userReadMapper;
    private final UserEditCreateMapper userEditCreateMapper;

    public List<UserReadDto> findAll() {
        return repository.findAll().stream().map(userReadMapper::map).toList();
    }

    public Optional<UserReadDto> findById(Integer id) {
        return repository.findById(id).map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserEditCreateDto readDto) {
        return Optional.of(readDto)
                .map(userEditCreateMapper::map)
                .map(repository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Integer id, UserEditCreateDto userDto) {
        return repository.findById(id)
                .map(employee -> userEditCreateMapper.map(userDto, employee))
                .map(repository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return repository.findById(id)
                .map(employee -> {
                    repository.delete(employee);
                    repository.flush();
                    return true;
                }).orElse(false);
    }
}
