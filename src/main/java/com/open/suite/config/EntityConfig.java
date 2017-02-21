package com.open.suite.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages= {"com.open.suite.domain"})
public class EntityConfig {

}
