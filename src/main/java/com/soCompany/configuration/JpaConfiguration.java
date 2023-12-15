package com.soCompany.configuration;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

}
