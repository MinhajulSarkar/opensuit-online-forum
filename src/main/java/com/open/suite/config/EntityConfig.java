package com.open.suite.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@Configuration
@EntityScan(basePackages= {"com.open.suite.domain"})
public class EntityConfig {

}
