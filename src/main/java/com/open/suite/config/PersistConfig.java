package com.open.suite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@Configuration
@ComponentScan(basePackages= {"com.open.suite.service", "com.open.suite.service.hibernate"})
public class PersistConfig {

}
