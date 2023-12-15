package com.soCompany.database;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
@Slf4j
public class ConnectionPool {
    private String password;
    private String username;
    private String url;
    private Integer poolSize;


    public ConnectionPool(@Value("${db.password}") String password,
                          @Value("${db.username}") String username,
                          @Value("${db.url}")String url,
                          @Value("${db.poolSize}")Integer poolSize) {
        this.password = password;
        this.username = username;
        this.url = url;
        this.poolSize = poolSize;
    }

    @PostConstruct
    public void print(){
        log.info("Init C. Pool");
    }
}
