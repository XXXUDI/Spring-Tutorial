package com.soCompany.dto;

import com.soCompany.database.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

    @Autowired
    private ConnectionPool connectionPool;
}
