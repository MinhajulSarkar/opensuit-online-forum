package com.open.suite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.open.suite.service", "com.open.suite.service.hibernate"})
public class PersistConfig {

}
