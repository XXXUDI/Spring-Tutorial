package com.soCompany.service;

import com.soCompany.dto.UserDto;
import com.soCompany.database.UserRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ToString
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDto userDto;


}
