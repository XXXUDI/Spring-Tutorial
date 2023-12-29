package com.soCompany.service;

import com.soCompany.database.UserRepository;
import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.mapper.UserEditCreateMapper;
import com.soCompany.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserEditCreateMapper userEditCreateMapper;


}
